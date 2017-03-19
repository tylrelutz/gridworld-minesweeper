import info.gridworld.actor.*;
import info.gridworld.world.*;
import info.gridworld.grid.*;

public class Game {

    private static BoundedGrid<Actor> gr;
    private static ActorWorld world;
    private static int x = 9;
    private static int y = 9;
    private static int bombs = 12;

    public static void main() {
        gr = new BoundedGrid<Actor>(x,y);
        world = new ActorWorld(gr);

        Spot a = new First(bombs, x*y);

        fillGrid();

        world.show();
    }

    protected static void fillGrid() {
        fillGridWithBombs();
        for (int r = 0; r < x; r++) {
            for (int c = 0; c < y; c++) {
                Location l = new Location(r,c);
                int surroundingBombs = countBombs(findSurroundingBombs(l));
                Spot a;
                Spot b = (Spot)(gr.get(l));
                if (b == null) {

                    if (surroundingBombs == 1) {
                        a = new First("One");
                    } else if (surroundingBombs == 2) {
                        a = new First("Two");
                    } else if (surroundingBombs == 3) {
                        a = new First("Three");
                    } else if (surroundingBombs == 4) {
                        a = new First("Four");
                    } else if (surroundingBombs == 5) {
                        a = new First("Five");
                    } else if (surroundingBombs == 6) {
                        a = new First("Six");
                    } else if (surroundingBombs == 7) {
                        a = new First("Seven");
                    } else if (surroundingBombs == 8) {
                        a = new First("Eight");
                    } else {
                        a = new First("Empty");
                    }
                    a.putSelfInGrid(gr,l);
                }
            }
        }
    }

    protected static int countBombs(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            }
        }
        return count;
    }

    protected static int[] findSurroundingBombs(Location l) {
        int[] result = new int[8];
        Location[] locs = {
                l.getAdjacentLocation(Location.NORTHWEST), l.getAdjacentLocation(Location.NORTH),
                l.getAdjacentLocation(Location.NORTHEAST), l.getAdjacentLocation(Location.WEST), 
                l.getAdjacentLocation(Location.EAST), l.getAdjacentLocation(Location.SOUTHWEST),
                l.getAdjacentLocation(Location.SOUTH), l.getAdjacentLocation(Location.SOUTHEAST)
            };
        int count = 0;
        for (Location loc : locs) {
            Spot current = null;
            if (gr.isValid(loc) && gr.get(loc) != null) {
                current = (Spot)(gr.get(loc));
            }
            if (current != null && gr.isValid(loc) && current.getType().equals("Mine")) {
                result[count] = 1;
            } else {
                result[count] = 0;
            }
            count++;
        }
        return result;
    }

    protected static void fillGridWithBombs() {
        int count = 0;
        while (count < bombs) {
            for (int r = 0; r < x; r++) {
                for (int c = 0; c < y; c++) {
                    double rand = Math.random();
                    if (rand < .5 && count < bombs) {
                        Spot a = new First("Mine");
                        world.add(a);
                        count++;
                    }
                }
            }
        }
    }
}