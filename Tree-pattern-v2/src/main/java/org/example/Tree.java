package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tree extends JFrame {

    private int roundleafCount = 2000;
    private int overleafCount = 500;
    private int branchCount = 50;

    private Color branchColor = new Color(100, 50, 20); // Dark brown

    Random random = new Random();

    private Color[] leafColors = {
            new Color(61, 238, 61),
            new Color(50, 205, 50),
            new Color(204, 66, 23),
            new Color(108, 196, 57),
            new Color(245, 215, 75),
            new Color(24, 52, 4),
            new Color(53, 105, 15)
    };

    public Tree() {
        super("Tree pattern version 2");

        setLayout(null);
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        addOverlLeaves();
        addBranches();
        addRoundLeaves();
        addGround();
        addTrunk();

       // animateLeaves();
    }

    private void addTrunk() {
        Trunk trunk = new Trunk(80, 380);
        trunk.setBounds(300, 350, 80, 380);
        add(trunk);
    }

    private void addOverlLeaves() {
        int centerX = 330;
        int centerY = 225;
        int maxRadius = 250;

        for (int i = 0; i < overleafCount; i++) {
            double angle = 2 * Math.PI * random.nextDouble();
            double radius = maxRadius * Math.sqrt(random.nextDouble());

            int xPosition = (int) (centerX + radius * Math.cos(angle));
            int yPosition = (int) (centerY + radius * Math.sin(angle));

            int width = random.nextInt(20) + 15;
            int height = width * 2;

            Color leafColor = leafColors[random.nextInt(leafColors.length)];

            OverlLeaf leaf = new OverlLeaf(xPosition, yPosition, width, height, leafColor);
            leaf.setBounds(0, 0, 700, 700);
            add(leaf);
        }
    }

    private void addRoundLeaves() {
        int centerX = 330;
        int centerY = 225;
        int maxRadius = 300;

        for (int i = 0; i < roundleafCount / 3; i++) {
            double angle = 2 * Math.PI * random.nextDouble();
            double radius = maxRadius * Math.sqrt(random.nextDouble());

            int xPosition = (int) (centerX + radius * Math.cos(angle));
            int yPosition = (int) (centerY + radius * Math.sin(angle));

            int diameter = (int) (Math.random() * 20) + 15;

            Color leafColor = leafColors[(int) (Math.random() * leafColors.length)];

            RoundLeaf leaf = new RoundLeaf(xPosition, yPosition, diameter, leafColor);
            leaf.setBounds(0, 0, 700, 700);
            add(leaf);
        }
    }

    private void addBranches() {
        double[] angles = {10, -10, 50, -50, 85, -82, 30, 275};
        int centerX = 330;
        int centerY = 225;
        int maxRadius = 250;

        for (int i = 0; i < branchCount; i++) {
            double angleRad = 2 * Math.PI * random.nextDouble();
            double radius = maxRadius * Math.sqrt(random.nextDouble());

            int startX = (int) (centerX + radius * Math.cos(angleRad));
            int startY = (int) (centerY + radius * Math.sin(angleRad));

            int width = random.nextInt(40) + 75;
            int height = random.nextInt(10) + 2;
            double angle = angles[random.nextInt(angles.length)];

            Branch branch = new Branch(startX, startY, width, height, branchColor, angle);
            branch.setBounds(0, 0, 700, 700);
            add(branch);
        }
    }

    public void addGround() {
        Ground ground = new Ground();
        ground.setBounds(0, 675, 700, 75);
        add(ground);
    }

    public void showTree() {
        setVisible(true);
    }

    private void animateLeaves() {
        Timer timer = new Timer(600, e ->
        {
            for (Component comp : getContentPane().getComponents())
            {
                if (comp instanceof OverlLeaf || comp instanceof RoundLeaf)
                {
                    int dx = random.nextInt(3) - 1;
                    int dy = random.nextInt(3) - 1;
                    comp.setLocation(comp.getX() + dx, comp.getY() + dy);
                }
            }
            repaint();
        });
        timer.start();
    }
}
