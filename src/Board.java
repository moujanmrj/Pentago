
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

    public void showMove()
    {
        System.out.println("-----------------------------");
        System.out.println("|   Tile 1  | * |  Tile 2   |");
        System.out.println("| 1 | 2 | 3 | * | 1 | 2 | 3 |");
        System.out.println("| 4 | 5 | 6 | * | 4 | 5 | 6 |");
        System.out.println("| 7 | 8 | 9 | * | 7 | 8 | 9 |");
        System.out.println("|***************************|");
        System.out.println("|   Tile 3  | * |  Tile 4   |");
        System.out.println("| 1 | 2 | 3 | * | 1 | 2 | 3 |");
        System.out.println("| 4 | 5 | 6 | * | 4 | 5 | 6 |");
        System.out.println("| 7 | 8 | 9 | * | 7 | 8 | 9 |");
        System.out.println("-----------------------------");
        System.out.println("1) Please Enter The Number Of Tile You Want To Put Your Marble In And Then Press Enter");
        System.out.println("2) Please Enter The Number Of Position You Want To Put Your Marble In And Then Press Enter");
        System.out.println();
        System.out.println("3) Please Enter The Number Of Tile You Want To Rotate And Then Press Enter");
        System.out.println("4) And Now Please Direction Of The Rotation(type left or right) And Then Press Enter");
        System.out.println();
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

    public String endGame()
    {
        String[][] checkWin = new String[6][6];
        for (int i=0; i<6; i++)
        {
            for (int j=0; j<6; j++)
            {
                checkWin[i][j] ="noColor";
            }
        }


        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                checkWin[i][j] = boardGame[0].getTiles()[i][j].getColor();
            }
        }
        int x = 3, y = 3;
        for (int i=0; i<3; i++)
        {
            y = 3;
            for (int j=0; j<3; j++)
            {
                checkWin[i][y] = boardGame[1].getTiles()[i][j].getColor();
                y++;
            }
        }
        x = 2;
        for (int i=0; i<3; i++)
        {
            x++;
            for (int j=0; j<3; j++)
            {
                checkWin[x][j] = boardGame[2].getTiles()[i][j].getColor();
            }
        }
        x = 2;
        y = 3;
        for (int i=0; i<3; i++)
        {
            x++;
            y = 3;
            for (int j=0; j<3; j++)
            {
                checkWin[x][y] = boardGame[3].getTiles()[i][j].getColor();
                y++;
            }
        }


        if ////
            return "black";
        else if ////
            return "white";
        else
        {
            boolean full = true;
            for (int i=0; i<6; i++)
            {
                for (int j=0; j<6; j++)
                {
                    if (checkWin[i][j].equals("noColor"))
                    {
                        full = false;
                        break;
                    }
                }
            }
            if (full)
                return "noWinner";
            else
                return "continue";
        }
    }
}
