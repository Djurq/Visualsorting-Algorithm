package GUI;

import java.util.ArrayList;
import java.util.Random;

public class Rectangle {
    int width;
    int height;
    int position;

    public Rectangle(int x, int y, int pos) {
        this.width = x;
        this.height = y;
        this.position = pos;
    }

    public ArrayList<Rectangle> createArrayList(int maxItems, int max, int min, int width, int pos) {
        ArrayList<Rectangle> arrayList = new ArrayList<>();
        ArrayList<Integer> alreadyCheckNumbers = new ArrayList<>();
        int position = pos;
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
///
        int i = 0;
        while (i < maxItems) {
            Random random = new Random();
            int randomNumber = random.nextInt((max - min) + 1) + min;
            if (!alreadyCheckNumbers.contains(randomNumber*2)) {
                alreadyCheckNumbers.add(randomNumber*2);

                int height = randomNumber * 2;

                arrayList.add(new Rectangle(width, height, position));
                position++;
                i++;
            }
        }
        return arrayList;
    }
}
