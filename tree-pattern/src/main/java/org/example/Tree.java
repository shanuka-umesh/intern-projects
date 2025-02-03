package org.example;

public class Tree {
    private char[][] canvas;
    private Trunk trunk;
    private Leave leave;


    public Tree(char[][] canvas) {
        this.canvas = canvas;
        this.trunk = new Trunk(canvas);
        this.leave = new Leave(canvas);
    }

    public void buildTree() {

        int trunkBaseWidth = 3;
        int trunkBaseHeight = 18;
        int startPositionX = 20;
        int startPositionY = 18;

        trunk.CreateTrunkBase(startPositionX, startPositionY, trunkBaseHeight,trunkBaseWidth);
        trunk.CreateTrunkOutline();
        trunk.createLeftBranch(startPositionX+4, startPositionY-1, 5);
        trunk.createLeftBranch(startPositionX+10, startPositionY-1, 3);
        trunk.createRightBranch(startPositionX+6,startPositionY+trunkBaseWidth+1,6);

        leave.createLeaf(15,15,"large");
        leave.createLeaf(8,30,"large");
        leave.createLeaf(7,8,"large");
        leave.createLeaf(12,20,"medium");
        leave.createLeaf(10,10,"small");
        leave.createLeaf(5,25,"small");
        leave.createLeaf(18,8,"small");
        leave.createLeaf(20,22,"large");
        leave.createLeaf(3,15,"medium");
        leave.createLeaf(25,5,"large");
        leave.createLeaf(16,35,"medium");
        leave.createLeaf(22,28,"large");
        leave.createLeaf(11,40,"small");
        leave.createLeaf(18,20,"small");
        leave.createLeaf(5,10,"small");
        leave.createLeaf(10,15,"small");
        leave.createLeaf(3,4,"small");
        leave.createLeaf(19,1,"medium");
        leave.createLeaf(21,12,"medium");

        trunk.createLeftBranch(startPositionX-4, startPositionY-4, 4);
        trunk.createRightBranch(startPositionX-7,startPositionY-4,3);
        trunk.createRightBranch(startPositionX-3,startPositionY+trunkBaseWidth+5,4);
        trunk.createLeftBranch(startPositionX-6,startPositionY+8,5);

    }
}
