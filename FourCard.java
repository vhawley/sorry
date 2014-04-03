//Victor Hawley 
//Submitted 28 Feb 2012
public class FourCard extends Card implements SpecialCard
   {
       
   /**
    * Tells a given SorryBoard b to move given Pawn p to the first tile in the track if the pawn was on a StartTile.
    * If the chosen pawn is on the track, it will move it 1 space.
    * @param Pawn manipulate given pawn.
    * @param SorryBoard choose the board on which to manipulate pawn.
    */     
   public void specialFunction( Pawn p, SorryBoard b )
      {
      for ( int move = 0; move < getMoveValue(); move++ )
         {
         if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 0 ) && (p.getPosY() > 0 ) && (p.getPosY() < 15 ) )
            {
            p.moveTo( p.getPosX(), p.getPosY() + 1 );   
            }
         else if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 0 ) && (p.getPosY() == 0 ) )
            {
            p.moveTo( p.getPosX(), p.getPosY() + 1 ); 
            }
         else if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 15 ) && (p.getPosY() == 15 ) )
            {
            p.moveTo( p.getPosX(), p.getPosY() - 1 ); 
            }
         else if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 15 ) && (p.getPosY() == 0 ) )
            {
            p.moveTo( p.getPosX() - 1, p.getPosY() ); 
            }      
         else if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() > 0 ) && (p.getPosX() < 15 ) && (p.getPosY() == 0 ) )
            {
            p.moveTo( p.getPosX() - 1, p.getPosY() ); 
            }
         else if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 15 ) && (p.getPosY() < 15 ) && (p.getPosY() > 0 ) )
            {
            p.moveTo( p.getPosX(), p.getPosY() - 1 );
            }
         else if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() > 0 ) && (p.getPosX() < 15 ) && (p.getPosY() == 15 ) )
            {
            p.moveTo( p.getPosX() + 1, p.getPosY() );  
            }
         else if ( b.getGrid()[p.getPosX()][p.getPosY()] instanceof TrackTile && (p.getPosX() == 0 ) && (p.getPosY() == 15 ) )
            {
            p.moveTo( p.getPosX() + 1, p.getPosY() );  
            }     
         }
      b.setTimeToChooseAgain( false );   
      } //end method specialFunction   
   /**
    * Overrides act to call specialFunction.
    */  
   public void act( Pawn p, SorryBoard b )
      {
      specialFunction( p, b );
      }   
   /**
    * Creates a FourCard object with moveValue 4 and an appropriate description.
    */ 
   public FourCard()
      {
      setMoveValue( 4 );
      setDescription( "Move one of your pawns 4 spaces BACKWARDS..." );         
      } //end constructor     
       
   } //end class GenericCard