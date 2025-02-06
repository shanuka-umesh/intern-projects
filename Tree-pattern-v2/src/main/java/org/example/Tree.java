package org.example;

import javax.swing.*;

public class Tree extends JFrame {


    private int leafCount=150;
    private Trunk trunk = new Trunk(80,300);
    private  OverlLeaf overlLeaf = new OverlLeaf(leafCount);


    public Tree() {
        super("Tree pattern version 2");

        overlLeaf.setBounds(0, 0, 700, 700);
        trunk.setBounds(0, 0, 200, 200);

        add(overlLeaf);
        add(trunk);

        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void showTree() {
        setVisible(true);

    }
}
