package mx.iteso.observer;

import mx.iteso.observer.impl.MobileMonitorDisplay;
import mx.iteso.observer.impl.PlayerData;
import mx.iteso.observer.impl.ScoresData;
import mx.iteso.observer.impl.StoreMonitorDisplay;

import java.util.ArrayList;


public class NewsStation {
    public static void main( String[] args ){
        ScoresData scoresData;
        scoresData = new ScoresData();
        ArrayList<PlayerData> players = new ArrayList<PlayerData>();
        StoreMonitorDisplay storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
        MobileMonitorDisplay mobileMonitorDisplay = new MobileMonitorDisplay(scoresData);
        mobileMonitorDisplay.DisableNotification();

        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Ray",10,"Tacit Knowledge","Striker"));
        players.add(new PlayerData("Tello",6,"Intel","Defender"));

        scoresData.setScore("Tacit Knowledge", "Intel", 8, 1,players);


        players.clear();

        players.add(new PlayerData("Alan P.",10,"Chivas","Striker"));
        players.add(new PlayerData("Alan P.",10,"Chivas","Striker"));
        players.add(new PlayerData("Ronaldinho G.",9,"Queretaro","Midfielder"));

        scoresData.setScore("Chivas", "Queretaro", 2, 1,players);
        players.clear();


        scoresData.setScore("La Ganga", "Muebles America", 0, 0,players);
    }
}
