package leetcode.stacks;

import java.util.Stack;

//402. Remove K Digits
public class RemoveKDigits {
    public static void main(String[] args) {
//        String s = "1432219";
//        String s = "10200";
//        String s = "112";
        String s = "10";
        System.out.println(removeKDigits1(s, 1));
    }

    //String manipulation
    public static String removeKdigits(String num, int k) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length()-k; i++)
        {
            String s1 = i != 0 ? num.substring(0,i) : "";
            String s2 = num.substring(i+k);

            int temp = Integer.parseInt(s1+s2);
            min = Math.min(min, temp);
        }
        return k == num.length() ? "0" : String.valueOf(min);
    }

    //Stack implementation
    public static String removeKDigits1(String num, int k)
    {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i < num.length())
        {
            char curr =  num.charAt(i);
            while (k > 0 && !st.isEmpty() && curr < num.charAt(st.peek()))
            {
                st.pop();
                k--;
            }
            st.push(i);
            i++;
        }

        while(k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        StringBuilder preResult = new StringBuilder("");
        while (!st.isEmpty()){
            preResult.append(num.charAt(st.pop()));
        }

        while (!preResult.isEmpty() && preResult.substring(preResult.length()-1).equals("0")){
            preResult.deleteCharAt(preResult.length()-1);
        }
        return preResult.isEmpty() ? "0" : preResult.reverse().toString();
    }

}
