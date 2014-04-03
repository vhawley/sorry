//Victor Hawley 
//Submitted 28 Feb 2012
import java.util.ArrayList;
public class Deck
   {
   ArrayList<Card> cards = new ArrayList<Card>();
   
   /**
    * Creates a deck with the full set of Sorry cards.
    */ 
   public Deck()
      {
      for( int index = 0; index < 4; index++ )
         {
         cards.add( new GenericCard( 3, "Move one of your pawns 3 spaces forward..." ) );
         cards.add( new GenericCard( 5, "Move one of your pawns 5 spaces forward..." ) );
         cards.add( new GenericCard( 8, "Move one of your pawns 8 spaces forward..." ) );
         cards.add( new GenericCard( 12, "Move one of your pawns 12 spaces forward..." ) );
         cards.add( new OneCard() );
         cards.add( new TwoCard() );
         cards.add( new FourCard() );
         cards.add( new SevenCard() );
         cards.add( new TenCard() );
         cards.add( new ElevenCard() );
         cards.add( new SorryCard() );
         }
      cards.add( new OneCard() ); //Adds an extra OneCard because a sorry deck has 5 OneCards.
      System.out.println( "Deck created. Total cards in deck: " + cards.size() );
      } 
   /**
    * A getter to choose a card from the deck.
    * @param Index to choose a card from.
    * @return Card at the index in the ArrayList of cards.
    */   
   public Card get( int index )
      {
      return cards.get(index);            
      }
   /**
    * Returns the current size of the deck (the cards ArrayList).
    */    
   public int getSize()
      {
      return cards.size();    
      }
   /**
    * Removes a card from the deck (the cards ArrayList).
    * @param int index which to remove card in the array
    */    
   public void remove( int i )
      {
      cards.remove( i );    
      }
   } //end class Deck