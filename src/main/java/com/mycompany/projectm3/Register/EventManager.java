package com.mycompany.projectm3.Register;

import java.util.ArrayList;

/**
 * Handles the events that have occurred in the system.
 */
public class EventManager {
    private ArrayList<Event> eventList;

    /**
     * Creates a new EventManager and loads the events from the file.
     */
    public EventManager(){
        // TODO - Read from file
        this.eventList = new ArrayList<>();
    }

    /**
     * Adds a new event to the list.
     * @param event
     */
    public void addRegister(Event event){
        this.eventList.add(event);
    }

    /**
     * Removes an event from the list.
     * @param event
     */
    public void removeRegister(Event event){
        this.eventList.remove(event);
    }

    /**
     * Returns the list of events.
     * @return ArrayList<Event>
     */
    public ArrayList<Event> getRegisterList(){
        return this.eventList;
    }

    /**
     * Sets the list of events.
     * @param eventList
     */
    public void setRegisterList(ArrayList<Event> eventList){
        this.eventList = eventList;
    }
}
