package org.example;

public class Main {
    static int canvasHeight = 40;
    static int canvasWidth = 40;

    public static void main(String[] args) {
        Canvas mainCanvas = new Canvas();
        char[][] canvas = mainCanvas.createCanvas(canvasHeight, canvasWidth);

        Tree tree = new Tree(canvas);
        tree.buildTree();

        mainCanvas.printCanvas(canvas);
    }
}
