package sc.sorting;

public class CountSort {
    public static void main(String[] args) {
        int[] A = {6,3,4,2,7,2,1};
        int[] result = solve(A);

        for (int a : result){
            System.out.print(a + " ");
        }
    }

    public static int getMax(int[] A)
    {
        int max = A[0];
        for(int i = 1; i < A.length; i++)
        {
            if(A[i] > max)
            {
                max = A[i];
            }
        }
        return max;
    }

    public static int getMin(int[] A)
    {
        int min = A[0];
        for(int i = 1; i < A.length; i++)
        {
            if(A[i] < min)
            {
                min = A[i];
            }
        }
        return min;
    }

    public static int[] solve(int[] A) {

        int max = getMax(A);
        int min = getMin(A);
        int totalSize = max-min+1;

        int[] freq = new int[totalSize];


        for(int i = 0; i < A.length; i++)
        {
            freq[A[i]-min]++;
        }
        int[] temp = new int[A.length];
        int idx = 0;
        for(int i = 0; i < totalSize; i++){
            if(freq[i] == 0)
                continue;

            int f = freq[i];
            int j = 0;
            while(j < f){
                temp[idx] = i+min;
                j++;
                idx++;
            }
        }

        return temp;
    }
}
