//Victor Hawley 
//Submitted 28 Feb 2012
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

/**
 * The SorryBoard class handles the graphics events for the game board.
 */
public class SorryBoard extends Canvas implements MouseListener, ActionListener
   {
   private Image boardImage;
   private int picLoaded;
   private static final int GRID_WIDTH = 16;
   private static final int GRID_HEIGHT = 16;   
   private Tile[][] grid;
   private ArrayList<Player> players = new ArrayList<Player>();
   private static final int PLAYER_YELLOW = 0;
   private static final int PLAYER_GREEN = 1;
   private static final int PLAYER_RED = 2;
   private static final int PLAYER_BLUE = 3;
   private String[] playerLetters;
   private String[] playerNameStrings;
   private int currentTurn;
   private int moveCounter;
   private boolean timeToDraw;
   private boolean timeToSelect;
   private boolean timeToMove;
   private boolean timeToChooseAgain;
   private Card pickedCard;
   private Pawn selectedPawn;
   private ArrayList<Pawn> cPawns;
   private Deck mainDeck;
   
   Label message;
   Label nullLabel;
   Button actionButton;
 
       
   /**
    * Constructor that sets up a new SorryBoard
    */
   public SorryBoard()
      {     
      boardImage = new ImageIcon("board.png").getImage();
      picLoaded = new ImageIcon("board.png").getImageLoadStatus();
      grid = new Tile[GRID_WIDTH][GRID_HEIGHT];
      playerLetters = new String[4];
      playerLetters[PLAYER_YELLOW] = "Y";
      playerLetters[PLAYER_GREEN] = "G";
      playerLetters[PLAYER_RED] = "R";
      playerLetters[PLAYER_BLUE] = "B";
      
      playerNameStrings = new String[4];
      playerNameStrings[PLAYER_YELLOW] = "Yellow";
      playerNameStrings[PLAYER_GREEN] = "Green";
      playerNameStrings[PLAYER_RED] = "Red";
      playerNameStrings[PLAYER_BLUE] = "Blue"; 
      
      addMouseListener(this);
      grid[0][0] = new TrackTile();
      grid[1][0] = new SlideStart( PLAYER_YELLOW );
      grid[2][0] = new SlideTile( PLAYER_YELLOW );
      grid[3][0] = new SlideTile( PLAYER_YELLOW );
      grid[4][0] = new SlideEnd( PLAYER_YELLOW );
      grid[5][0] = new TrackTile();
      grid[6][0] = new TrackTile();
      grid[7][0] = new TrackTile();
      grid[8][0] = new TrackTile();
      grid[9][0] = new SlideEnd( PLAYER_YELLOW );
      grid[10][0] = new SlideTile( PLAYER_YELLOW );
      grid[11][0] = new SlideTile( PLAYER_YELLOW );
      grid[12][0] = new SlideTile( PLAYER_YELLOW );
      grid[13][0] = new SlideEnd( PLAYER_YELLOW );
      grid[14][0] = new TrackTile();
      grid[15][0] = new TrackTile();
      grid[15][1] = new SlideStart( PLAYER_GREEN );
      grid[15][2] = new SlideTile( PLAYER_GREEN );
      grid[15][3] = new SlideTile( PLAYER_GREEN );
      grid[15][4] = new SlideEnd( PLAYER_GREEN );
      grid[15][5] = new TrackTile();
      grid[15][6] = new TrackTile();
      grid[15][7] = new TrackTile();
      grid[15][8] = new TrackTile();
      grid[15][9] = new SlideStart( PLAYER_GREEN );
      grid[15][10] = new SlideTile( PLAYER_GREEN );
      grid[15][11] = new SlideTile( PLAYER_GREEN );
      grid[15][12] = new SlideTile( PLAYER_GREEN );
      grid[15][13] = new SlideEnd( PLAYER_GREEN );
      grid[15][14] = new TrackTile();
      grid[15][15] = new TrackTile();
      grid[14][15] = new SlideStart( PLAYER_RED );
      grid[13][15] = new SlideTile( PLAYER_RED );
      grid[12][15] = new SlideTile( PLAYER_RED );
      grid[11][15] = new SlideEnd( PLAYER_RED );
      grid[10][15] = new TrackTile();
      grid[9][15] = new TrackTile();
      grid[8][15] = new TrackTile();
      grid[7][15] = new TrackTile();
      grid[6][15] = new SlideStart( PLAYER_RED );
      grid[5][15] = new SlideTile( PLAYER_RED );
      grid[4][15] = new SlideTile( PLAYER_RED );
      grid[3][15] = new SlideTile( PLAYER_RED );
      grid[2][15] = new SlideEnd( PLAYER_RED );
      grid[1][15] = new TrackTile();
      grid[0][15] = new TrackTile();
      grid[0][14] = new TrackTile();
      grid[0][13] = new TrackTile();
      grid[0][12] = new TrackTile();
      grid[0][11] = new TrackTile();
      grid[0][10] = new TrackTile();
      grid[0][9] = new TrackTile();
      grid[0][8] = new TrackTile();
      grid[0][7] = new TrackTile();
      grid[0][6] = new TrackTile();
      grid[0][5] = new TrackTile();
      grid[0][4] = new TrackTile();
      grid[0][3] = new TrackTile();
      grid[0][2] = new TrackTile();
      grid[0][1] = new TrackTile();
      grid[2][1] = new SafeTile( PLAYER_YELLOW );
      grid[2][2] = new SafeTile( PLAYER_YELLOW );
      grid[2][3] = new SafeTile( PLAYER_YELLOW );
      grid[2][4] = new SafeTile( PLAYER_YELLOW );
      grid[2][5] = new SafeTile( PLAYER_YELLOW );
      grid[2][7] = new HomeTile( PLAYER_YELLOW );
      grid[2][8] = new HomeTile( PLAYER_YELLOW );
      grid[3][7] = new HomeTile( PLAYER_YELLOW );
      grid[3][8] = new HomeTile( PLAYER_YELLOW );
      grid[4][2] = new StartTile( PLAYER_YELLOW );
      grid[5][2] = new StartTile( PLAYER_YELLOW );
      grid[4][3] = new StartTile( PLAYER_YELLOW );
      grid[5][3] = new StartTile( PLAYER_YELLOW );
      grid[10][2] = new SafeTile( PLAYER_GREEN );
      grid[11][2] = new SafeTile( PLAYER_GREEN );
      grid[12][2] = new SafeTile( PLAYER_GREEN );
      grid[13][2] = new SafeTile( PLAYER_GREEN );
      grid[14][2] = new SafeTile( PLAYER_GREEN );
      grid[7][2] = new HomeTile( PLAYER_GREEN );
      grid[8][2] = new HomeTile( PLAYER_GREEN );
      grid[7][3] = new HomeTile( PLAYER_GREEN );
      grid[8][3] = new HomeTile( PLAYER_GREEN );
      grid[12][4] = new StartTile( PLAYER_GREEN );
      grid[13][4] = new StartTile( PLAYER_GREEN );
      grid[12][5] = new StartTile( PLAYER_GREEN );
      grid[13][5] = new StartTile( PLAYER_GREEN ); 
      grid[13][10] = new SafeTile( PLAYER_RED );
      grid[13][11] = new SafeTile( PLAYER_RED );
      grid[13][12] = new SafeTile( PLAYER_RED );
      grid[13][13] = new SafeTile( PLAYER_RED );
      grid[13][14] = new SafeTile( PLAYER_RED );
      grid[12][7] = new HomeTile( PLAYER_RED );
      grid[13][7] = new HomeTile( PLAYER_RED );
      grid[12][8] = new HomeTile( PLAYER_RED );
      grid[13][8] = new HomeTile( PLAYER_RED );
      grid[10][12] = new StartTile( PLAYER_RED );
      grid[11][12] = new StartTile( PLAYER_RED );
      grid[10][13] = new StartTile( PLAYER_RED );
      grid[11][13] = new StartTile( PLAYER_RED );  
      grid[1][13] = new SafeTile( PLAYER_BLUE );
      grid[2][13] = new SafeTile( PLAYER_BLUE );
      grid[3][13] = new SafeTile( PLAYER_BLUE );
      grid[4][13] = new SafeTile( PLAYER_BLUE );
      grid[5][13] = new SafeTile( PLAYER_BLUE );
      grid[7][12] = new HomeTile( PLAYER_BLUE );
      grid[8][12] = new HomeTile( PLAYER_BLUE );
      grid[7][13] = new HomeTile( PLAYER_BLUE );
      grid[8][13] = new HomeTile( PLAYER_BLUE );
      grid[2][10] = new StartTile( PLAYER_BLUE );
      grid[3][10] = new StartTile( PLAYER_BLUE );
      grid[2][11] = new StartTile( PLAYER_BLUE );
      grid[3][11] = new StartTile( PLAYER_BLUE );
      for ( int row = 0; row < grid.length; row++ )
         {
         for ( int col = 0; col < grid[row].length; col++ )
            {
            if ( grid[row][col] != null )
               {
               grid[row][col].setTaken(false);   
               }        
            }             
         }
     
      for ( int index = 0; index < GameWindow.getPlayerNum(); index++ ) 
         {
         players.add( new Player( index ) ); 
         }
         
      mainDeck = new Deck();
      
      currentTurn = 0;
      setTimeToChooseAgain( false );          
      message = new Label( playerNameStrings[currentTurn] + ", it is your turn.  Draw a card." , Label.CENTER );
      timeToDraw = true;
      nullLabel = new Label();
      actionButton = new Button("Draw Card");
      actionButton.addActionListener(this);
      
      System.out.println( "Player array of size " + players.size() + " created" );
      System.out.println( "picLoaded = " + picLoaded );
      }
   
   /**
    * This method calculates which pawns are selectable depending on the card chosen
    * and adds them to an ArrayList of pawns.  If there is at least one pawn in the ArrayList,
    * it tells the game that it is time for a player to select a pawn.
    * @return ArrayList of pawns that a current player can choose from depending on the action needed.
    */   
   public ArrayList<Pawn> getChoosablePawns()
      {
      cPawns = new ArrayList<Pawn>();
      
      // If a player picks a one or two (same criteria for selection), add all pawns not in Home to ArrayList of pawns.
      if ( pickedCard instanceof OneCard || pickedCard instanceof TwoCard )
         {
         for ( int index = 0; index < players.get(currentTurn).getPawns().size(); index++ )
            {
            if ( grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof HomeTile == false )
               {
               cPawns.add( players.get(currentTurn).getPawns().get(index) );
               System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
               }      
            }
         }
         
      /* if ( pickedCard instanceof TwoCard )
         {
         for ( int index = 0; index < players.get(currentTurn).getPawns().size(); index++ )
            {
            if ( grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof HomeTile == false )
               {
               cPawns.add( players.get(currentTurn).getPawns().get(index) );
               System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
               }      
            }
         }*/
         
      // If a player picks a four, add all pawns not in Home and not in Start to the ArrayList of pawns.      
      if ( pickedCard instanceof FourCard )
         {
         for ( int index = 0; index < players.get(currentTurn).getPawns().size(); index++ )
            {
            if ( grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof HomeTile == false && grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof StartTile == false )
               {
               cPawns.add( players.get(currentTurn).getPawns().get(index) );
               System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
               }      
            }
         }  
         
      /* If a player picks an eleven, on the first pick, "timeToChooseAgain" will be false (it is set to true in the ElevenCard
       * class), and it will add all friendly pawns on a TrackTile to the array.  Depending on what the player decides to do after
       * choosing a friendly pawn, timeToChooseAgain might be set to true, and this method will be invoked again.  At this time,
       * the code will add all enemy pawns on a TrackTile to the array of chooseable pawns, and the card will act on those pawns.
       */   
      if ( pickedCard instanceof ElevenCard )
         {
         if ( timeToChooseAgain == true )
            {
            System.out.println( "Picking opponent pawns..." );
            for ( int pp = 0; pp < players.size(); pp++ )
               {
               if ( pp != currentTurn )
                  {
                  for ( int index = 0; index < players.get(pp).getPawns().size(); index++ )
                     {
                     if ( grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof TrackTile || grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof SlideStart || grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof SlideTile || grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof SlideEnd )
                        {
                        cPawns.add( players.get(pp).getPawns().get(index) );
                        System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
                        }      
                     }
                  }   
               }
            }       
            
         else
            {
            System.out.println( "Picking friendly pawns for ElevenCard..." );
            for ( int index = 0; index < players.get(currentTurn).getPawns().size(); index++ )
               {
               if ( grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof TrackTile )
                  {
                  cPawns.add( players.get(currentTurn).getPawns().get(index) );
                  System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
                  }      
               }                    
            }    
         }  
         
      /* Similar to the ElevenCard formula. This part starts by picking all friendly pawns in a StartTile, as timeToChooseAgain starts out
       * as false.  When a friendly pawn is selected, timeToChooseAgain will be set to true (through the SorryCard class) and it will calculate
       * and add any opponent pawns on an instance of TrackTile
       */      
      if ( pickedCard instanceof SorryCard )
         {
         if ( timeToChooseAgain == true )
            {
            System.out.println( "Picking opponent pawns..." );
            for ( int pp = 0; pp < players.size(); pp++ )
               {
               if ( pp != currentTurn )
                  {
                  for ( int index = 0; index < players.get(pp).getPawns().size(); index++ )
                     {
                     if ( grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof TrackTile || grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof SlideStart || grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof SlideTile || grid[ players.get(pp).getPawns().get(index).getPosX() ][ players.get(pp).getPawns().get(index).getPosY() ] instanceof SlideEnd )
                        {
                        cPawns.add( players.get(pp).getPawns().get(index) );
                        System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
                        }      
                     }
                  }   
               }
            }       
            
         else
            {
            System.out.println( "Picking friendly pawns in Start for SorryCard..." );
            for ( int index = 0; index < players.get(currentTurn).getPawns().size(); index++ )
               {
               if ( grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof StartTile )
                  {
                  cPawns.add( players.get(currentTurn).getPawns().get(index) );
                  System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
                  }      
               }                    
            }    
         }
         
      /* If the picked card is a GenericCard, TenCard, or SevenCard (these all have the same criteria for selecting pawns), 
       * pawns not in an instance of HomeTile or StartTile will be added to the array of selectable pawns.
       */   
      if ( pickedCard instanceof GenericCard || pickedCard instanceof TenCard || pickedCard instanceof SevenCard )
         {
         for ( int index = 0; index < players.get(currentTurn).getPawns().size(); index++ )
            {
            if ( grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof HomeTile == false && grid[ players.get(currentTurn).getPawns().get(index).getPosX() ][ players.get(currentTurn).getPawns().get(index).getPosY() ] instanceof StartTile == false )
               {
               cPawns.add( players.get(currentTurn).getPawns().get(index) );
               System.out.println( players.get(currentTurn).getPawns().get(index) + " added to array of choosable pawns." );
               }      
            }
         }
      
      if ( cPawns.size() > 0 )
         {
         timeToSelect = true;   
         timeToDraw = false;
         timeToMove = true;
         }
      else
         {
         message.setText( playerNameStrings[currentTurn] + " has no move.  Next turn..." );
         System.out.println( playerNameStrings[currentTurn] + " has no move.  Next turn..." );
         incrementTurn();    
         }
      return cPawns;
      }

   /**
    * advance with integer parameter moveCount moves a given pawn
    * a given amount of spaces.
    * @param Pawn which pawn to move.
    * @param int how many spaces to advance.
    */    
   public void advance( Pawn p, int moveCount )
      {
      moveCounter = moveCount;
      System.out.println( "movecounter = " + moveCounter );
      for ( int index = 0; index < moveCount; index++ )
         {
         if ( moveCounter > 0 )
            {
            advance( p );
            moveCounter--;
            System.out.println( "movecounter is now " + moveCounter );
            }
         }  
      
      //checks positions of all pawns to see which tiles are taken
      for ( int pl = 0; pl < players.size(); pl++ )
         {
         for ( int pa = 0; pa < players.get(pl).getPawns().size(); pa++ )
            {
            grid[ players.get(pl).getPawns().get(pa).getPosX() ][ players.get(pl).getPawns().get(pa).getPosY() ].setTaken( true );   
            }
         }
      
      // wait and check for slide

      }
   
   /**
    * advance with no int parameter moves a given pawn
    * 1 space. 
    * @param pawn which pawn to move.
    */ 
   public void advance( Pawn p )
      {
      if ( timeToMove ) 
         {
         if ( p.getPosX() == 2 && p.getPosY() == 0 && p.getCol() == PLAYER_YELLOW )
            {
            p.moveTo( p.getPosX(), p.getPosY() + 1 );
            }
         if ( p.getPosX() == 15 && p.getPosY() == 2 && p.getCol() == PLAYER_GREEN )
            {
            p.moveTo( p.getPosX() - 1, p.getPosY() );  
            }
         if ( p.getPosX() == 13 && p.getPosY() == 15 && p.getCol() == PLAYER_RED )
            {
            p.moveTo( p.getPosX(), p.getPosY() - 1 );
            }
         if ( p.getPosX() == 0 && p.getPosY() == 13 && p.getCol() == PLAYER_BLUE )
            {
            p.moveTo( p.getPosX() + 1, p.getPosY() );
            }   
         else if ( grid[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 0 ) && (p.getPosY() > 0 ) )
            {
            p.moveTo( p.getPosX(), p.getPosY() - 1 );
            }
         else if ( grid[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 0 ) && (p.getPosY() == 0 ) )
            {
            p.moveTo( p.getPosX() + 1, p.getPosY() );
            
            }
         else if ( grid[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() > 0 ) && (p.getPosX() < 15 ) && (p.getPosY() == 0 ) )
            {
            p.moveTo( p.getPosX() + 1, p.getPosY() ); 
            }
         else if ( grid[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 15 ) && (p.getPosY() < 15 ) )
            {
            p.moveTo( p.getPosX(), p.getPosY() + 1 );
            }  
         else if ( grid[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 15 ) && (p.getPosY() == 15 ) )
            {
            p.moveTo( p.getPosX() - 1, p.getPosY() );
            }
         else if ( grid[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() > 0 ) && (p.getPosX() < 15 ) && (p.getPosY() == 15 ) )
            {
            p.moveTo( p.getPosX() - 1, p.getPosY() );
            }
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == true && p.getCol() == PLAYER_YELLOW )
            {
            if ( p.getPosY() == 5 && moveCounter == 1)
               {
               if ( grid[2][7].getTaken() == false )
                  {
                  p.moveTo(2,7);
                  }
               else if ( grid[3][7].getTaken() == false )
                  {
                  p.moveTo(3,7);  
                  }
               else if ( grid[2][8].getTaken() == false )
                  {
                  p.moveTo(2,8);   
                  }
               else if ( grid[3][8].getTaken() == false )
                  {
                  p.moveTo(3,8);
                  }           
               }
            else if ( p.getPosY() == 5 && moveCounter > 1 )
               {
               p.setFacingForward( false );
               p.moveTo( p.getPosX(), p.getPosY() - 1 ); 
               }
            else
               {
               p.moveTo( p.getPosX(), p.getPosY() + 1 );   
               }
            } 
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == false && p.getCol() == PLAYER_YELLOW )
            {
            if ( p.getPosY() == 1 )
               {
               p.setFacingForward( true );
               p.moveTo( p.getPosX(), p.getPosY() + 1 ); 
               }
            else
               {
               p.moveTo( p.getPosX(), p.getPosY() - 1 ); 
               }
            } 
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == true && p.getCol() == PLAYER_GREEN )
            {
           if ( p.getPosX() == 10 && moveCounter == 1)
               {
               if ( grid[7][2].getTaken() == false )
                  {
                  p.moveTo(7,2);   
                  }
               else if ( grid[8][2].getTaken() == false )
                  {
                  p.moveTo(8,2);     
                  
                  }
               else if ( grid[7][3].getTaken() == false )
                  {
                  p.moveTo(7,3);  
                  
                  }
               else if ( grid[8][3].getTaken() == false )
                  {
                  p.moveTo(8,3);  
                  
                  }           
               }
            else if ( p.getPosX() == 10 && moveCounter > 1 )
               {
               p.setFacingForward( false );
               p.moveTo( p.getPosX() + 1, p.getPosY() );
               }
            else
               {
               p.moveTo( p.getPosX() - 1, p.getPosY() );     
               }
            } 
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == false && p.getCol() == PLAYER_GREEN )
            {
            if ( p.getPosX() == 14 )
               {
               p.setFacingForward( true );
               p.moveTo( p.getPosX() - 1, p.getPosY() ); 
               
               }
            else
               {
               p.moveTo( p.getPosX() + 1, p.getPosY() ); 
               
               }
            } 
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == true && p.getCol() == PLAYER_RED )
            {
            if ( p.getPosY() == 10 && moveCounter == 1)
               {
               if ( grid[12][7].getTaken() == false )
                  {
                  p.moveTo(12,7);     
                  }
               else if ( grid[12][8].getTaken() == false )
                  {
                  p.moveTo(12,8);  
                  
                  }
               else if ( grid[13][7].getTaken() == false )
                  {
                  p.moveTo(13,7);     
                  
                  }
               else if ( grid[13][8].getTaken() == false )
                  {
                  p.moveTo(13,8);
                  
                  }           
               }
            else if ( p.getPosY() == 10 && moveCounter > 1 )
               {
               p.setFacingForward( false );
               p.moveTo( p.getPosX(), p.getPosY() + 1 );  
               }
            else
               {
               p.moveTo( p.getPosX(), p.getPosY() - 1 );   
               }
            } 
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == false && p.getCol() == PLAYER_RED )
            {
            if ( p.getPosY() == 14 )
               {
               p.setFacingForward( true );
               p.moveTo( p.getPosX(), p.getPosY() - 1 );   
               }
            else
               {
               p.moveTo( p.getPosX(), p.getPosY() + 1 ); 
               
               }
            } 
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == true && p.getCol() == PLAYER_BLUE )
            {
            if ( p.getPosX() == 5 && moveCounter == 1 )
               {
               if ( grid[7][12].getTaken() == false )
                  {
                  p.moveTo(7,12);             
                 
                  }
               else if ( grid[8][12].getTaken() == false )
                  {
                  p.moveTo(8,12);                    
                  
                  }
               else if ( grid[7][13].getTaken() == false )
                  {
                  p.moveTo(7,13);
                  }
               else if ( grid[8][13].getTaken() == false )
                  {
                  p.moveTo(8,13); 
                  }           
               }
            else if ( p.getPosX() == 5 && moveCounter > 1 )
               {
               p.setFacingForward( false );
               p.moveTo( p.getPosX() - 1, p.getPosY() );       
               
               }
            else
               {
               p.moveTo( p.getPosX() + 1, p.getPosY() );
               
               }
            } 
         else if ( grid[p.getPosX()][p.getPosY()] instanceof SafeTile && p.getFacingForward() == false && p.getCol() == PLAYER_BLUE )
            {
            if ( p.getPosX() == 1 )
               {
               p.setFacingForward( true );
               p.moveTo( p.getPosX() + 1, p.getPosY() ); 
               
               }
            else
               {
               p.moveTo( p.getPosX() - 1 , p.getPosY() );  
               
               }
            }    
         }
      
      repaint();
      }
      
   public void update(Graphics g)
      {
      paint( g );    
      }
   
   /**
    * incrementTurn is called when it is time to draw a card.
    */
   public void incrementTurn()
      {
      /* If the last card drawn was a two, the current player chooses again.  Otherwise
       * it is the next player's turn to choose.
       */
      if ( pickedCard instanceof TwoCard == false )
         {
         if ( currentTurn == players.size() - 1 ) 
            {
            currentTurn = 0;
            }
         else
            {
            currentTurn++;
            }    
         }
      timeToDraw = true;
      timeToMove = false;
      timeToSelect = false;
      selectedPawn = null;
      message.setText( playerNameStrings[currentTurn] + ", it is your turn.  Draw a card.");
      }
   
   /**
    * Called whenever the mouse is clicked, but only does something when a pawn is selected. 
    * @param MouseEvent where the mouse is clicked.
    */   
   public void mouseClicked(MouseEvent e)
      {
      System.out.println( "MOUSE CLICKED at coordinates " + e.getPoint() ); 
      /* only do something if it is time to select a pawn
       */
      if ( timeToSelect )
         {
         for ( int cp = 0; cp < cPawns.size(); cp++ )
            {
            if (  (e.getPoint().getX() > ( 8 + cPawns.get(cp).getPosX() * 40 ) ) && ( e.getPoint().getX() < ( 35 + cPawns.get(cp).getPosX() * 40 ) ) && ( e.getPoint().getY() > ( 8 + cPawns.get(cp).getPosY() * 40 ) && e.getPoint().getY() < ( 35 + cPawns.get(cp).getPosY() * 40 ) ) )
               {
               selectedPawn = cPawns.get(cp);
               System.out.println( selectedPawn + " was selected..." );
               }
            }
         
         /*This is polymorphism because this is referencing the "act" method in the abstract card class,
          *but depending on the actual type card that is stored as pickedCard, it can be calling 8 different "act" methods
          */
         pickedCard.act( selectedPawn, this );
         if ( timeToChooseAgain == false )
             {
             incrementTurn(); 
             }
         repaint();
         }            
      }
   public void mouseEntered(MouseEvent e)
      {
      //not used
      }
   public void mouseExited(MouseEvent e)
      {
      //not used        
      }
   public void mousePressed(MouseEvent e)
      {
      //not used
      }
   public void mouseReleased(MouseEvent e)
      {
      //not used          
      } 
   
   /**
    * Called when the "draw" button is pressed. 
    * @param pawn which pawn to move.
    */   
   public void actionPerformed(ActionEvent e)     
      {   
      System.out.println( "BUTTON CLICKED!" );          
      /* only do something if it is time to draw a card
       */
      if ( timeToDraw == true )
         {
         int cardSelector = (int ) ( Math.random() * mainDeck.getSize() );
         pickedCard = mainDeck.get( cardSelector );
         System.out.println( pickedCard + " was picked by " + playerNameStrings[currentTurn] );
         mainDeck.remove(cardSelector);
         if ( mainDeck.getSize() == 0 )
            {
            mainDeck = new Deck();
            System.out.println( "Reshuffling deck..." );               
            }
         message.setText( playerNameStrings[currentTurn] + ", " + pickedCard.getDescription() );
         getChoosablePawns();
         repaint();                 
         }
      }
   
   /**
    * Get the 2D array that contains this board's grid.
    * @return Tile[][] 2D Tile array that contains the grid
    */
   public Tile[][] getGrid()
      {
      return grid;        
      }
   
   /**
    * Get the current turn in the game. 
    * @return int number of the player whose turn it is.
    */   
   public int getCurrentTurn() 
      {
      return currentTurn;             
      }
   
   /**
    * Get the last selected pawn. 
    * @return Pawn the pawn that was last selected.
    */   
   public Pawn getSelectedPawn()
      {
      return selectedPawn;          
      }
   
   /**
    * Set whether the current player needs to choose another pawn. 
    * @param boolean whether the player needs to choose another pawn.
    */   
   public void setTimeToChooseAgain( boolean b )
      {
      timeToChooseAgain = b; 
      System.out.println( "setTimeToChooseAgain = " + b );
      }
      
   /**
    * Get whether the current player needs to choose another pawn. 
    * @return boolean whether the player needs to choose another pawn.
    */ 
   public boolean getTimeToChooseAgain( )
      {
      return timeToChooseAgain;     
      }
   /**
    * Get int representation of PLAYER_YELLOW. 
    * @return int represents yellow.
    */    
   public static int getPLAYERYELLOW()
      {
      return PLAYER_YELLOW;            
      }
   /**
    * Get int representation of PLAYER_GREEN. 
    * @return int represents green.
    */  
   public static int getPLAYERGREEN()
      {
      return PLAYER_GREEN;            
      }
   /**
    * Get int representation of PLAYER_RED. 
    * @return int represents red.
    */  
   public static int getPLAYERRED()
      {
      return PLAYER_RED;            
      }
   /**
    * Get int representation of PLAYER_BLUE. 
    * @return int represents blue.
    */  
   public static int getPLAYERBLUE()
      {
      return PLAYER_BLUE;            
      }
      
   /**
    * Draws the graphics on the screen. 
    * @param Graphics draws the given graphics commands.
    */  
   public void paint(Graphics g)
      {
      int width =  getWidth();   // Find out the width of this component.
      int height = getHeight();  // Find out its height.
      g.drawImage( boardImage, 0, 0, null );  
      
      
      int color = 0;
      //goes through the players ArrayList and draws the pawns based on their (x,y) coordinates.
      for ( int pl = 0; pl < players.size(); pl++ )
         {
         if ( color == PLAYER_YELLOW )
            {
            g.setColor(Color.yellow);       
            }
         else if ( color == PLAYER_GREEN )
            {
            g.setColor(Color.green);       
            }
         else if ( color == PLAYER_RED )
            {
            g.setColor(Color.red);       
            }
         else if ( color == PLAYER_BLUE )
            {
            g.setColor(Color.blue);       
            }  
         for ( int pa = 0; pa < players.get(pl).getPawns().size(); pa++ )
            {
            //sets the color depending on the player whose pawns are being drawn      
            g.fillOval( 8 + players.get(pl).getPawns().get(pa).getPosX() * 40, 8 + players.get(pl).getPawns().get(pa).getPosY() * 40, 27, 27 );   
            //g.drawString(playerLetters[pl], 8 + players.get(pl).getPawns().get(pa).getPosX() * 40, 10 + players.get(pl).getPawns().get(pa).getPosY() * 40 );
            }
         color++;
         }
      g.setColor(Color.black);
      
      //draw a black circle around the pawns to make them easier to see.
      for ( int pl = 0; pl < players.size(); pl++ )
         {
         for ( int pa = 0; pa < players.get(pl).getPawns().size(); pa++ )
            {
            g.drawOval( 8 + players.get(pl).getPawns().get(pa).getPosX() * 40, 8 + players.get(pl).getPawns().get(pa).getPosY() * 40, 27, 27 );
            }
         }
       
      //draws a square around each pawn that is selectable if it is time to select a pawn.   
      if ( cPawns.size() != 0 && timeToSelect )
         {
         for ( int cp = 0; cp < cPawns.size(); cp++ )
            {
            g.drawRect (  8 + cPawns.get(cp).getPosX() * 40, 8 + cPawns.get(cp).getPosY() * 40, 27, 27 ) ;                
            }           
         }
      }
   }