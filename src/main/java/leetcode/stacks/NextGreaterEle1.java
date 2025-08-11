package leetcode.stacks;

import java.util.*;

public class NextGreaterEle1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] result = nextGreaterElement2(nums1, nums2);

        for(int val : result)
        {
            System.out.print(val+" ");
        }
    }

    //Brute Force
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int i = 0;

        for(int val1 : nums1)
        {   int length2 = 0;
            boolean isEqualFound = false;
            for(int val2 : nums2)
            {
                if(val1 == val2)
                    isEqualFound = true;

                if(isEqualFound && val2 > val1)
                {
                    ans[i] = val2;
                    i++;
                    break;
                }

                length2++;
            }
            if(length2 == nums2.length)
            {
                ans[i] = -1;
                i++;
            }
        }
        return ans;
    }

    //Implement using monotonic decreasing stack
    //As a practice, we store indices in monotonic stack

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2)
    {
        int[] temp = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length-1; i >= 0; i--)
        {
            while(!st.isEmpty() && nums2[i] >= nums2[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                temp[i] = -1;
            }else {
                temp[i] = nums2[st.peek()];
            }
            st.push(i);
        }
        int[] result = new int[nums1.length];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< temp.length; i++){
            map.put(nums2[i], temp[i]);
        }

        for( int i=0; i<nums1.length; i++ )
        {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
