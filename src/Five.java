import info.gridworld.actor.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;

public class Five extends Spot
{
    public boolean isEmpty() { return false; }
    
    public String getType() {
        return "Five";
    }
}