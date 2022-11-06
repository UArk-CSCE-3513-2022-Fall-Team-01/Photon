package team01.photon;

import javax.swing.event.ChangeListener;

public interface ChangeNotifier {
    public void addChangeListener(ChangeListener listener);

    public void removeChangeListener(ChangeListener listener);

    public void clearChangeListeners();
}
