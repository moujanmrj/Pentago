import java.util.*;
/**
 * this class is the player class and has 2 players (black and white)
 * and holds the board we are playing in
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Player
{
    //this field holds the player color
    private String playerColor;
    //this field holds the board that the players are playing in
    private Board board;

    /**
     * this method returns the player color (black or white)
     *
     * @return player color
     */
    public String getPlayerColor() { return playerColor; }
    /**
     * this method returns the board we are playing in
     *
     * @return the board we're playing in
     */
    public Board getBoard() { return board; }

    /**
     * this method sets the player color (black or white)
     *
     * @param playerColor is the player color
     */
    public void setPlayerColor(String playerColor) { this.playerColor = playerColor; }
    /**
     * this method sets the board we are playing in
     *
     * @param board the board we're playing in
     */
    public void setBoard(Board board) { this.board = board; }

    /**
     * this method is the constructor
     * it gets a player and the board it wants to play in
     *
     * @param playerColor the player color (black or white)
     * @param board the board it wants to play in
     */
    public Player(String playerColor, Board board)
    {
        this.playerColor = playerColor;
        this.board = board;
    }

    /**
     * this method reads the move the player wants to play
     * and checks whether the move is valid or not
     *
     * @param tile the tile we want to put our marble in
     * @param position the position in the tile we want to put our marble in
     * @param rotatingTile the tile we want to rotate
     * @param direction the direction we want the tile to rotate (90 degrees clock or non-clockwise)
     * @param player the player who is playing
     */
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
        // if the move is valid we go to the next level if not the player turn will pass
        if (valid)
        {
            board.findTile(tile, position, player);
            board.findRotatingTile(rotatingTile, direction);
        }
    }
}
