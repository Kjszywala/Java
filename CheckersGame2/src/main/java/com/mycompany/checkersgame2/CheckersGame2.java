/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.checkersgame2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author kamil.szywala
 */
public class CheckersGame2 extends JFrame implements ActionListener{

    public static void main(String[] args) {
        new CheckersGame2();
    }
    /**
     * Variables needed for main menu interface.
     */
    private JLabel gameName;
    private JButton newGame;
    private JButton options;
    private JButton statistic;
    private JButton about;
    private JButton exit;
    /**
     * Constructor which sets the main menu interface
     */
    public CheckersGame2(){
        super("Checkers v1.0");
        String path = System.getProperty("user.dir");
        ImageIcon img = new ImageIcon(path + "\\src\\main\\java\\com\\mycompany\\checkers\\checkers.png");
        setIconImage(img.getImage());
        setSize(800,600);
        gameName = new JLabel("Checkers");
        gameName.setForeground(Color.decode("#000000"));
        gameName.setFont(new Font("Monospaced", Font.ITALIC, 50));
        newGame = new JButton("New game");
        newGame.setBackground(Color.WHITE);
        options = new JButton("Options");
        options.setBackground(Color.WHITE);
        statistic = new JButton("Statistics");
        statistic.setBackground(Color.WHITE);
        about = new JButton("About");
        about.setBackground(Color.WHITE);
        exit = new JButton("Exit");
        exit.setBackground(Color.WHITE);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,100));
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        panel.add(header, BorderLayout.CENTER);
        JPanel flowTop = new JPanel(new FlowLayout());
        flowTop.setBackground(Color.WHITE);
        header.add(flowTop, BorderLayout.NORTH);
        flowTop.setBorder(BorderFactory.createEmptyBorder(20,180,10,100));
        flowTop.add(gameName);
        header.add(about, BorderLayout.SOUTH);
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        JPanel aboutPanel = new JPanel(new BorderLayout());
        aboutPanel.setBackground(Color.WHITE);
        header.add(menuPanel, BorderLayout.CENTER);
        header.add(aboutPanel, BorderLayout.SOUTH);
        aboutPanel.add(about, BorderLayout.WEST);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(70,180,10,100));
        menuPanel.setLayout(new GridLayout(5, 5, 20, 30));
        menuPanel.add(newGame);
        menuPanel.add(options);
        menuPanel.add(statistic);
        menuPanel.add(exit);
        exit.addActionListener(this);
        about.addActionListener(this);
        newGame.addActionListener(this);
        
        setResizable(false);
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    /**
     * Main menu - Exit function which asking if you are sure
     * to exit the program.
     */
    public void Exit(){
        int reply = JOptionPane.showOptionDialog(
                new JFrame(),
                "Are you sure you want to exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[] { "Yes", "No" }, 
                JOptionPane.YES_OPTION
                );
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        } 
    }
    /**
     * Action listener for main menu buttons
     * @param e 
     */
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "Exit" -> Exit();
            case "About" -> new AboutDialog();
            case "New game" -> new NewGame();
        }
    }
}
