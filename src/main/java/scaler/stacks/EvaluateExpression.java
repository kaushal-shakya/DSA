package scaler.stacks;

import java.util.*;

public class EvaluateExpression {
    public static void main(String[] args) {
//        List<String> input = Arrays.asList(new String[]{"2", "1", "+", "3", "*"});
        List<String> input = Arrays.asList(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(evalRPN( input));
    }

    public static int evalRPN(List<String> input)
    {
        int result = 0;
        Stack<String> s1 = new Stack<>();
        for( int i = 0; i < input.size(); i++ )
        {   String curr = input.get(i);
            if( curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/") )
            {
                int e1 = Integer.parseInt(s1.pop());
                int e2 = Integer.parseInt(s1.pop());

                if ( curr.equals("+") ){
                    s1.push(String.valueOf(e1 + e2));
                } else if(curr.equals("-")){
                    s1.push(String.valueOf(e2-e1));
                } else if (curr.equals("*")) {
                    s1.push(String.valueOf(e1*e2));
                } else {
                    s1.push(String.valueOf(e2/e1));
                }
            } else {
                s1.push(curr);
            }
        }

        return Integer.parseInt(s1.peek());
    }

}
