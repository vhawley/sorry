//Victor Hawley 
//Submitted 28 Feb 2012
import java.awt.*;
import javax.swing.*;


public class GameWindow extends JFrame
   {
   private static int playerNum;    
   private final int PLAYER_MAX = 4;
   private final int PLAYER_MIN = 2;
 
   public GameWindow()
      {
      super("Sorry Board");
      }
   
   public static int getPlayerNum() 
      {
      return playerNum;              
      }
      
   public void startNewGame()
      {   
      playerNum = Integer.parseInt( JOptionPane.showInputDialog( "Please enter a valid number of players to play (2-4)." ) );
      while ( playerNum > PLAYER_MAX || playerNum < PLAYER_MIN )
         {
         playerNum = Integer.parseInt( JOptionPane.showInputDialog( "Please enter a valid number of players to play (2-4)." ) );         
         }
      
      SorryBoard b = new SorryBoard();          
        
      add(b);
      add(b.message);
      add(b.actionButton);
      add(b.nullLabel);
      b.message.setBounds( 0, 640, 400, 40 );
      b.message.setBackground(Color.black);
      b.actionButton.setBounds( 440, 650, 160, 20 );
      b.setBounds( 0, 0, 640, 642 );
      setSize(640,702);
      setLocation(100,100);
      setResizable(false);    
      setVisible(true);   
      } //end start      
   } //end class GameMonitor