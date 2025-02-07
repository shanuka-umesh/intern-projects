package org.example;

import javax.swing.*;
import java.awt.*;

public class Branch extends JComponent {

    private final int startX;
    private final int startY;
    private final int length;
    private final int width;
    private final Color branchColor;

    public Branch(int startX, int startY, int length, int width, Color branchColor) {
        this.startX = startX;
        this.startY = startY;
        this.length = length;
        this.width= width;
        this.branchColor = branchColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBranch(g);
    }

    private void drawBranch(Graphics g)
    {
        g.setColor(Color.BLUE);

        // Draw a custom polygon (example: a star)
        int[] xPoints = {50, 90, 120, 95, 100, 50, 0, 5, -20, 10};
        int[] yPoints = {0, 40, 50, 60, 100, 80, 100, 60, 50, 40};
        int numPoints = xPoints.length;

        g.fillPolygon(xPoints, yPoints, numPoints);
        g.dispose();
    }
}
