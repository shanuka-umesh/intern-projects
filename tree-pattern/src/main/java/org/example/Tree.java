package org.example;

public class Tree {
    private char[][] canvas;
    private Trunk trunk;

    public Tree(char[][] canvas) {
        this.canvas = canvas;
        this.trunk = new Trunk(canvas);
    }

    public void buildTree() {

        int trunkBaseWidth = 3;
        int trunkBaseHeight = 14;
        int startPositionX = 24;
        int startPositionY = 18;

        trunk.CreateTrunkBase(startPositionX, startPositionY, trunkBaseHeight,trunkBaseWidth);
        trunk.CreateTrunkOutline();
        trunk.createLeftBranch(startPositionX+4, startPositionY-1, 5);
        trunk.createLeftBranch(startPositionX+10, startPositionY-1, 3);
        trunk.createRightBranch(startPositionX+6,startPositionY+trunkBaseWidth+1,6);

    }
}
