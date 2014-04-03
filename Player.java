//Victor Hawley 
//Submitted 28 Feb 2012
import java.util.ArrayList;

public class Player
   {
   private ArrayList<Pawn> pawns = new ArrayList<Pawn>();
    
   /**
    * Constructor
    * @param int color of player you want to create
    */
   public Player( int color ) 
      {
      if ( color == SorryBoard.getPLAYERYELLOW() )
         {
         pawns.add( new Pawn( 4, 2, color ) );   
         pawns.add( new Pawn( 5, 2, color ) );
         pawns.add( new Pawn( 4, 3, color ) );
         pawns.add( new Pawn( 5, 3, color ) );
         }
      if ( color == SorryBoard.getPLAYERGREEN() )
         {
         pawns.add( new Pawn( 12, 4, color ) );   
         pawns.add( new Pawn( 12, 5, color ) );
         pawns.add( new Pawn( 13, 4, color ) );
         pawns.add( new Pawn( 13, 5, color ) );             
         }
      if ( color == SorryBoard.getPLAYERRED() )
         {
         pawns.add( new Pawn( 10, 12, color ) );   
         pawns.add( new Pawn( 10, 13, color ) );
         pawns.add( new Pawn( 11, 12, color ) );
         pawns.add( new Pawn( 11, 13, color ) );                 
         }
      if ( color == SorryBoard.getPLAYERBLUE() )
         {
         pawns.add( new Pawn( 2, 10, color ) );   
         pawns.add( new Pawn( 2, 11, color ) );
         pawns.add( new Pawn( 3, 10, color ) );
         pawns.add( new Pawn( 3, 11, color ) );
         }   
      System.out.println("Player " + (color + 1) + " created with 4 pawns...");
      }
   
   /**
    * Gets a player's ArrayList of pawns 
    * @return ArrayList<Pawn> set of pawns for player.
    */
   public ArrayList<Pawn> getPawns()
      {
      return pawns;    
      }
   } //end class Player