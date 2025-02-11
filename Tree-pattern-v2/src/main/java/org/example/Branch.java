package org.example;

import javax.swing.*;
import java.awt.*;

public class Branch extends JComponent {
    private int startX, startY, width, height;
    private Color color;
    private double angle; // Rotation angle in degrees

    public Branch(int startX, int startY, int width, int height, Color color, double angle) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.color = color;
        this.angle = Math.toRadians(angle); // Convert degrees to radians
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);

        // Apply rotation transformation
        g2d.translate(startX, startY);
        g2d.rotate(angle);

        // Draw the branch as a rectangle (it will be rotated)
        g2d.fillRect(0, 0, width, height);

        // Reset transformation to avoid affecting other components
        g2d.rotate(-angle);
        g2d.translate(-startX, -startY);
    }
}
