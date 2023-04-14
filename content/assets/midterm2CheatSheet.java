// Some useful java functions

int[][] x = new int[4][];
x[3] = new int[]{1,2,3};

class ArrayList<T> {// same for List
    T at(int index);
    void add(T newValue);
    void remove(int index);
    int length();
}

public class String {
    char charAt(int index);
    int length();
    char[] toCharArray();
}


class PApplet {
    int mouseX, mouseY;
    int key;

    void stroke(int r, int g, int b);
    void noStroke();
    void fill(int r, int g, int b);
    void noFill();

    void ellipse(int x, int y, int w, int h);
    // note this draws the top left corner, so assume we have:
    void ellipseCentered(int x, int y, int w, int h);
    void line(int x0, int y0, int x1, int y1);
}
