package sc.arrays.binarybeyondsortedarrays;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        long start = 0;
        long end = x/2+1;
        long ans = -1;
        long mid = -1; // Why -1 ? because sqrt will always be between 0 and
        while (start <= end)
        {
            mid = start + (end-start)/2;
            if(mid * mid == x){
                ans = mid;
                break;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans != -1 ? (int)mid : start > end ? (int)end : (int)start;
    }

}
