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
    
}
