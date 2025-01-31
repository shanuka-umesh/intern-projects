package org.example;

public class Main {

    static int canvasHeight = 20;
    static int canvasWidth = 20;

    public static void main(String[] args) {

        Canvas mainCanvas = new Canvas();
        char[][] canvas = mainCanvas.createCanvas(canvasHeight, canvasWidth);

        Shape shape = new Shape(canvas,canvasHeight,canvasWidth);

          shape.Createsquare(canvas,2,5,10);
          shape.CreateTriangle(canvas,5,5,4);

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

    public void CreateRoot(int startPositionX, int startPositionY)
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

    public Trunk(char[][] canvas)
    {
        this.canvas=canvas;
    }

    public void CreateTrunkBase(int startPositionX, int startPositionY)
    {

    }

    public void CreateTrunkOutline(int startPositionX, int startPositionY)
    {

    }
}
