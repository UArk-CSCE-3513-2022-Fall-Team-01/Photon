package team01.photon;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class NetworkReceiver {
    private final int broadcastPort = 7500;
    private final int receiverPort = 7501;

    public SocketListener receiver;

    private DatagramSocket broadcastSocket;

    public NetworkReceiver()
    {
        receiver = new SocketListener(receiverPort);
    }

    public void StartPlay(GameModel gameModel)
    {
        receiver.gameModel = gameModel;
        receiver.isPlaying = true;
    }

    public void End()
    {
        receiver.isPlaying = false;
        receiver.isRunning = false;
    }

}

class SocketListener extends Thread
{
    public boolean isRunning = true;
    public boolean isPlaying = false;
    DatagramPacket receivedPacket = null;
    byte[] receivedBytes;
    private DatagramSocket socket;
    private int port;
    public GameModel gameModel;

    public void run()
    {
        try {
            socket = new DatagramSocket(port);
        }catch(Exception e){
            e.printStackTrace();
        }

        receivedBytes = new byte[65535];

        while(isRunning){
                receivedPacket = new DatagramPacket(receivedBytes, receivedBytes.length);

                try {
                    socket.receive(receivedPacket);
                }catch(Exception e){
                    e.printStackTrace();
                }

                String receivedString = new String(receivedBytes);

                int perpetrator = Integer.parseInt(receivedString.substring(0,receivedString.indexOf(':')));
                int victim = Integer.parseInt(receivedString.substring(receivedString.indexOf(':') + 1,receivedString.indexOf('\u0000')));
            if(isPlaying){
                gameModel.playerHit(perpetrator,victim);
            }
        }

        socket.close();
    }

    SocketListener(int port){
        this.port = port;
    }
}