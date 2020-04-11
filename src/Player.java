public class Player
{
    private String playerColor;

    private Board board;

    public String getPlayerColor() { return playerColor; }

    public Board getBoard() { return board; }

    public void setPlayerColor(String playerColor) { this.playerColor = playerColor; }

    public void setBoard(Board board) { this.board = board; }

    public Player(String playerColor, Board board)
    {
        this.playerColor = playerColor;
        this.board = board;
    }
    public void readMove(int tile, int position, int rotatingTile, String direction, String player)
    {
        boolean valid = true;
        if (!(tile>0 && tile<5))
        {
            System.out.println("Wrong Tile!");
            valid = false;
        }

        if (!(position>0 && position<10))
        {
            System.out.println("Wrong Position!");
            valid = false;

        }

        if (!(rotatingTile>0 && rotatingTile<5))
        {
            System.out.println("Wrong Tile For Rotation!");
            valid = false;

        }

        if (((direction.equals("right")) || (direction.equals("left"))))
        {
            valid = true;
        }
        else
        {
            System.out.println("Wrong Rotation Direction!");
            valid = false;
        }

        if (valid)
        {
            board.findTile(tile, position, player);
            board.findRotatingTile(rotatingTile, direction);
        }
    }
}
