package org.example;

import java.util.Random;

class Canvas {
    public char[][] createCanvas(int height, int width)
    {
        char[][] canvas = new char[height][width];

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                canvas[i][j] = ' ';
            }
        }
        return canvas;
    }

    public void printCanvas(char[][] canvas)
    {
        for (int i = 0; i < canvas.length; i++)
        {
            for (int j = 0; j < canvas[i].length; j++)
            {
                if (i == 0 || j == 0 || i == canvas.length - 1 || j == canvas[i].length - 1)
                {
                    System.out.print("` ");
                }

                else
                {
                    System.out.print(canvas[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}


class Trunk {
    char[][] canvas;
    private int trunkBaseStartX, trunkBaseStartY, trunkBaseSizeX, trunkBaseSizeY;

    public Trunk(char[][] canvas)
    {
        this.canvas = canvas;
    }

    public void CreateTrunkBase(int startPositionX, int startPositionY, int sizeX, int sizeY)
    {
        trunkBaseStartY = startPositionY;
        trunkBaseStartX = startPositionX;
        trunkBaseSizeX = sizeX;
        trunkBaseSizeY = sizeY;
        for (int i = startPositionX; i < startPositionX + sizeX; i++)
        {
            for (int j = startPositionY; j < startPositionY + sizeY; j++)
            {
                canvas[i][j] = ' ';
            }
        }
    }

    public void CreateTrunkOutline()
    {
        Random r = new Random();
        String characters = "/\\{}";
        for (int i = trunkBaseStartX; i < trunkBaseStartX + trunkBaseSizeX; i++)
        {
            if (trunkBaseStartX > 0)
            {
                canvas[i][trunkBaseStartY - 1] = characters.charAt(r.nextInt(characters.length()));
            }

            if (trunkBaseStartY + trunkBaseSizeY < canvas[0].length)
            {
                canvas[i][trunkBaseStartY + trunkBaseSizeY] = characters.charAt(r.nextInt(characters.length()));
            }
        }
    }

    public void createLeftBranch(int branchStartX, int branchStartY, int branchSizeY)
    {
        for (int i = 0; i < branchSizeY; i++)
        {
            int x = branchStartX - i;
            int y = branchStartY - i;

            if (x >= 0 && y >= 0) {
                canvas[x][y] = '\\';
            }

            if (x - 1 >= 0 && y >= 0)
            {
                canvas[x - 1][y] = '\\';
            }
        }
    }

    public void createRightBranch(int branchStartX, int branchStartY, int branchSizeY)
    {
        for (int i = 0; i < branchSizeY; i++)
        {
            int x = branchStartX - i;
            int y = branchStartY + i;

            if (x >= 0 && y < canvas[0].length)
            {
                canvas[x][y] = '/';
            }

            if (x - 1 >= 0 && y < canvas[0].length)
            {
                canvas[x - 1][y] = '/';
            }
        }
    }
}

class Leave {
    char[][] canvas;

    public Leave(char[][] canvas)
    {
        this.canvas = canvas;
    }

    public void CreateLeave(int startPositionX, int startPositionY,String size)
    {
        if(size=="large")
        {

        }
        else
        {

        }
    }
}

class Root {

    private char [][] canvas;

    public Root(char[][] canvas)
    {
        this.canvas=canvas;
    }

    public void addRoot()
    {

    }

}
