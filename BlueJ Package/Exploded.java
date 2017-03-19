import info.gridworld.actor.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;

import java.awt.Color;

public class Exploded extends Spot
{
    public Exploded() {
        setColor(Color.RED);
    }
    
    public String getType() {
        return "Exploded";
    }
    
    public boolean isEmpty() { return false; }
}