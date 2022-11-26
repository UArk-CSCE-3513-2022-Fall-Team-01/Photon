package team01.photon;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class NetworkReceiver {
    private int broadcastPort = 7500;
    private int receiverPort = 7501;

    private DatagramSocket broadcastSocket;
    private DatagramSocket receiverSocket;

    public boolean isRunning = false;

    public void Initialize() throws SocketException, IOException
    {
        isRunning = true;
        broadcastSocket = new DatagramSocket(broadcastPort);
        receiverSocket = new DatagramSocket(receiverPort);

        DatagramPacket receivedPacket = null;
        byte[] receivedBytes = new byte[65535];

        while(isRunning)
        {
            receivedPacket = new DatagramPacket(receivedBytes, receivedBytes.length);

            receiverSocket.receive(receivedPacket);

            System.out.println("Received:-" + new String(receivedBytes));
        }
    }

    public void End()
    {
        isRunning = false;
        broadcastSocket.close();
        receiverSocket.close();
    }

}
