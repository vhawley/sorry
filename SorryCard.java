//Victor Hawley 
//Submitted 28 Feb 2012
import javax.swing.JOptionPane;

public class SorryCard extends Card implements SpecialCard
   {
   private Pawn oPawn;
      
   public void specialFunction( Pawn p, SorryBoard b )
      {
      if ( b.getCurrentTurn() == p.getCol() ) 
         {
         b.setTimeToChooseAgain(true);
         oPawn = p;
         b.getChoosablePawns();
         }
      else
         {   
         b.setTimeToChooseAgain(false);
         oPawn.moveTo( p.getPosX(), p.getPosY() );
         p.moveTo( p.getStartX(), p.getStartY() );                 
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
    * Creates a SorryCard object with moveValue 0 and an appropriate description.
    */ 
   public SorryCard()
      {
      setMoveValue( 0 );
      setDescription( "Move a pawn from Start and switch with an\nopponent's pawn on the track to send that pawn back to Start..." );                  
      } //end constructor
       
   } //end class GenericCard