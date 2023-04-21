package com.mycompany.projectm3.Register;

import com.mycompany.projectm3.lib.TimeHandler;

/**
 * Represents an event that has occurred in the system.
 */
public class Event {
    private long timestamp;
    private String source;
    private String eventType;

    /**
     * Creates a new event with the current timestamp.
     * @param source
     * @param eventType
     */
    public Event(String source, String eventType){
        this.timestamp = TimeHandler.getCurrentTimestamp();
        this.source = source;
        this.eventType = eventType;
    }
}
