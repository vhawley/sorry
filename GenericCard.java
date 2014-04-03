//Victor Hawley 
//Submitted 28 Feb 2012
public class GenericCard extends Card
   { 
   /**
    * Constructor
    * @param int value of the amount of spaces a pawn moves.
    * @param String description of the card's description.
    */      
   public GenericCard( int m, String d )
      {
      this.setMoveValue( m );
      this.setDescription( d );         
      } //end constructor         
   } //end class GenericCard