package projectTwo;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Controller {
    
    private String[] stringArg;
    private int windowSize;
    
    
    public Controller(String[] inputString){
        this.stringArg = inputString;
        
    }
    
    public int sizeVerify(){
    
        if(stringArg.length > 0){
            
            int inputSize = Integer.parseInt(stringArg[0]);
            
            if( inputSize < 3){
                windowSize = 3;
            }
            else{
                windowSize = inputSize;
            }
        }
        else{
            windowSize = 3;
        }
        return windowSize;
        
    }
    
}
