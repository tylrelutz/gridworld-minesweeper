import info.gridworld.actor.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;

import java.util.ArrayList;

public class First extends Spot
{
    private boolean empty;
    private String contents;

    public First(String contents) {
        this.contents = contents;
        if (this.contents.equals("Empty")) {
            empty = true;
        } else {
            empty = false;
        }
    }
    
    public First(int a, int b) {
        super(a,b);
    }

    protected boolean isEmpty() {
        return empty;
    }

    public String getType() {
        return contents;
    }

    public void toggleFlag() {
        Location l = getLocation();
        Spot a = new Flag(contents);
        a.putSelfInGrid(getGrid(),l);
    }

    public void uncover() {
        Spot s;
        //System.out.println(spotsLeft);
        if (getType().equals("One")) {
            s = new One();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Two")) {
            s = new Two();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Three")) {
            s = new Three();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Four")) {
            s = new Four();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Five")) {
            s = new Five();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Six")) {
            s = new Six();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Seven")) {
            s = new Seven();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Eight")) {
            s = new Eight();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
        } else if (getType().equals("Empty")) {
            s = new Empty();
            s.putSelfInGrid(getGrid(),getLocation());
            spotsLeft--;
            ArrayList<Actor> n = s.getGrid().getNeighbors(s.getLocation());
            for (Actor a : n) {
                Location ss = a.getLocation();
                if (ss != null) {
                    ((Spot)(s.getGrid().get(ss))).uncover();
                }
            }
        } else if (getType().equals("Mine")) {
            s = new Exploded();
            s.putSelfInGrid(getGrid(),getLocation());
            ((Spot)(s.getGrid().get(new Location(s.getGrid().getNumRows()-1,s.getGrid().getNumCols()-1)))).uncoverAll();
        }
        checkWin();
    }

}