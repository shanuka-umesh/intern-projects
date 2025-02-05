package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Leaf extends JPanel {

    private final Random random = new Random();
    private final int leafCount;

    public Leaf(int leafCount) {
        this.leafCount = leafCount;
        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.lightGray);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawLeaves(g);
    }

    private void drawLeafShape(Graphics2D g2d, int xStartingPosition, int yStartingPosition, int width, int height, Color leafColor)
    {
        Graphics2D g2dCopy = (Graphics2D) g2d.create();


        int angle = random.nextInt(90) - 45;
        g2dCopy.rotate(Math.toRadians(angle), xStartingPosition + width / 2.0, yStartingPosition + height / 2.0);


        g2dCopy.setColor(leafColor);
        g2dCopy.fillOval(xStartingPosition, yStartingPosition, width, height);

        g2dCopy.dispose();
    }

    private void drawLeaves(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;


        Color[] leafColors = {
                new Color(61, 238, 61),
                new Color(50, 205, 50),
                new Color(204, 66, 23),
                new Color(108, 196, 57)

        };

        for (int i = 0; i < leafCount; i++)
        {
            int xStartingPosition = random.nextInt(getWidth());
            int yStartingPosition = random.nextInt(getHeight()/2);
            int width = random.nextInt(20) + 10;
            int height = width * 2;


            Color leafColor = leafColors[random.nextInt(leafColors.length)];

            drawLeafShape(g2d, xStartingPosition, yStartingPosition, width, height, leafColor);
        }
    }
}
