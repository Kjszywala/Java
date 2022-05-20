package com.mycompany.checkersgame2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
/**
 *
 * @author Kamil
 */
public class NewGame implements ActionListener {
    
    static final int portSerwera = 6623;//192.168.1.186
    protected String adresSerwera = "192.168.1.186";//88.105.17.179
    protected InetAddress iAdres = null;
    protected Socket socket = null; 
    protected ServerSocket serverSocket;
    private DataOutputStream dos;
    private DataInputStream dis;
    protected PrintWriter out;

    private final String bColour = "#a85a32";
    
    JFrame frame = new JFrame("Checkers");
    JTextArea textArea = new JTextArea(10,29);
    JTextField textField = new JTextField(20);
    JButton sendButton = new JButton("Send");
    JScrollPane sp = new JScrollPane(textArea); 
    
    public static LinkedList<Checker> checkers = new LinkedList();
    public static Checker selectedChecker = null;

    public NewGame(){
        
        int size = 90;
        int HEIGHT = 100;
        int WIDTH = 100;
        //boolean isWhite = true;

        Checker wc1 = new Checker(0,7,true,checkers,false);
        Checker wc2 = new Checker(2,7,true,checkers,false);
        Checker wc3 = new Checker(4,7,true,checkers,false);
        Checker wc4 = new Checker(6,7,true,checkers,false);
        Checker wc5 = new Checker(1,6,true,checkers,false);
        Checker wc6 = new Checker(3,6,true,checkers,false);
        Checker wc7 = new Checker(5,6,true,checkers,false);
        Checker wc8 = new Checker(7,6,true,checkers,false);
        Checker wc9 = new Checker(0,5,true,checkers,false);
        Checker wc10 = new Checker(2,5,true,checkers,false);
        Checker wc11 = new Checker(4,5,true,checkers,false);
        Checker wc12 = new Checker(6,5,true,checkers,false);
        
        Checker bc1 = new Checker(1,0,false,checkers,false);
        Checker bc2 = new Checker(3,0,false,checkers,false);
        Checker bc3 = new Checker(5,0,false,checkers,false);
        Checker bc4 = new Checker(7,0,false,checkers,false);
        Checker bc5 = new Checker(0,1,false,checkers,false);
        Checker bc6 = new Checker(2,1,false,checkers,false);
        Checker bc7 = new Checker(4,1,false,checkers,false);
        Checker bc8 = new Checker(6,1,false,checkers,false);
        Checker bc9 = new Checker(1,2,false,checkers,false);
        Checker bc10 = new Checker(3,2,false,checkers,false);
        Checker bc11 = new Checker(5,2,false,checkers,false);
        Checker bc12 = new Checker(7,2,false,checkers,false);
        
        JPanel checkersBoard = new JPanel(new BorderLayout());
        JPanel board=new JPanel(){
            @Override
            public void paint(Graphics g) {
            boolean white=true;
            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    if(white){
                        g.setColor(Color.WHITE);
                    }else{
                        g.setColor(Color.BLACK);
                    }
                    g.fillRect(x*100, y*100, 100, 100);
                    white=!white;

                }
                white=!white;
                }
                for(Checker c: checkers) {
                    if(c.white) {
                        g.setColor(Color.decode("#c7c4c3"));
                    } else {
                        g.setColor(Color.decode("#803f1f"));
                    }
                    g.fillOval(c.x, c.y, size, size);
                }
            }
        };
        frame.add(checkersBoard);
        board.setOpaque(true);
        checkersBoard.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        checkersBoard.add(board,BorderLayout.CENTER);
        board.setOpaque(false);
        checkersBoard.setBackground(Color.decode(bColour));
        board.setBackground(Color.decode(bColour));
        
        JPanel eastPanel = new JPanel(new BorderLayout());
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea.setEditable(false);
        
        checkersBoard.add(eastPanel, BorderLayout.EAST);
        eastPanel.setBackground(Color.decode(bColour));
        eastPanel.add(textArea, BorderLayout.CENTER);
        
        JPanel eastBottomPanel = new JPanel(new FlowLayout());
        eastPanel.add(eastBottomPanel,BorderLayout.SOUTH);
        eastBottomPanel.add(textField);
        eastBottomPanel.add(sendButton);
        eastBottomPanel.setBackground(Color.decode(bColour));
        sendButton.addActionListener(this);
        textField.addActionListener(this);
        
        this.connect();
        
        frame.setUndecorated(false);
        frame.setSize(1200,900);
        frame.setContentPane(checkersBoard);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                try{
                //selectedChecker.Move(e.getX(), e.getY());
                    if(selectedChecker != null){
                        selectedChecker.x = e.getX()-75;
                        selectedChecker.y = e.getY()-89;
                        frame.repaint();
                     }
                }catch(NullPointerException ex){
                }
            }
            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
        
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            
            @Override

            public void mousePressed(MouseEvent e) {
                selectedChecker = getChecker(e.getX()-40,e.getY()-40);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try{
                    //System.out.println(selectedChecker.positionX+" "+selectedChecker.positionY);
                    selectedChecker.Move(e.getX()/100, e.getY()/100);
                    frame.repaint();
                }catch(NullPointerException ex){
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    void connect() {
        try {
            iAdres = InetAddress.getByName(adresSerwera);
            textArea.append("Connecting to the address = " + iAdres + "\n");
        } catch (Exception e) { 
            System.exit(0); 
        }
        try {
            System.out.println(iAdres);
            socket = new Socket(iAdres, portSerwera);
            textArea.append("Connected\n");
            System.out.println(socket);
        } catch (IOException e) {
            textArea.append("Not connected\n");
            e.printStackTrace();
        }
        //startuję wątek nasłuchującynew NewGame()
        Thread thread = new ClientThreadChat(this);
        thread.start();
        try {
            out = new PrintWriter(new BufferedWriter(
                                  new OutputStreamWriter(
                                  socket.getOutputStream())), true);
            System.out.println("Thread started");
        } catch (Exception e) { 
            textArea.append("Error: " + e); 
        }
    }
    @Override
    public void actionPerformed(ActionEvent g) {
        out.println(textField.getText());
        if (textField.getText().equals("END")){
            try{
                out.close();
                socket.close();
            }catch(Exception e){
            }
                System.exit(0);
            }
        textField.setText("");
    }
    
    public static Checker getChecker(int x, int y){
        int xposition = x/100;
        int yposition = y/100;
        for(Checker c: checkers){
            if(c.positionX==xposition && c.positionY==yposition){
                return c;
            }
        }
        return null;
    }
} 


