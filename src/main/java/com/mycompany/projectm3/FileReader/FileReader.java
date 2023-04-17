package com.mycompany.projectm3.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

abstract class FileReader {
    protected final String path = "";
    protected File file;
    protected Scanner scanner;

    public FileReader(){
        this.scanner = new Scanner(this.path);
        this.file = new File(this.path);
        if(!this.fileExists()){
            this.createFile();
        }
    }

    public ArrayList<String> read(){
        ArrayList<String> lines = new ArrayList<String>();
        while(this.scanner.hasNextLine()){
            lines.add(this.scanner.nextLine());
        }
        return lines;
    }

    public void write(ArrayList<String> lines){
        ArrayList<String> currentLines = this.read();
        for(String line : lines){
            currentLines.add(line);
        }
        /* TODO - Write to file */
    }

    private boolean fileExists(){
        return this.file.exists();
    }

    private void createFile(){
        try{
            this.file.createNewFile();
        }catch(Exception e){
            System.out.println("File already exists");
        }
    }
}