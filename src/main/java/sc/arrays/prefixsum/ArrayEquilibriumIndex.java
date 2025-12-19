package sc.arrays.prefixsum;

public class ArrayEquilibriumIndex {

    public static void main(String[] args) {
//        ArrayList<Integer> input = new ArrayList<>();
//        input.add(-7);
//        input.add(1);
//        input.add(5);
//        input.add(2);
//        input.add(-4);
//        input.add(3);
//        input.add(0);
//
//        System.out.println(equilibrim(input));

        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

// Approach : TC O(N)
    public static int pivotIndex(int[] nums) {

        int[] prefixSumArray = prefixsum(nums);

        int presum = 0;
        int postsum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i != 0)
            {
                presum = prefixSumArray[i-1];
            }
            postsum = prefixSumArray[nums.length-1] - prefixSumArray[i];
            if(presum == postsum)
                return i;

        }
        return -1;
    }

    private static int[] prefixsum(int[] nums)
    {   int[] prefixSumArray = new int[nums.length] ;
        prefixSumArray[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            prefixSumArray[i] = prefixSumArray[i-1] + nums[i];
        }
        return prefixSumArray;
    }

// Approach : TC O(N^2)
//    public static int equilibrim(ArrayList<Integer> A) {
//
//        for(int i = 0; i < A.size(); i++)
//        {
//            int j = i-1;
//            int presum = 0;
//            while(j >= 0){
//                presum += A.get(j);
//                j--;
//            }
//            int k = i+1;
//            int postsum = 0;
//            while (k < A.size()){
//                postsum += A.get(k);
//                k++;
//            }
//
//            if(presum == postsum)
//                return i;
//        }
//        return  -1;
//    }
}
