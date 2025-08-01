package leetcode.bitmanipulation;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(2147483644));
    }

    public static int reverseBits(int n) {
        int ans = 0;
        int k = 0;
        for(int i = 31; i >= 0 ; i--)
        {
            if(( n & (1 << i) ) != 0 )
            {
                ans = (ans | (1 << k));
            }
            k++;
        }
        return ans;
    }
}
