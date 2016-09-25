package mx.iteso.observer.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class StoreMonitorDisplayTest {
    private StoreMonitorDisplay storeMonitorDisplay;
    private ArrayList<PlayerData> players;
    private ScoresData scoresData;

    @Before
    public void setUp() {
        scoresData = mock(ScoresData.class);
        storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
        players = new ArrayList<PlayerData>();
    }

    @Test
    public void testUpdate() {
        players.add(new PlayerData("Hulk",5,"goalkeeper","ITESOFC"));
        storeMonitorDisplay.update("homeTeam", "awayTeam", 1, 0,players);
        assert ("".equals(storeMonitorDisplay.display()));
       // Nothing to assert or verify for now
    }
    @Test
    public void testMobileScore(){


        storeMonitorDisplay.DisableNotification();
        storeMonitorDisplay.EnableNotification();
        assertEquals(true,storeMonitorDisplay.getNotificationState());

    }
    @Test
    public void testMobileScoreDisable(){

        storeMonitorDisplay.DisableNotification();
        assertEquals(false,storeMonitorDisplay.getNotificationState());

    }
    @Test
    public void TestMobileScoreDisable(){

        assertEquals(true,storeMonitorDisplay.DisableNotification());
    }
    @Test
    public void TestMobileScoreEnable(){

        assertEquals(true,storeMonitorDisplay.EnableNotification());
    }
}
