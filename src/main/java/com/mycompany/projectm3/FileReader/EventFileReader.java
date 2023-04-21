package com.mycompany.projectm3.FileReader;

import com.mycompany.projectm3.Register.Event;

import java.util.ArrayList;

/**
 * Reads and writes from the events.csv file
 */
public class EventFileReader extends FileReader {
    private final String path = "events.csv";

    /**
     * Constructor
     */
    public EventFileReader() {
        super();
    }

    /**
     * Reads the lines from the file and returns an ArrayList of events
     * @return ArrayList of events from the file
     */
    public ArrayList<Event> readLines(){
        ArrayList<String> lines = this.read();
        ArrayList<Event> events = new ArrayList<>();
        for (String line : lines){
            /*TODO - Read lines*/
        }
        return null;
    }

    /**
     * Writes the events to the file
     * @param events
     */
    public void writeLines(ArrayList<Event> events){
        ArrayList<String> lines = new ArrayList<>();
        for (Event event : events){
            lines.add(event.toString());
        }
        this.write(lines);
    }

}
