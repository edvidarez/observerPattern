package mx.iteso.observer.impl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Edmundo on 24/09/2016.
 */
public class MobileTest {
    private MobileMonitorDisplay mobileMonitorDisplay;
    private ArrayList<PlayerData> players;
    private ScoresData scoresData;

    @Before
    public void setUp() {
        scoresData = mock(ScoresData.class);
        mobileMonitorDisplay = new MobileMonitorDisplay(scoresData);
        players = new ArrayList<PlayerData>();
    }

    @Test
    public void testUpdate() {
        players.add(new PlayerData("Hulk",5,"goalkeeper","ITESOFC"));
        mobileMonitorDisplay.update("homeTeam", "awayTeam", 1, 0,players);
        assertEquals(("Jamaicon Sport Mobile app:\n" +
                "Latest score is:\n" +
                "homeTeam (HOME) 1 - awayTeam (AWAY) 0\n" +
                "Scorers:\n" +
                "Hulk 5 goalkeeper ITESOFC\n"),(mobileMonitorDisplay.display()));
        // Nothing to assert or verify for now
    }
    @Test
    public void testUpdateDisable() {
        players.add(new PlayerData("Hulk",5,"goalkeeper","ITESOFC"));
        mobileMonitorDisplay.DisableNotification();
        mobileMonitorDisplay.update("homeTeam", "awayTeam", 1, 0,players);
        assertEquals((""),(mobileMonitorDisplay.display()));
        // Nothing to assert or verify for now
    }
}
