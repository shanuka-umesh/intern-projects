package org.example;

import javax.swing.*;

public class Tree extends JFrame {

    private Leaf canvas;
    private int leafCount=100;

    public Tree() {
        super("Tree pattern version 2");
        canvas = new Leaf(leafCount);

        add(canvas);

        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void showTree() {
        setVisible(true);
    }
}
