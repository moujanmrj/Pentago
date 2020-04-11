import java.util.*;
/**
 * this class is the Tile class and has the 4 tiles in the board
 * and sets a new tile for a new game
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Tile
{
    //this filed is the tile which the marbles are put in
    private Marble[][] tiles;

    /**
     * this is the constructor we allocate space for our tile's position
     * and set them to no color in the beginning of the game
     */
    public Tile()
    {
        tiles = new Marble[3][3];
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                tiles[i][j] = new Marble();
                tiles[i][j].setColor("noColor");
            }
        }
    }

    /**
     * this method returns the tiles
     * @return the tiles
     */
    public Marble[][] getTiles() { return tiles; }

    /**
     * this method sets the tiles
     * @param tiles the tiles
     */
    public void setTiles(Marble[][] tiles) { this.tiles = tiles; }
}
