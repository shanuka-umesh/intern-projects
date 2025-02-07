package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tree extends JFrame {

    private int roundleafCount = 5000;
    private int overleafCount = 500;

    private Color branchColor = new Color(100, 50, 20); // Dark brown

    Random random = new Random();

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

        addBranches();
        addLeaves();
        addTrunk();

    }

    private void addTrunk()
    {
        Trunk trunk = new Trunk(100, 800);
        trunk.setBounds(300, 350, 80, 400);
        add(trunk);
    }

    private void addLeaves()
    {
        addOverlLeaves();
        addRoundLeaves();
    }

    private void addOverlLeaves()
    {
        int centerX = 350;
        int centerY = 75;
        int maxRadius = 400;


        for (int i = 0; i < overleafCount; i++)
        {
            double angle = 2 * Math.PI * random.nextDouble();
            double radius = maxRadius * Math.sqrt(random.nextDouble());

            int xPosition = (int) (centerX + radius * Math.cos(angle));
            int yPosition = (int) (centerY + radius * Math.sin(angle));

            int width = random.nextInt(20) + 20;
            int height = width * 2;

            Color leafColor = leafColors[random.nextInt(leafColors.length)];

            OverlLeaf leaf = new OverlLeaf(xPosition, yPosition, width, height, leafColor);
            leaf.setBounds(0, 0, 700, 700);
            add(leaf);
        }
    }


    private void addRoundLeaves()
    {

        int centerX = 350;
        int centerY = 75;
        int maxRadius = 400;


        for (int i = 0; i < roundleafCount / 3; i++)
        {
            double angle = 2 * Math.PI * random.nextDouble();
            double radius = maxRadius * Math.sqrt(random.nextDouble());

            int xPosition = (int) (centerX + radius * Math.cos(angle));
            int yPosition = (int) (centerY + radius * Math.sin(angle));

            int width = random.nextInt(20) + 20;


            int diameter = (int) (Math.random() * 20) + 15;

            Color leafColor = leafColors[(int) (Math.random() * leafColors.length)];

            RoundLeaf leaf = new RoundLeaf(xPosition, yPosition, diameter, leafColor);
            leaf.setBounds(0, 0, 700, 700);
            add(leaf);
        }
    }

    private void addBranches()
    {
        Branch branch = new Branch(50, 50, 50,25,Color.BLUE);
        branch.setBounds(100, 100, 100, 100);
        add(branch);
    }




    public void showTree() {
        setVisible(true);
    }

}
