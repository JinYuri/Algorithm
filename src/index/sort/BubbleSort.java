package index.sort;

public class BubbleSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] source = {1, 7, 9, 4, 2, 6, 5, 3, 8 };
        for(int j=1; j<source.length; j++){
            for(int i=1; i<source.length-(j-1); i++){
                if(source[i-1] > source [i]){
                    int temp = source[i-1];
                    source[i-1] = source [i];
                    source[i] = temp;
                }
                print(source);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Total Time : " + (end-start));
    }
    private static void print(int[] input){
        for(int i=0; i<input.length; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
