import info.gridworld.actor.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;

public abstract class Spot extends Actor 
{
    private String type;
    private static int bombs;
    protected static int spotsLeft;
    
    public Spot() {
        setColor(null);
    }
    
    public Spot(int bombs, int totalSpots) {
        this.bombs = bombs;
        this.spotsLeft = totalSpots;
    }
    
    public void act() {
        
    }
    
    public void checkWin() {
        System.out.println(this.spotsLeft);
        if (this.spotsLeft == this.bombs ) {
            System.out.println("You won!");
        }
    }
    
    protected abstract boolean isEmpty(); // only returns true in Empty class
    
    public abstract String getType();
    
    protected void setType(String type) {
        this.type = type;
    }
    
    public void uncover() {
        // meant to be overridden in subclasses
    }
    
    // only can be called on bottom right corner
    protected void uncoverAll() {
        int maxr = getGrid().getNumRows();
        int maxc = getGrid().getNumCols();
        for (int r = 0; r < maxr; r++) {
            for (int c = 0; c < maxc; c++) {
                Location l = new Location(r,c);
                Actor a = getGrid().get(l);
                Spot s = (Spot)a;
                if (s.getType().equals("One")) {
                    s = new One();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Two")) {
                    s = new Two();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Three")) {
                    s = new Three();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Four")) {
                    s = new Four();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Five")) {
                    s = new Five();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Six")) {
                    s = new Six();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Seven")) {
                    s = new Seven();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Eight")) {
                    s = new Eight();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Empty")) {
                    s = new Empty();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Mine")) {
                    s = new Mine();
                    s.putSelfInGrid(getGrid(),l);
                } else if (s.getType().equals("Exploded")) {
                    s = new Exploded();
                    s.putSelfInGrid(getGrid(),l);
                }
            }
        }
        System.out.println("Game over");
    }
    
}