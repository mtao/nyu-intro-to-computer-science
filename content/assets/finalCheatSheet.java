// Some useful java functions

public class Collection<T> {
    // sorts the elements of arr 
    public static void sort(List<T>);
}



class Scanner {
    Scanner(InputStream source);
    String nextLine();
    double nextDouble();
    float nextFloat();
    int nextInt();
    void close();
}

int[][] x = new int[4][];
x[3] = new int[]{1,2,3};

class ArrayList<T> {// same for List
    T at(int index);
    void add(T newValue);
    void remove(int index);
    int length();
}

class String {
    char charAt(int index);
    int length();
    char[] toCharArray();
    String[] split();
}


class Double {
    static double pasreDouble(String str);
    static String toString(double);
}

