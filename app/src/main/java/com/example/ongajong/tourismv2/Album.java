package com.example.ongajong.tourismv2;

/**
 * Created by ongajong on 26/11/2017.
 */

public class Album {
    private String travelRoute;
    private String travelCost;
    private String travelTime;
    private int travelIcon;

    public Album(String travelRoute, String travelCost, String travelTime, int travelIcon){
        this.travelCost = travelCost;
        this.travelIcon = travelIcon;
        this.travelRoute = travelRoute;
        this.travelTime = travelTime;
    }
    public int getTravelIcon(){
        return travelIcon;
    }
    public String getTravelRoute(){
        return travelRoute;
    }
    public void setTravelRoute(String travelRoute){
        this.travelRoute = travelRoute;
    }
    public String getTravelTime(){
        return travelTime;
    }
    public void setTravelTime(String travelTime){
        this.travelTime = travelTime;

    }public String getTravelCost(){
        return travelCost;
    }
    public void setTravelCost(String travelCost){
        this.travelCost = travelCost;
    }

}
