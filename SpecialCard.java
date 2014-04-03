//Victor Hawley 
//Submitted 28 Feb 2012
public interface SpecialCard
   {
   /**
    * Tells a given SorryBoard b to manipulate given Pawn p.
    * @param Pawn manipulate given pawn.
    * @param SorryBoard choose the board on which to manipulate pawn.
    */       
   public abstract void specialFunction( Pawn p, SorryBoard b );          
   } //end interface SpecialCard