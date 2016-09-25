package mx.iteso.observer.impl;

import mx.iteso.observer.Displayable;
import mx.iteso.observer.Observer;
import mx.iteso.observer.Subject;

import java.util.ArrayList;

public class StoreMonitorDisplay implements Observer, Displayable {
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    private boolean receive;
    private Subject scoresData;
    private ArrayList<PlayerData> players;

    public StoreMonitorDisplay(Subject scoresData){
        this.scoresData = scoresData;
        this.scoresData.registerObserver(this);
    }

    public String display() {
        System.out.println("Latest score is:");
        System.out.println(homeTeam + " (HOME) " + homeGoals + " - " + awayTeam + " (AWAY) " + awayGoals);
        if(players.size()>0)
        System.out.println("Scorers:");
        for(PlayerData player:players)
        {
            System.out.println(player.name+" "+player.number+" "+player.position+" "+player.team);
        }
        return "";
    }

    public void update(String home, String away, int homeGoals, int awayGoals, ArrayList<PlayerData> players) {
        this.homeTeam = home;
        this.awayTeam = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.players=players;
        display();
    }

    public boolean EnableNotification()
    {
        receive=true;
        return true;
    }
    public boolean DisableNotification()
    {
        this.receive=false;
        return true;
    }

    public boolean getNotificationState() {
        return receive;
    }


}
