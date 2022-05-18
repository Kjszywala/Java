package com.mycompany.checkersgame2;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import javax.swing.JComponent;

/**

* @author kamil.szywala

*/
public class Checker {

    protected int positionX;
    protected int positionY;
    protected int x;
    protected int y;
    LinkedList<Checker> checkers;
    protected boolean white = false;

    public Checker(int positionX,
                    int positionY,
                    boolean white,
                    LinkedList<Checker> checkers){
        this.positionX = positionX;
        this.positionY = positionY;
        x = positionX*100+5;
        y = positionY*100+5;
        this.white = white;
        this.checkers = checkers;
        checkers.add(this);
    }

    public void Move(int positionX, int positionY){
        try{
            if(NewGame.getChecker(positionX*100, positionY*100)!=null){
                if(NewGame.getChecker(positionX*100, positionY*100).white!=white){
                    NewGame.getChecker(positionX*100, positionY*100).kill();
                }else{
                    x = this.positionX*100+5;
                    y = this.positionY*100+5;
                    return;
                }
            }
            this.positionX = positionX;
            this.positionY = positionY;
            x = positionX*100+5;
            y = positionY*100+5;
        }catch(ConcurrentModificationException e){
        }
    }

    public void kill(){
        checkers.remove(this);
    }
    
    public void ToString(){
        System.out.println(positionX + " " + positionY + " " + white);
    }
}
