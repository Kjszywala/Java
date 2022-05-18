package com.mycompany.checkersgame2;

import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kamil
 */
public class ClientThreadChat extends Thread {
    
    private BufferedReader in; // strumień do słuchania serwera
    public NewGame dialog; // okno właściciel
        
    public ClientThreadChat(NewGame dialog) {
        this.dialog = dialog;
         // kojarzę strumień z gniazdem
        try {
            in = new BufferedReader(new InputStreamReader(
                                    dialog.socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
    String str=null;
    try {
        while ((str = in.readLine()) != null) {
            //aż nie będzie końca pliku
            // dopisuję co przeczytałem z gniazda
            str = in.readLine();
            dialog.textArea.append(str + "\n");
            // poniższe by widzieć ostatni wpis do JTextArea ‘lista’
            dialog.textArea.scrollRectToVisible(new Rectangle
                (0, dialog.textArea.getHeight()-2, 1, 1));
            dialog.textArea.repaint();
        }
    in.close(); //Zamykam strumień wejściowy od serwera
    } catch (IOException e) { 
        dialog.textArea.append("Error: " + e); 
    }
    } 
}

