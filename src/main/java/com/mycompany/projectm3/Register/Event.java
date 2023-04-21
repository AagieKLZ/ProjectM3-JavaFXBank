package com.mycompany.projectm3.Register;

import com.mycompany.projectm3.lib.TimeHandler;

public class Event {
    private long timestamp;
    private String source;
    private String eventType;

    public Event(String source, String eventType){
        this.timestamp = TimeHandler.getCurrentTimestamp();
        this.source = source;
        this.eventType = eventType;
    }
}
