package index.sort;

public class InsertSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] source = { 1, 7, 9, 4, 2, 6, 5, 3, 8 };

        for (int i = 1; i < source.length; i++) {
            if (source[i - 1] > source[i]) {
                int temp = source[i];
                for (int j = 0; j < i; j++) {
                    if (source[j] > temp) {
                        for (int t = i; t > j; t--) {
                            source[t] = source[t - 1];
                        }
                        source[j] = temp;
                        break;
                    }
                }
            }
            print(source);
        }
        long end = System.currentTimeMillis();
        System.out.println("Total Time : " + (end - start));
    }

    private static void print(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
