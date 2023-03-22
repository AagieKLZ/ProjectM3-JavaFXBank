/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectm3;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 *
 * @author alumne
 */
public class Navigator {
    private static Parent loadFXML (String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void gotoPage(String pt, Button bt) throws IOException{
        Scene scene = bt.getScene();
         scene.setRoot(loadFXML(pt));
    }
    
    public static void gotoPage(String pt, Label lb) throws IOException{
        Scene scene = lb.getScene();
        scene.setRoot(loadFXML(pt));
    }
}

