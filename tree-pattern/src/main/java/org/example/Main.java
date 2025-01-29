package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        char[][] canvas = createCanvas(10,10);

        square(canvas,2,2);

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

      //  System.out.println(canvas[1]);

        for (int i = 0; i < canvas.length; i++)
        {
            for (int j = 0; j< canvas[i].length; j++)
            {
                System.out.print(canvas[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static void square(char[][] canvas , int startPositionX , int startPositionY)
    {
        for(int i =startPositionX ; i<startPositionX+3 ; i++ )
        {
            for(int j=startPositionY ; j<startPositionY+3 ; j++)
            {
                canvas[i][j]='*';
            }
        }
    }


}
