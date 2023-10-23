import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ProgrammingSolutions {
    public static double clamp(double x, double min, double max) {
        if (x < min) {
            return min;
        } else if (x > max) {
            return max;
        } else {
            return x;
        }
    }

    public static void syncophant() {
        for (int count = 0;; ++count) {
            System.out.println(count + ") yes");
        }
    }

    public static byte[] getRGB(String name) {
        switch (name) {
            case "red":
                return new byte[] {(byte) 255, 0, 0};
            case "green":
                return new byte[] {0, (byte) 255, 0};
            case "blue":
                return new byte[] {0, 0, (byte) 255};
            case "white":
                return new byte[] {(byte) 255, (byte) 255, (byte) 255};
            case "black":
            default:
                return new byte[] {0, 0, 0};
        }
    }

    public static String[] acidicSamples(String[] sampleNames, double[] pHValues) {
        ArrayList<String> namesList = new ArrayList<>();

        for (int j = 0; j < pHValues.length; ++j) {
            if (pHValues[j] < 7) {
                namesList.add(sampleNames[j]);
            }
        }
        String[] names = new String[0];
        names = namesList.toArray(names);
        return names;
    }

    public static boolean isSorted(int[] data) {
        for (int j = 0; j < data.length - 1; ++j) {
            if (data[j] > data[j + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void shuffle(int[] data) {
        Random random = new Random();

        for (int j = 0; j < data.length; ++j) {
            int randIndex = random.nextInt(0, data.length);

            int tmp = data[j];
            data[j] = data[randIndex];
            data[randIndex] = tmp;
        }
    }

    public static int[] bogosort(int[] data) {
        int[] sorted = Arrays.copyOf(data, data.length);
        while (!isSorted(sorted)) {
            shuffle(sorted);
        }
        return sorted;
    }

    public static double naive_polynomial(double[] C, double x) {
        int order = C.length;
        double value = 0;
        for (int j = 0; j < order; ++j) {
            double v = C[j];
            for (int k = 0; k < (order - 1 - j); ++k) {
                v = x * v;
            }
            value += v;
        }
        return value;
    }
    public static double horner_polynomial(double[] C, double x) {
        double value = C[0];
        for (int j = 1; j < C.length; ++j) {
            value = value * x + C[j];
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("Clamp\n=====");
        System.out.println(clamp(0.5, 0.0, 1.0));
        System.out.println(clamp(-2.0, 0.0, 1.0));
        System.out.println(clamp(20, 0.0, 1.0));

        System.out.println("RGB\n=====");
        System.out.println(Arrays.toString(getRGB("red")));
        System.out.println(Arrays.toString(getRGB("green")));
        System.out.println(Arrays.toString(getRGB("blue")));
        System.out.println(Arrays.toString(getRGB("black")));
        System.out.println(Arrays.toString(getRGB("white")));

        System.out.println("AcidicSamples\n=====");
        String[] names = {"Test1", "Test2", "Samples4", "Test4"};
        double[] pHValues = {1.1, 7.2, 5.0, 10.0};

        System.out.println(Arrays.toString(acidicSamples(names, pHValues)));

        System.out.println("isSorted\n=====");
        {
            int[] data = {0, 3, -2};
            System.out.println(isSorted(data));
        }
        {
            int[] data2 = {0, 3, 6};
            System.out.println(isSorted(data2));
        }
        System.out.println("bogosort\n=====");
        int[] data = {0, 3, -2};
        int[] sorted = bogosort(data);
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(sorted));
        System.out.println("naive_polynomial\n=====");
        double[] C = {4., 3., 2., 1.};
        System.out.println(naive_polynomial(C, 0.5));
        double[] C2 = {5.0, 0.0};
        System.out.println(naive_polynomial(C2, 0.5));

        System.out.println("horner_polynomial\n=====");
        System.out.println(horner_polynomial(C, 0.5));
        System.out.println(horner_polynomial(C2, 0.5));
    }
}
