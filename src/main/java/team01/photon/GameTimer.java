package team01.photon;

import java.time.Duration;

public interface GameTimer extends ChangeNotifier {
    public Duration getTimeRemaining();
}
