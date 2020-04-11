
public class Board
{
    private Tile[] boardGame;

    public Board()
    {
        boardGame = new Tile[4];
        for (int i=0; i<4; i++)
        {
            boardGame[i] = new Tile();
        }
    }
    public void printBoard()
    {
        System.out.println("---------------------------------");
        for (int i=0; i<4; i+=2)
        {
            if (i == 2)
                System.out.println("*********************************");
            printTiles(boardGame[i],boardGame[i+1]);
        }
        System.out.println("---------------------------------");
    }

    public void printTiles(Tile tile1,Tile tile2)
    {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                switch (tile1.getTiles()[i][j].getColor())
                {
                    case "noColor":
                        System.out.print("|    ");
                        break;
                    case "black":
                        System.out.print("| \u25EF ");
                        break;
                    case "white":
                        System.out.print("| \u2B24 ");
                        break;
                }
            }
            System.out.print("|*");
            for (int j=0; j<3; j++)
            {
                switch (tile2.getTiles()[i][j].getColor())
                {
                    case "noColor":
                        System.out.print("|    ");
                        break;
                    case "black":
                        System.out.print("| \u25EF ");
                        break;
                    case "white":
                        System.out.print("| \u2B24 ");
                        break;
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

  
    public void putMarble(String player, int position,Tile tile)
    {
        int count = 1;
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                if (count == position) {
                    tile.getTiles()[i][j].setColor(player);
                }
                count++;
            }
        }
    }

    public void findTile(int tile, int position, String player)
    {
        for (int i=0; i<4; i++)
        {
            if(tile == 1)
            {
                putMarble(player, position, boardGame[0]);
                break;
            }
            if(tile == 2)
            {
                putMarble(player, position, boardGame[1]);
                break;
            }
            if(tile == 3)
            {
                putMarble(player, position, boardGame[2]);
                break;
            }
            if(tile == 4)
            {
                putMarble(player, position, boardGame[3]);
                break;
            }
        }
    }

    public void rotateTile(String direction, Tile tile)
    {
        if (direction.equals("left"))
        {
            for (int i = 0; i < 3 / 2; i++)
            {
                for (int j = i; j < 3 - i - 1; j++)
                {
                    Marble temp = tile.getTiles()[i][j];
                    tile.getTiles()[i][j] = tile.getTiles()[j][3 - 1 - i];
                    tile.getTiles()[j][3 - 1 - i] = tile.getTiles()[3 - 1 - i][3 - 1 - j];
                    tile.getTiles()[3 - 1 - i][3 - 1 - j] = tile.getTiles()[3 - 1 - j][i];
                    tile.getTiles()[3 - 1 - j][i] = temp;
                }
            }
        }
        else if (direction.equals("right"))
        {
            for (int i = 0; i < 3 / 2; i++)
            {
                for (int j = i; j < 3 - i - 1; j++)
                {
                    Marble temp = tile.getTiles()[i][j];
                    tile.getTiles()[i][j] = tile.getTiles()[3 - 1 - j][i];
                    tile.getTiles()[3 - 1 - j][i] = tile.getTiles()[3 - 1 - i][3 - 1 - j];
                    tile.getTiles()[3 - 1 - i][3 - 1 - j] = tile.getTiles()[j][3 - 1 - i];
                    tile.getTiles()[j][3 - 1 - i] = temp;
                }
            }
        }
    }

    public void findRotatingTile(int tile, String direction)
    {
        for (int i=0; i<4; i++)
        {
            if(tile == 1)
            {
                rotateTile(direction, boardGame[0]);
                break;
            }
            if(tile == 2)
            {
                rotateTile(direction, boardGame[1]);
                break;
            }
            if(tile == 3)
            {
                rotateTile(direction, boardGame[2]);
                break;
            }
            if(tile == 4)
            {
                rotateTile(direction, boardGame[3]);
                break;
            }
        }
    }
}
