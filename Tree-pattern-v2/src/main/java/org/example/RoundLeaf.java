package org.example;

import java.awt.*;
import javax.swing.*;

public class RoundLeaf extends Leaf {

    private final int xStartingPosition;
    private final int yStartingPosition;
    private final int diameter;
    private final Color leafColor;

    public RoundLeaf(int xStartingPosition, int yStartingPosition, int diameter, Color leafColor) {
        this.xStartingPosition = xStartingPosition;
        this.yStartingPosition = yStartingPosition;
        this.diameter = diameter;
        this.leafColor = leafColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLeaf(g);
    }

    @Override
    void drawLeaf(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int angle = (int) (Math.random() * 90) - 45;
        g2d.rotate(Math.toRadians(angle), xStartingPosition + diameter / 2.0, yStartingPosition + diameter / 2.0);
        g2d.setColor(leafColor);

        // Draw a perfect circle
        g2d.fillOval(xStartingPosition, yStartingPosition, diameter, diameter);

        g2d.dispose();
    }
}
