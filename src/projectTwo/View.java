package projectTwo;

    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.*;

public class View extends JPanel implements ActionListener {
    private boolean victoryCheck = false;
    private boolean playerTookTurn = false;
    private boolean currentTurn = false;
    private JLabel resultLabel;
    private int size;
    private Model buttonChecker;
    private JPanel squaresPanel;
    private JPanel textLabel;
    private JButton[][] squares;
    private int rowNum = 0;
    private int colNum = 0;
    
    public View(int size){
    
        this.size = size;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        squaresPanel = new JPanel(new GridLayout(size,size));
        
        squares = new JButton[size][size];
        buttonChecker = new Model(size);
        buttonChecker.InitializeList(size);
    
        for(int row = 0; row < size; ++row){
            
            for(int col = 0; col < size; ++col){
                
                squares[row][col] = new JButton();
                squares[row][col].addActionListener((ActionListener) this);
                squares[row][col].setName("Square" + row + col);
                squares[row][col].setPreferredSize(new Dimension(64,64));
                
                squaresPanel.add( squares[row][col] );
                
            }
        
        }
        this.add(squaresPanel);
        
        resultLabel = new JLabel("Welcome to Tic-Tac-Toe");
        this.add(resultLabel);
    }
    
    public void OpenWindow(){
        EventQueue.invokeLater(() -> {
            JFrame window = new JFrame("TicTacToe");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().add( new View(size) );
            window.pack();
            window.setVisible(true);
        });
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText;
        String buttonLoc;
        if (e.getSource() instanceof JButton){
            JButton button = (JButton)(e.getSource());
                rowNum = 0;
                colNum = 0;
                buttonLoc = (button.getName()).replaceAll("Square","");
                rowNum = Integer.parseInt(buttonLoc.replaceFirst("[*0-9]",""));
                buttonLoc = (button.getName()).replaceAll("Square","");
                colNum = Integer.parseInt(buttonLoc.replaceFirst(Integer.toString(rowNum),""));
                
                buttonChecker.MakeMark(currentTurn, rowNum, colNum);
                buttonText = buttonChecker.GetMark(rowNum, colNum);
                
                victoryCheck = buttonChecker.CheckWin(size);
                System.out.println(victoryCheck);
                button.setText(buttonText);
                currentTurn = buttonChecker.CheckLast();
                
                if(victoryCheck == true){
                    for(Component component : this.squaresPanel.getComponents()) {
                        this.resultLabel.setText(buttonChecker.GetVictString());
                        component.setEnabled(false);
                    }   
                }
                
                }
    }
}

