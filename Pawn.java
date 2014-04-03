//Victor Hawley 
//Submitted 28 Feb 2012
public class Pawn
   {
   private int startX;
   private int startY;
   private int posX;
   private int posY;
   private int color;
   private boolean facingForward;
   private boolean selectable; //Looking back I don't think I used this but I'm keeping it just to be safe.
   
   /**
    * Two argument constructor to create a pawn with given coordinates. 
    * @param int x coordinate
    * @param int y coordinate
    * @param int representation of the color as an int
    */   
   public Pawn( int x, int y, int c )
      {
      setPosX( x );
      setPosY( y );
      startX = x;
      startY = y;
      facingForward = true;
      setCol( c );
      System.out.println( "Pawn for player " + ( c + 1 ) + " created with coordinates (" + x + "," + y + ").");
      } //end constructor 
   
   /**
    * Moves pawn to a certain (x,y) location.
    * @param int desired x-coordinate
    * @param int desired y-coordinate
    */     
   public void moveTo( int x, int y )
      {
      System.out.println( this + " moved to coordinates (" + x + "," + y + ")." );
      setPosX(x);
      setPosY(y); 
      }
   
   /**
    * sets a pawn's x coordinate
    * @param int desired x-coordinate
    */
   public void setPosX( int x )
      {
      if ( x < 0 ) 
         {
         posX = 0;               
         }
      else if ( x > 15 )
         {
         posX = 15;       
         }
      else
         {
         posX = x;             
         }
      }
   /**
    * sets a pawn's y coordinate
    * @param int desired y-coordinate
    */   
   public void setPosY( int y ) 
      {
      if ( y < 0 ) 
         {
         posY = 0;               
         }
      else if ( y > 15 )
         {
         posY = 15;       
         }
      else
         {
         posY = y;             
         }    
      }
   /**
    * sets a pawn's color int value
    * @param int color
    */
   public void setCol( int c )
      {
      color = c;           
      }
   /**
    * sets a pawn's x coordinate
    * @return int x-coordinate
    */     
   public int getPosX()
      {
      return posX;            
      }
   /**
    * sets a pawn's y coordinate
    * @return int y-coordinate
    */
   public int getPosY()
      {
      return posY;           
      }
   /**
    * sets a pawn's starting x coordinate
    * @return int x-coordinate
    */ 
   public int getStartX()
      {
      return startX;            
      }
   /**
    * sets a pawn's starting Y coordinate
    * @return int y-coordinate
    */ 
   public int getStartY()
      {
      return startY;           
      }
   /**
    * sets a pawn's color as an int
    * @return int color
    */      
   public int getCol()
      {
      return color;    
      }
   /**
    * sets whether a pawn is facing forward or backwards.
    * @param boolean whether the pawn is facing forward
    */
   public void setFacingForward( boolean b )
      {
      System.out.println( this + " facing foward now " + b );
      facingForward = b;     
      }
   /**
    * sets whether a pawn is selectable.
    * @param boolean whether the pawn is selectable
    */   
   //Looking back I don't think I used this but I'm keeping it just to be safe.
   public void setSeletable( boolean s )
      {
      selectable = s;           
      }
   /**
    * gets whether a pawn is facing forward or backwards.
    * @return boolean whether the pawn is facing forward
    */   
   public boolean getFacingForward()
      {
      return facingForward;           
      }
   /**
    * Returns the string value for the Pawn object.
    * @return string that returns the player number and (x,y) coordinates.
    */     
   public String toString()
      {
      return "Pawn owned by Player #" + ( color + 1 ) + " at (" + posX + "," + posY + ")";         
      }
   } //end class Pawn