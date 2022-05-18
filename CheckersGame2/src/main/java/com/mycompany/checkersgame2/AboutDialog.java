package com.mycompany.checkersgame2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author kamil.szywala
 */
public class AboutDialog extends JFrame implements ActionListener{
    /**
     * Variables needed for the dialog
     */
    private JTextArea info;
    private JButton ok;
    /**
     * Constructor of the "About" dialog with interface look
     */
    public AboutDialog(){
        super("About");
        String path = System.getProperty("user.dir");
        ImageIcon img = new ImageIcon(path + "\\src\\main\\java\\com\\mycompany\\checkers\\checkers.png");
        JPanel panel = new JPanel(new BorderLayout());
        setIconImage(img.getImage());
        panel.setBackground(Color.WHITE);
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        JPanel headerBottom = new JPanel(new BorderLayout());
        headerBottom.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        info = new JTextArea();
        info.setEditable(false);
        info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ok = new JButton("  Ok  ");
        ok.setBackground(Color.WHITE);
        ok.addActionListener((ActionListener) this);
        panel.add(info, BorderLayout.CENTER);
        panel.add(header, BorderLayout.SOUTH);
        headerBottom.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        header.add(headerBottom, BorderLayout.SOUTH);
        headerBottom.add(ok, BorderLayout.EAST);
        setInfo();
        setSize(400,400);
        setContentPane(panel);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    /**
     * Sets the information about program in the text area.
     */
    public void setInfo(){
        info.setText("""
                     Checkers by Kamil Szywala
                     Version 1.0 - 21/04/2022, 16:37:00
                     Copyright Kamil Szywala, England 2022 All rights reserved.
                     This program was created for Wyzsza Szkola Biznesu -
                     National-Louis University in the purpose of 
                     end-semester project from 
                     Advanced Application Programming in JAVA
                     """);
    }
    /**
     * Ok button for closing the window.
     */
    public void okButton(){
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    /**
     * Action listener for buttons.
     * @param e 
     */
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "  Ok  " -> okButton();
        }
    }
}
