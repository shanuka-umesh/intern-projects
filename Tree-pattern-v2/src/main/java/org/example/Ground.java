package org.example;

import javax.swing.*;
import java.awt.*;

public class Ground extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        g2d.setColor(new Color(139, 69, 19));


        Polygon groundShape = new Polygon();
        groundShape.addPoint(0, 40);
        groundShape.addPoint(100, 30);
        groundShape.addPoint(200, 50);
        groundShape.addPoint(300, 25);
        groundShape.addPoint(400, 50);
        groundShape.addPoint(500, 30);
        groundShape.addPoint(600, 40);
        groundShape.addPoint(700, 50);
        groundShape.addPoint(700, 100);
        groundShape.addPoint(0, 100);


        g2d.fillPolygon(groundShape);
    }
}
