package sc.arrays;

public class RainTripping {

    public static void main(String[] args) {
        int[] input = {5, 4, 1, 4, 3, 2, 7};
        System.out.println(trap(input));
    }

    public static int trap(final int[] A) {
        int n = A.length;
        int ans = 0;
        int lmax[] = new int[n];
        lmax[0] = 0 ; //left building can't hold water
        //lmax keeps max height of building to its left
        for(int i = 1; i < n ; i++)
        {
            lmax[i] = Math.max(lmax[i-1], A[i-1]);
        }

        int rmax[] = new int[n];
        rmax[n-1] = 0 ; //right building can't hold water
        for(int i = n-2; i >= 0 ; i--)
        {
            rmax[i] = Math.max(rmax[i+1], A[i+1]);
        }

        //first and last building can't hold water
        for(int i = 1; i <= n-2; i++){
            int water = Math.min(lmax[i], rmax[i])-A[i];
            if(water > 0)
                ans += water;
        }
        return ans;
    }
}
