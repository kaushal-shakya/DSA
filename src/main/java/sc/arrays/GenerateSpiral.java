package sc.arrays;


public class GenerateSpiral {
    public static void main(String[] args) {
        int a = 5;
        int[][] ans = generateSpiralMatrix(a);
        //matrix print
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans.length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] generateSpiralMatrix(int a)
    {
        int[][] spiral = new int[a][a];
        int loop = a-1; //need to run loo n-2 times
        int num = 1;
        int r = 0, c = 0;
        while(loop > 0) {
            int i = r, j = c;
//          k < loop, we need to not cover first, last row and column
            for(int k = 0; k < loop; k++){
                spiral[i][j++] = num;
                num++;
            }

            for(int k = 0; k < loop; k++){
                spiral[i++][j] = num;
                num++;
            }

            for(int k = 0; k < loop; k++){
                spiral[i][j--] = num;
                num++;
            }

            for(int k = 0; k < loop; k++){
                spiral[i--][j] = num;
                num++;
            }
            r++;
            c++;
            loop -= 2; // in every loop, we are leaving adjacent boundary,
            // one column from both left and right will be removed to iterate
        }
        //in case of odd n, middle element will remain 0. So to fill middle diagonal element
        if(loop == 0)
            spiral[r][c] = num;

        return spiral;
    }
}
