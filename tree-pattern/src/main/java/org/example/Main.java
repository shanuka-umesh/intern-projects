package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        char[][] canvas = createCanvas(10,10);



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

    public static void printCanvas()
    {


    }


}
