package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int canvasHeight=20;
    static int canvasWidth=20;

    public static void main(String[] args) {

        char[][] canvas = createCanvas(canvasHeight,canvasWidth);

         Createsquare(canvas,2,5,10);

        CreateTriangle(canvas,5,5,4);

        printCanvas(canvas);

    }

    public static  char[][] createCanvas(int height, int width)
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

    public static void printCanvas(char[][] canvas)
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

    public static void Createsquare(char[][] canvas , int startPositionX , int startPositionY,int size)
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

    public static void CreateTriangle(char[][] canvas,int startPositionX, int startPositionY, int size)
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

}
