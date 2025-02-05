package org.example;

import javax.swing.*;
import java.awt.*;

public class Trunk extends JPanel {
    private final int trunkHeight, trunkWidth;

    public Trunk(int trunkWidth, int trunkHeight)
    {
        //setOpaque(false);
        setBackground(Color.gray);

        this.trunkHeight = trunkHeight;
        this.trunkWidth = trunkWidth;
        setPreferredSize(new Dimension(trunkWidth, trunkHeight));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        int xStart = getWidth() / 2 - trunkWidth / 2;
        int yStart = getHeight() - trunkHeight;

        g2d.setColor(new Color(102, 51, 0));

        drawTrunk(g2d, trunkWidth, trunkHeight, xStart, yStart);
        drawRoot(g2d,getWidth(),getHeight()/5,0,getWidth());
    }

    private void drawTrunk(Graphics g2d, int trunkWidth, int trunkHeight, int xStart, int yStart) {
        g2d.fillRect(xStart, yStart, trunkWidth, trunkHeight);
    }

    private  void drawRoot(Graphics g2d, int rootWidth, int rootHeight, int xStart, int yStart)
    {
        g2d.fillRect(xStart, yStart, trunkWidth, trunkHeight);
        g2d.setColor(Color.green);
    }
}
