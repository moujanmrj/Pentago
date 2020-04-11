
public class Tile
{
    private Marble[][] tiles;

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

    public Marble[][] getTiles() { return tiles; }

    public void setTiles(Marble[][] tiles) { this.tiles = tiles; }
}
