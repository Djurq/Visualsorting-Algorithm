package GUI;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public Screen(){
        super("sorteer algoritme");
        DrawPanel panel = new DrawPanel();
        add(panel);
        pack();
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
