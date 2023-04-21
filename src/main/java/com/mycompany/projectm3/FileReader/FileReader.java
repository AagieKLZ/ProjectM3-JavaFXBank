package com.mycompany.projectm3.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Abstract class for reading and writing to files
 */
abstract class FileReader {
    protected final String path = "";
    protected File file;
    protected Scanner scanner;

    /**
     * Creates a new FileReader object for a given file path and creates the file if it does not exist
     */
    public FileReader(){
        this.scanner = new Scanner(this.path);
        this.file = new File(this.path);
        if(!this.fileExists()){
            this.createFile();
        }
    }

    /**
     * Reads the file and returns an ArrayList with each line as an element
     * @return each line of the file
     */
    public ArrayList<String> read(){
        ArrayList<String> lines = new ArrayList<String>();
        while(this.scanner.hasNextLine()){
            lines.add(this.scanner.nextLine());
        }
        return lines;
    }

    /**
     * Writes an ArrayList of lines to the file
     * @param lines
     */
    public void write(ArrayList<String> lines){
        ArrayList<String> currentLines = this.read();
        for(String line : lines){
            currentLines.add(line);
        }
        /* TODO - Write to file */
    }

    /**
     * Checks if the file exists
     * @return true if the file exists, false otherwise
     */
    private boolean fileExists(){
        return this.file.exists();
    }

    /**
     * Creates a new file if it does not exist
     */
    private void createFile(){
        try{
            this.file.createNewFile();
        }catch(Exception e){
            System.out.println("File already exists");
        }
    }
}