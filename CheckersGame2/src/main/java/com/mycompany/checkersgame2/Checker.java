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
    protected boolean isQueen = false;
    protected boolean opponentMove = false;
    
    public Checker(int positionX,
                    int positionY,
                    boolean white,
                    LinkedList<Checker> checkers,
                    boolean isQueen){
        this.positionX = positionX;
        this.positionY = positionY;
        x = positionX*100+5;
        y = positionY*100+5;
        this.white = white;
        this.checkers = checkers;
        this.isQueen = isQueen;
        checkers.add(this);
    }

    public void Move(int positionX, int positionY){
        try{
            if(NewGame.selectedChecker.isQueen==false){
                if((NewGame.selectedChecker.white==false)){ 
                    if((positionY-NewGame.selectedChecker.positionY)>=2 ||
                    (NewGame.selectedChecker.positionX-positionX)>=2    || 
                    (positionX-NewGame.selectedChecker.positionX)>=2    ||
                    (positionY<NewGame.selectedChecker.positionY)){
                        System.out.println(NewGame.selectedChecker.positionX+" "+ NewGame.selectedChecker.positionY);
                        x = this.positionX*100+5;
                        y = this.positionY*100+5;
                        return;
                    }
                    if(NewGame.getChecker(positionX*100, positionY*100)!=null){
                        if(NewGame.getChecker(positionX*100, positionY*100).white==white){
                            x = this.positionX*100+5;
                            y = this.positionY*100+5;
                            return;
                        }
                        if(NewGame.getChecker(positionX*100, positionY*100).white!=white){
                            if(NewGame.selectedChecker.positionY<positionY){
                                NewGame.getChecker(positionX*100, positionY*100).kill();
                            }else{
                                x = this.positionX*100+5;
                                y = this.positionY*100+5;
                                return;
                            }
                        }
                    }
                }
                if((NewGame.selectedChecker.white==true)){ 
                    if(((NewGame.selectedChecker.positionY-positionY)>=2   ||
                        ((NewGame.selectedChecker.positionX-positionX)>=2) || 
                        ((positionX-NewGame.selectedChecker.positionX)>=2) ||
                        (positionY>NewGame.selectedChecker.positionY))){
                        System.out.println(NewGame.selectedChecker.positionX+" "+ NewGame.selectedChecker.positionY);
                            x = this.positionX*100+5;
                            y = this.positionY*100+5;
                            return;
                    }
                    if(NewGame.getChecker(positionX*100, positionY*100)!=null){
                        if(NewGame.getChecker(positionX*100, positionY*100).white==white){
                            x = this.positionX*100+5;
                            y = this.positionY*100+5;
                            return;
                        }
                        if(NewGame.getChecker(positionX*100, positionY*100).white!=white){
                            if(NewGame.selectedChecker.positionY>positionY){
                                NewGame.getChecker(positionX*100, positionY*100).kill();
                            }else{
                                x = this.positionX*100+5;
                                y = this.positionY*100+5;
                                return;
                            }
                        }
                    }
                }
            }
            if((positionX+positionY)%2==0){
                    x = this.positionX*100+5;
                    y = this.positionY*100+5;
                    System.out.println((positionX-NewGame.selectedChecker.positionX)+ " "+
                                positionX+ " "+NewGame.selectedChecker.positionX);
                    return;
                }
            System.out.println((positionX-NewGame.selectedChecker.positionX)+ " "+
                            positionX+ " "+NewGame.selectedChecker.positionX);
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