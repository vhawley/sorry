//Victor Hawley 
//Submitted 28 Feb 2012
public class OneCard extends Card implements SpecialCard
   {
       
   /**
    * Tells a given SorryBoard b to move given Pawn p to the first tile in the track if the pawn was on a StartTile.
    * Otherwise, the board will move the pawn 1 space.
    * @param Pawn manipulate given pawn.
    * @param SorryBoard choose the board on which to manipulate pawn.
    */      
   public void specialFunction( Pawn p, SorryBoard b )
      {
      if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof StartTile )
         {
         if ( p.getCol() == SorryBoard.getPLAYERYELLOW() )
            {
            p.moveTo(4,0);    
            }
         if ( p.getCol() == SorryBoard.getPLAYERGREEN() )
            {
            p.moveTo(15,4);    
            }
         if ( p.getCol() == SorryBoard.getPLAYERRED() )
            {
            p.moveTo(11,15);    
            }
         if ( p.getCol() == SorryBoard.getPLAYERBLUE() )
            {
            p.moveTo(0,11);   
            } 
         b.setTimeToChooseAgain( false );
         }
      else
         {
         b.advance( p, getMoveValue() );
         b.setTimeToChooseAgain( false );
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
    * Creates a OneCard object with moveValue 1 and an appropriate description.
    */ 
   public OneCard()
      {
      setDescription( "Move a pawn from Start or \n move a pawn 1 space forward." );
      setMoveValue( 1 );
      } //end constructor    
       
   } //end class GenericCard