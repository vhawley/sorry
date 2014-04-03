//Victor Hawley 
//Submitted 28 Feb 2012
import javax.swing.JOptionPane;

public class SevenCard extends Card implements SpecialCard
   {
   private Pawn p1;
   private Pawn p2;
   private int p1moved;
   private int p2moved;
       
   public void specialFunction( Pawn p, SorryBoard b )
      {
      if ( b.getTimeToChooseAgain() == false )
         {
         p1moved = Integer.parseInt( JOptionPane.showInputDialog( "Choose a number from 1 to " + getMoveValue() + " to move this pawn.\nAfter moving, if there are any spaces left,\nyou can choose another pawn to move the rest of your turn." ) );    
         while ( p1moved > getMoveValue() || p1moved < 1 )
            {
            p1moved = Integer.parseInt( JOptionPane.showInputDialog( "Choose a number from 1 to " + getMoveValue() + " to move this pawn.\nAfter moving, if there are any spaces left,\nyou can choose another pawn to move the rest of your turn." ) );
            }
         b.advance( p, p1moved );
         b.setTimeToChooseAgain( true );
         b.getChoosablePawns();
         }
      else
         {
         b.setTimeToChooseAgain( false );
         p2moved = getMoveValue() - p1moved;
         b.advance( p, p2moved );
         }
      } //end method specialFunction    
   
   /**
    * Overrides act to call specialFunction.
    */  
   public void act( Pawn p, SorryBoard b )
      {
      specialFunction( p, b );             
      }   
   /**
    * Creates a SevenCard object with moveValue 7 and an appropriate description.
    */    
   public SevenCard()
      {
      setMoveValue( 7 );
      setDescription( "Move a pawn 7 spaces or \nsplit 7 between between two pawns..." );         
      } //end constructor       
       
   } //end class SevenCard