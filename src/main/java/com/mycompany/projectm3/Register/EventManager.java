package com.mycompany.projectm3.Register;

import java.util.ArrayList;

public class EventManager {
    private ArrayList<Event> eventList;
    public void addRegister(Event event){
        this.eventList.add(event);
    }
    public void removeRegister(Event event){
        this.eventList.remove(event);
    }
    public ArrayList<Event> getRegisterList(){
        return this.eventList;
    }
    public void setRegisterList(ArrayList<Event> eventList){
        this.eventList = eventList;
    }
}
