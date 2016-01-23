package index.sort;

public class QuickSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] source = { 1, 7, 9, 4, 2, 6, 5, 3, 8 };

        
       
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
