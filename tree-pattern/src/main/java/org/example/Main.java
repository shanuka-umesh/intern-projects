package org.example;

import java.util.Random;

public class Main {

    static int canvasHeight = 40;
    static int canvasWidth = 40;

    public static void main(String[] args) {

        Canvas mainCanvas = new Canvas();
        char[][] canvas = mainCanvas.createCanvas(canvasHeight, canvasWidth);

      //  Shape shape = new Shape(canvas,canvasHeight,canvasWidth);
        Trunk trunk = new Trunk(canvas);

      //    shape.Createsquare(canvas,2,5,10);
      //    shape.CreateTriangle(canvas,5,5,4);

          trunk.CreateTrunkBase(24,18,14,2);
          trunk.CreateTrunkOutline();
          trunk.createLeftBranch(28,17,5);
        trunk.createLeftBranch(32,17,3);

        mainCanvas.printCanvas(canvas);

    }

}

class Canvas{

    public char[][] createCanvas(int height, int width)
    {
        char[][] canvas = new char[height][width];

        for(int i=0; i<height; i++)
        {
            for(int j=0; j<width ; j++)
            {
                canvas[i][j]= ' ';
            }
        }
        return canvas;
    }

    public void printCanvas(char[][] canvas)
    {

        //  System.out.println(canvas.length);

        for (int i = 0; i < canvas.length; i++)
        {
            for (int j = 0; j< canvas[i].length; j++)
            {
                if(i==0||j==0||i==canvas.length-1||j==canvas[i].length-1)
                {
                    System.out.print("` ");
                }
                else {
                    System.out.print(canvas[i][j] + " ");
                }

            }
            System.out.println("");
        }

    }

}

class Shape{

     int canvasWidth, canvasHeight;
    char[][] canvas;

    public Shape(char[][] canvas,int canvasHeight, int canvasWidth)
    {
        this.canvasHeight=canvasHeight;
        this.canvasWidth=canvasWidth;
        this.canvas=canvas;
    }

    public void CreateTriangle(char[][] canvas,int startPositionX, int startPositionY, int size)
    {
        for (int i = 0; i < size; i++)
        {
            int spaces = size - i - 1; // Leading spaces for centering
            int stars = 2 * i + 1; // Number of stars in current row

            for (int j = 0; j < spaces; j++)
            {
                canvas[startPositionX + i][startPositionY + j] = ' ';
            }

            for (int j = 0; j < stars; j++)
            {
                canvas[startPositionX + i][startPositionY + spaces + j] = '*';
            }
        }
    }

    public void Createsquare(char[][] canvas , int startPositionX , int startPositionY,int size)
    {
        if(canvasHeight>startPositionX+size && canvasWidth > startPositionY+size )
        {
            for(int i =startPositionX ; i<startPositionX+size ; i++ )
            {
                for(int j=startPositionY ; j<startPositionY+size ; j++)
                {
                    canvas[i][j]='*';
                }
            }
        }
        else
        {
            System.out.println("\nShape must be placed in canvas. Please place the shape inside the canvas");
            System.exit(0);
        }

    }

}

class Root{

    char[][] canvas;

    public Root(char[][] canvas)
    {
        this.canvas=canvas;
    }

    public void CreateRootBase(int startPositionX, int startPositionY)
    {

    }

}

class Leave{

    char[][] canvas;

    public Leave(char[][] canvas)
    {
        this.canvas=canvas;
    }

    public void CreateLeave(int startPositionX, int startPositionY)
    {

    }

}

class Trunk{

    char[][] canvas;
    int trunkBaseStartX , trunkBaseStartY, trunkBaseSizeX,trunkBaseSizeY;

    public Trunk(char[][] canvas)
    {
        this.canvas=canvas;
    }

    public void CreateTrunkBase(int startPositionX, int startPositionY,int sizeX, int sizeY)
    {
        trunkBaseStartY=startPositionY;
        trunkBaseStartX=startPositionX;
        trunkBaseSizeX=sizeX;
        trunkBaseSizeY=sizeY;

        for(int i=startPositionX ; i<startPositionX+sizeX ; i++)
        {
            for(int j=startPositionY ; j<startPositionY+sizeY ; j++)
            {
                canvas[i][j]=' ';
            }
        }
    }

    public void CreateTrunkOutline() {

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

            if (x >= 0 && y >= 0)
            {
                canvas[x][y] = '\\';
            }

            if (x - 1 >= 0 && y >= 0)
            {
                canvas[x - 1][y] = '\\';
            }
        }
    }



}
