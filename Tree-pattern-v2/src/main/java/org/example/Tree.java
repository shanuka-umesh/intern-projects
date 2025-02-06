package org.example;

import javax.swing.*;
import java.awt.*;

public class Tree extends JFrame {

    private int leafCount = 150;
    private Color[] leafColors = {
            new Color(61, 238, 61),
            new Color(50, 205, 50),
            new Color(204, 66, 23),
            new Color(108, 196, 57),
            new Color(245, 215, 75)
    };



    public Tree() {
        super("Tree pattern version 2");

        setLayout(null);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addTrunk();
        addLeaves();
    }

    private void addTrunk()
    {
        Trunk trunk = new Trunk(80, 300);
        trunk.setBounds(250, 450, 200, 200);
        add(trunk);
    }

    private void addLeaves()
    {
        addOverlLeaves();
        addRoundLeaves();
    }

    private void addOverlLeaves()
    {
        for (int i = 0; i < leafCount / 3; i++) {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight() / 2);
            int width = (int) (Math.random() * 20) + 5;
            int height = width * 2;
            Color leafColor = leafColors[(int) (Math.random() * leafColors.length)];

            OverlLeaf leaf = new OverlLeaf(x, y, width, height, leafColor);
            leaf.setBounds(0, 0, 700, 700);
            add(leaf);
        }
    }




    private void addRoundLeaves()
    {
        for (int i = 0; i < leafCount / 3; i++) {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight() / 2);
            int diameter = (int) (Math.random() * 20) + 5;
            Color leafColor = leafColors[(int) (Math.random() * leafColors.length)];

            RoundLeaf leaf = new RoundLeaf(x, y, diameter, leafColor);
            leaf.setBounds(0, 0, 700, 700);
            add(leaf);
        }
    }

    public void showTree() {
        setVisible(true);
    }

}
