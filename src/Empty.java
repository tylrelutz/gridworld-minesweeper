import info.gridworld.actor.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;

public class Empty extends Spot
{
    public boolean isEmpty() { return true; }
    
    public String getType() {
        return "Empty";
    }
}