public class Utility {

    public static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void printMatrix(int[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

}
