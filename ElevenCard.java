//Victor Hawley 
//Submitted 28 Feb 2012
import javax.swing.*;

public class ElevenCard extends Card implements SpecialCard
   {
   private int tempX;
   private int tempY;
   private Pawn oPawn;
   
   public void specialFunction( Pawn p, SorryBoard b )
      {
      if ( b.getCurrentTurn() == p.getCol() ) 
         {
         if ( JOptionPane.showConfirmDialog( b, "Do you want to switch one of your pawns with an opposing pawn?\nChoosing no will allow you to move a pawn 11 spaces", "An 11 was drawn...", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION )
            {
            b.setTimeToChooseAgain(true);
            oPawn = p;
            tempX = p.getPosX();
            tempY = p.getPosY();
            b.getChoosablePawns();
            }
         else
            {
            b.advance( p, getMoveValue() );        
            }                 
         }
      else
         {   
         b.setTimeToChooseAgain(false);
         oPawn.moveTo( p.getPosX(), p.getPosY() );
         p.moveTo( tempX, tempY );                 
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
    * Creates a ElevenCard object with moveValue 11 and an appropriate description.
    */    
   public ElevenCard()
      {
      setMoveValue( 11 );
      setDescription( "Move 11 spaces forward or switch one of your pawns \n on the track with an opposing player's pawn on the track..." );         
      } //end constructor       
       
   } //end class GenericCard