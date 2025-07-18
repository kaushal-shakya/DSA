package scaler.arrays.subarrays;

public class MaxSumSubArrayOfLength {

    public static void main(String[] args) {
        int[] A = {992934,988985,498378,725284,891658,655875,938296,148305,899021,61215,670829,113522,710520,147656,511531,193667,779342,94619,828742,100709,779266,486630,542214,15611,608105,293647,874693,704077,524990,866932,923308,941048,325361,190677,563632,348975,243483,191923,882378,66169,297287,343915,830191,471801,83335,312521,814700,255031,518635,156335,953420,296924,220828,401154,155694,382458,129566,285027,820133,39505,344798,184054,246717,979956,708174,372746,955494,923569,568400,649092,924629};
        int B = 12;
        System.out.println(solve(A, B));
    }

    public static int maxSumArrayKLength(int[] A, int k)
    {
        int result = 0;
        return  result;
    }





//  Approach 1 :   Calculating maximum subarrray using prefix sum with length k
    public static long solve(int[] A, int B) {
        int[] prefixsum = getPrefixSum(A, A.length);
        long result = 0;
        int s = 0;
        int e = B-1;

        while(e < A.length)
        {   long sum = 0;
            if(s == 0)
            {
                sum = prefixsum[e];
            }else{
                sum = prefixsum[e] - prefixsum[s-1];
            }

            result = Math.max(sum, result);
            s++;
            e++;
        }
        return result;
    }

// Method to find the prefixm
    public static int[] getPrefixSum(int[] C, int A)
    {
        int[] prefixsum = new int[A];
        prefixsum[0] = C[0];
        for(int i = 1; i < A; i++)
        {
            prefixsum[i] = prefixsum[i-1] + C[i];
        }
        return prefixsum;
    }
}
