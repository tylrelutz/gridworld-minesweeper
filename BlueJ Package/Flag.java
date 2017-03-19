import info.gridworld.actor.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;

public class Flag extends Spot
{
    private boolean empty;
    private String contents;
    
    public Flag(String contents) {
        this.contents = contents;
        if (this.contents.equals("Empty")) {
            empty = true;
        } else {
            empty = false;
        }
    }
    
    protected boolean isEmpty() { return empty; }
    
    public String getType() {
        return contents;
    }
    
    public void toggleFlag() {
        Location l = getLocation();
        Spot a = new First(contents);
        a.putSelfInGrid(getGrid(),l);
    }
}