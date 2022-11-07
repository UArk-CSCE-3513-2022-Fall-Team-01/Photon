package team01.photon;

import java.time.Duration;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.Timer;

public class CountdownTimer implements GameTimer{

    private Duration duration;
    private EventListenerList eventListener;
    private Timer timer;
    private int initialVal = 0;

    public CountdownTimer(){
        eventListener = new EventListenerList();
        this.duration = Duration.ofSeconds(initialVal);
        
    }
    public CountdownTimer(Duration duration){
        eventListener = new EventListenerList();
        this.duration = duration;
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        eventListener.add(ChangeListener.class, listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        eventListener.remove(ChangeListener.class, listener);
    }

    @Override
    public void clearChangeListeners() {
        eventListener = new EventListenerList();
        
    }
    @Override
    public void setTime(Duration duration) {
        this.duration = duration;
    }
    @Override
    public Duration getTime() {
        return duration;
    }

    @Override
    public int getTimeInSeconds() {
        long durationInSeconds = 0;
        durationInSeconds = duration.getSeconds();
        return (int)durationInSeconds;
    }

    @Override
    public void setTime(int seconds) {
        long time = seconds;
        this.duration = Duration.ofSeconds(time);
    }

    @Override
    public void start() {
        
    }
    
}
