package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class DrawPanel extends JPanel {

    ArrayList<Rectangle> list;

    int currentIndex;
    int dimensionHeight = 700;
    int dimenstionWidth = 400;

    private final JButton startButton;
    private Timer timer = null;

    public DrawPanel() {
        list = createList();
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentIndex == 0) {
                    ((Timer) e.getSource()).stop();
                    startButton.setEnabled(false);
                    System.out.println("hoi");
                } else {
                    sortItem();
                }
                repaint();
            }
        });
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        add(startButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            Rectangle rectangle = list.get(i);
            int horizontal = i * (500 / list.size());
            int vertical = dimensionHeight - rectangle.height;

            g.fillRect(horizontal, vertical, rectangle.width, rectangle.height);
            System.out.print(" " + rectangle.height);
        }
        System.out.println();
    }

    public ArrayList<Rectangle> createList() {
        Rectangle rectanglen = new Rectangle(1, 1, 1);
        ArrayList<Rectangle> rectangles = rectanglen.createArrayList(30, 100, 1, 10, 30);
        this.currentIndex = rectangles.size() - 1;
        return rectangles;
    }

    public void sortItem() {
        Rectangle currentMax = this.list.get(0);
        int currentMaxIndex = 0;

        for (int j = 1; j <= currentIndex; j++) {
            if (currentMax.height < this.list.get(j).height) {
                currentMax = this.list.get(j);
                currentMaxIndex = j;
            }
        }

        if (currentMaxIndex != currentIndex) {
            this.list.set(currentMaxIndex, this.list.get(currentIndex));
            this.list.set(currentIndex, currentMax);
        }

        currentIndex--;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(dimenstionWidth, dimensionHeight);
    }
}
