package org.example;

public class Main {
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Tree tree = new Tree();
            tree.showTree();
        });
    }
}
