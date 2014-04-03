//Victor Hawley 
//Submitted 28 Feb 2012
public abstract class Card
   {
   private int moveValue;
   private String description;
   
   /**
    * Sets the description for the card.
    * @param String of the card's description.
    */
   public void setDescription( String s )
      {
      description = s;             
      }
   /**
    * Gets the description for the card.
    * @return String of the card's description.
    */      
   public String getDescription()
      {
      return description;             
      }
   /**
    * Sets the moveValue for the card.
    * @param int value of the amount of spaces a pawn moves.
    */   
   public void setMoveValue( int i )
      {
      moveValue = i;             
      }
   /**
    * Gets the moveValue for the card.
    * @return int value of the amount of spaces a pawn moves.
    */     
   public int getMoveValue()
      {
      return moveValue;             
      }     
   
   /**
    * Tells a given SorryBoard b to move given Pawn p moveValue spaces.
    * @param Pawn manipulate given pawn.
    * @param SorryBoard choose the board on which to manipulate pawn.
    */    
   public void act( Pawn p, SorryBoard b )
      {
      b.advance( p, moveValue );
      b.setTimeToChooseAgain( false );
      }
   
   /**
    * Returns the string value for the Card object.
    * @return string that returns the class type and moveValue.
    */     
   public String toString()
      {
      return ( this.getClass() + " with moveValue = " + moveValue );    
      }
   } //end class Card
   