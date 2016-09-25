package mx.iteso.observer.impl;

import mx.iteso.observer.Displayable;
import mx.iteso.observer.Observer;
import mx.iteso.observer.Subject;

import java.util.ArrayList;

/**
 * Created by Edmundo on 22/09/2016.
 */
public class MobileMonitorDisplay implements Observer,Displayable {
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    private Subject scoresData;
    private boolean receive =true;
    private ArrayList<PlayerData> players;

    public MobileMonitorDisplay(Subject scoresData){
        this.scoresData = scoresData;
        this.scoresData.registerObserver(this);
    }

    public String display() {
        String ret = "";
        if(receive) {

            System.out.println("Jamaicon Sport Mobile app:");
            ret += "Jamaicon Sport Mobile app:\n"+"Latest score is:\n";
            System.out.println("Latest score is:");
            System.out.println(homeTeam + " (HOME) " + homeGoals + " - " + awayTeam + " (AWAY) " + awayGoals);
            ret += homeTeam + " (HOME) " + homeGoals + " - " + awayTeam + " (AWAY) " + awayGoals+"\n";

            if (players.size() > 0)
                System.out.println("Scorers:");
            ret += "Scorers:\n";
            for (PlayerData player : players) {
                System.out.println(player.name + " " + player.number + " " + player.position + " " + player.team);
                ret += player.name + " " + player.number + " " + player.position + " " + player.team+ "\n";
            }
            return ret;

        }
        else
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
