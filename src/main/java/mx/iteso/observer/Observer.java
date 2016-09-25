package mx.iteso.observer;

import mx.iteso.observer.impl.PlayerData;

import java.util.ArrayList;


public interface Observer {

    public void update(String home, String away, int homeGoals, int awayGoals, ArrayList<PlayerData> players);
    public boolean EnableNotification();
    public boolean DisableNotification();

    boolean getNotificationState();
}
