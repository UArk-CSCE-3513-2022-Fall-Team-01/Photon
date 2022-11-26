package team01.photon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.Timer;

public class CountdownTimer implements GameTimer, ActionListener {

    private Duration duration;
    private EventListenerList eventListener;
    private Timer timer;

    public CountdownTimer() {
        this(Duration.ofSeconds(30));
    }

    public CountdownTimer(Duration duration) {
        eventListener = new EventListenerList();
        this.duration = duration;

        timer = new Timer(1000, this);
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
        return (int) durationInSeconds;
    }

    protected void fireChangeEvent() {
        for (ChangeListener tmp : eventListener.getListeners(ChangeListener.class)) {
            tmp.stateChanged(new ChangeEvent(this));
        }
    }

    @Override
    public void setTime(int seconds) {
        long time = seconds;
        this.duration = Duration.ofSeconds(time);
    }

    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        fireChangeEvent();
        duration = duration.minusSeconds(1);

        if (duration.toSeconds() < 0) {
            timer.stop();
        }
    }

}
