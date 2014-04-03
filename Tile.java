//Victor Hawley 
//Submitted 28 Feb 2012
public abstract class Tile
   {
   private int color;
   private boolean taken;
   
   /**
    * Sets the color of the tile, if applicaable.
    * @param int the int representation of the color
    */
   public void setColor( int c )
      {
      color = c;
      }
   /**
    * Gets the color of the tile, if applicaable.
    * @return int the int representation of the color
    */ 
   public int getColor()
      {
      return color;    
      }
   /**
    * Sets the state of the tile (whether it is occupied)
    * @param boolean whether the tile is taken or not
    */   
   public void setTaken( boolean t )
      {
      taken = t;
      }
   /**
    * Gets the state of the tile (whether it is occupied)
    * @return boolean whether the tile is taken or not
    */
   public boolean getTaken()
      {
      return taken;    
      }  
     
   } //end class Tile
   
   