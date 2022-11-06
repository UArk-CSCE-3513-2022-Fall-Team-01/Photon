package team01.photon;

import java.time.Duration;

public interface GameTimer extends ChangeNotifier {
    public Duration getTime();

    public int getTimeInSeconds();

    public void setTime(Duration time);

    public void setTime(int seconds);
}
