package org.example;

import java.awt.*;
import javax.swing.*;

public class OverlLeaf extends Leaf {

    private final int xStartingPosition;
    private final int yStartingPosition;
    private final int width;
    private final int height;
    private final Color leafColor;

    public OverlLeaf(int xStartingPosition, int yStartingPosition, int width, int height, Color leafColor)
    {
        this.xStartingPosition = xStartingPosition;
        this.yStartingPosition = yStartingPosition;
        this.width = width;
        this.height = height;
        this.leafColor = leafColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLeaf(g);
    }

    @Override
    void drawLeaf(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        int angle = (int) (Math.random() * 90) - 45;
        g2d.rotate(Math.toRadians(angle), xStartingPosition + width / 2.0, yStartingPosition + height / 2.0);
        g2d.setColor(leafColor);
        g2d.fillOval(xStartingPosition, yStartingPosition, width, height);
        g2d.dispose();
    }
}
