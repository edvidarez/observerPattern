package mx.iteso.observer.impl;

import mx.iteso.observer.Observer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ScoresDataTest {
    ScoresData scoresData;
    Observer observer;
    ArrayList<PlayerData> players;
    MobileMonitorDisplay mobileChino ;
    @Before
    public void setUp() {
        scoresData = new ScoresData();
        observer = mock(Observer.class);
        players = new ArrayList<PlayerData>();
        mobileChino = mock (MobileMonitorDisplay.class);
        when(mobileChino.DisableNotification()).thenCallRealMethod();
        when(mobileChino.EnableNotification()).thenCallRealMethod();
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testRegisterAndRemoveObserver() {
        scoresData.registerObserver(observer);
        scoresData.removeObserver(observer);
        scoresData.removeObserver(observer);
    }

    @Test
    public void testSetScore() {
        players.add(new PlayerData("Hulk",5,"GoalKeeper","ITESOFC"));
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        scoresData.setScore("testTeam", "testTeam2", 1, 0,players);
        verify(observer, times(2)).update("testTeam", "testTeam2", 1, 0,players);
    }

    @Test
    public void mobileTestDisplay(){
        players.add(new PlayerData("Hulk",5,"GoalKeeper","ITESOFC"));
        scoresData.registerObserver(mobileChino);
        scoresData.setScore("testTeam", "testTeam2", 1, 0,players);
        verify(mobileChino, times(1)).update("testTeam", "testTeam2", 1, 0,players);
    }
    @Test
    public void testMobileScore(){

        MobileMonitorDisplay mobileApp = new MobileMonitorDisplay(scoresData);
        mobileApp.DisableNotification();
        mobileApp.EnableNotification();
        assertEquals(true,mobileApp.getNotificationState());

    }
    @Test
    public void testMobileScoreDisable(){

        MobileMonitorDisplay mobileApp = new MobileMonitorDisplay(scoresData);
        mobileApp.DisableNotification();
        assertEquals(false,mobileApp.getNotificationState());

    }
    @Test
    public void TestMobileScoreDisable(){
        MobileMonitorDisplay mobileApp = new MobileMonitorDisplay(scoresData);
        assertEquals(true,mobileApp.DisableNotification());
    }
    @Test
    public void TestMobileScoreEnable(){
        MobileMonitorDisplay mobileApp = new MobileMonitorDisplay(scoresData);
        assertEquals(true,mobileApp.EnableNotification());
    }
}
