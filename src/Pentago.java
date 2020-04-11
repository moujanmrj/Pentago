import java.util.*;

public class Pentago
{
    //the main
    public static void main(String[] args)
    {
        Board game = new Board();
        game.showMove();
        Player blackPlayer = new Player("black", game);
        Player whitePlayer = new Player("white", game);

        while (game.endGame().equals("continue"))
        {
            Scanner scanMove = new Scanner(System.in);
            System.out.println("White Turn");
            int tileWhite = scanMove.nextInt();
            int positionWhite = scanMove.nextInt();
            int rotatingTileWhite = scanMove.nextInt();
            String directionWhite = scanMove.nextLine();
            directionWhite = scanMove.nextLine();

            whitePlayer.readMove(tileWhite, positionWhite, rotatingTileWhite, directionWhite, "white");

            game.printBoard();
            String mode1 = game.endGame();
            if (!mode1.equals("continue"))
                break;

            System.out.println("Black Turn");
            int tileBlack = scanMove.nextInt();
            int positionBlack = scanMove.nextInt();
            int rotatingTileBlack = scanMove.nextInt();
            String directionBlack = scanMove.nextLine();
            directionBlack = scanMove.nextLine();

            blackPlayer.readMove(tileBlack, positionBlack, rotatingTileBlack, directionBlack, "black");

            game.printBoard();
            String mode2 = game.endGame();
            if (!mode2.equals("continue"))
                break;
        }
        switch (game.endGame())
        {
            case "black":
                System.out.println("Black Player Won! =))");
                break;
            case "white":
                System.out.println("White Player Won! =))");
                break;
            case "noWinner":
                System.out.println("No One Has Won! =((");
                break;
        }
    }
}
