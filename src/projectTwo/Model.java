package projectTwo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Model {
    
    private int xCount = 0;
    private int oCount = 0;
    private int blankCount = 1;
    private boolean winBool = false;
    private String victString;
    private boolean playerTurn = false;
    private String[] stringArg;    
    private String[][] squares;
    
    public Model(int size){
        this.squares = new String[size][size];
    }
    
    public Model(String[] inputString){
        this.stringArg = inputString;
    }
    
    public void InitializeList(int size){
        for(int row = 0; row < size; ++row){ 
            for(int col = 0; col < size; ++col){
                squares[row][col] = "T";
            }
        }
    }
    
    public void StartGame(){
        Controller window = new Controller(stringArg);
        int windowSize = window.sizeVerify();
        View gameWindow = new View(windowSize);
        gameWindow.OpenWindow();
    }
    
    public Boolean CheckWin(int size){
        
        if(winBool != true){
            for(int row = 0; row < size; ++row){
                for(int col = 0; col < size; ++col){
                    if(squares[row][col] == "X"){
                        xCount++;
                    }
                    else if(squares[row][col] == "O"){
                        oCount++;
                    }
                    else{
                        blankCount++;
                    }
                }
                if(xCount == size){
                    victString = "X";
                    winBool = true;
                }
                else if(oCount == size){
                    victString = "O";
                    winBool = true;
                }
                xCount = 0;
                oCount = 0;
            }
            if(blankCount-1 == 0){
                victString = "TIE";
                winBool = true;
            }
            blankCount = 1;
        }
        
        if(winBool != true){
           for(int col = 0; col < size; ++col){
                for(int row = 0; row < size; ++row){
                    if(squares[row][col] == "X"){
                        xCount++;
                    }
                    else if(squares[row][col] == "O"){
                        oCount++;
                    }
                }
                if(xCount == size){
                    victString = "X";
                    winBool = true;
                }
                else if(oCount == size){
                    victString = "O";
                    winBool = true;
                }
                xCount = 0;
                oCount = 0;
            }
        }
        
        if(winBool != true){
            for(int row = 0; row < size; ++row){
                int col;
                col = row;
                if(squares[row][col] == "X"){
                    xCount++;
                }
                else if(squares[row][col] == "O"){
                    oCount++;
                }
            }
            if(xCount == size){
                victString = "X";
                winBool = true;
            }
            else if(oCount == size){
                victString = "O";
                winBool = true;
            }
             xCount = 0;
             oCount = 0;
            }

        if(winBool != true){
            int col;
            col = size-1;
            for(int row = 0; row < size; ++row){
                if(squares[row][col] == "X"){
                    xCount++;
                }
                else if(squares[row][col] == "O"){
                    oCount++;
                }
                System.out.println(col);
                col = col-1;
            }
            if(xCount == size){
                victString = "X";
                winBool = true;
            }
            else if(oCount == size){
                victString = "O";
                winBool = true;
            }
             xCount = 0;
             oCount = 0;
            }
        
        return winBool;
    }
    
    public String GetVictString(){
        return victString;
    }
    
    public void MakeMark(boolean turn, int row, int col){
        
        if(!squares[row][col].equals("X") && !squares[row][col].equals("O")){
            if(turn == false){
                squares[row][col] = "X";
                this.playerTurn = true;
            }
            else{
                squares[row][col] = "O";
                this.playerTurn = false;
            }
        }
        else if(squares[row][col].equals("X") || !squares[row][col].equals("O")){
            this.playerTurn = turn;
        }
        
    }
    
    public String GetMark(int row, int col){
        return squares[row][col];
    
    }
    
    public boolean CheckLast(){
        return playerTurn;
    }
}
