//Victor Hawley 
//Submitted 28 Feb 2012
import javax.swing.JOptionPane;

public class TenCard extends Card implements SpecialCard
   {
   public void specialFunction( Pawn p, SorryBoard b )
      {
      if ( JOptionPane.showConfirmDialog( b, "Do you want to move this pawn backwards 1 space?\nChoosing no will move this pawn 10 spaces FORWARD", "A 10 was drawn...", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION )
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
      else 
         {
         b.advance( p, getMoveValue() ); 
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
    * Creates a TenCard object with moveValue 10 and an appropriate description.
    */    
   public TenCard( )
      {
      setMoveValue( 10 );
      setDescription( "Move a pawn 10 spaces forward OR 1 space BACKWARDS..." );         
      } //end constructor       
       
   } //end class GenericCard