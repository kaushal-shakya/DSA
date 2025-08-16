package leetcode.stacks;

import java.util.HashMap;
import java.util.Stack;

//Leetcode 227
public class BasicCalculator2 {
    public static void main(String[] args) {
        String s1 = "3+2*2";
        String s2 = " 3+5 / 2 ";
        String s3 = "2+3*2-1";
        String s4 = "42";
        String s5 = "1-1+1";
        String s6 = "1+2*5/3+6/4*2";
        System.out.println(calculate(s6));
    }

    //Using stack, all test cases passed, but code is too cubersome.
    //It is very much possible, even i could not understand it during revision
    public static int calculate(String s) {
        HashMap<Character, Integer> operatorPrecedence = new HashMap<>();
        operatorPrecedence.put('-',2);
        operatorPrecedence.put('+',2);
        operatorPrecedence.put('*',3);
        operatorPrecedence.put('/',3);

        Stack<Character> operators = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        int result = 0;

        for(int i = 0; i < s.length(); )
        {
            char curr = s.charAt(i);
            if(curr != '+' && curr != '-' && curr != '*' && curr != '/' && curr != ' ') { // to handle operands
                int currNum = 0;
                while (i < s.length() && curr != '+' && curr != '-' && curr != '*' && curr != '/' && curr != ' '){
                    curr = s.charAt(i);
                    if(curr == '+' || curr == '-' || curr == '*' || curr == '/' || curr == ' ') {
                        i--;
                        break;
                    }
                    currNum = currNum * 10 + Integer.parseInt(String.valueOf(curr));
                    i++;
                }
                operand.push(Integer.parseInt(String.valueOf(currNum)));
            } else if (curr == ' ') { // as given, input could have spaces. we need to skip them.

            } else { // to handle operator
                if(!operators.isEmpty()){
                    char top = operators.peek();
                    int currPriority = operatorPrecedence.getOrDefault(curr,0);
                    int topPriority = operatorPrecedence.getOrDefault(top, 0);
                    while (!operand.isEmpty() && !operators.isEmpty() && currPriority <= topPriority)
                    {
                        int op2 = operand.pop();
                        int op1 = operand.pop();
                        int intermediateResult = Integer.MIN_VALUE;
                        if (top == '+')
                            intermediateResult = op1 + op2;
                        else if (top == '-')
                            intermediateResult = op1 - op2;
                        else if (top == '*')
                            intermediateResult = op1 * op2;
                        else if (top == '/')
                            intermediateResult = op1 / op2;
                        if(intermediateResult > Integer.MIN_VALUE)
                            operand.push(intermediateResult);
                        operators.pop();
                        if(!operators.isEmpty()){
                            top = operators.peek();
                            topPriority = operatorPrecedence.getOrDefault(top,0);
                        }
                    }
                    operators.push(curr);
                }else {
                    operators.push(curr);
                }
            }
            i++;
        }
        while (!operators.isEmpty() && !operand.isEmpty()){
            int op2 = operand.pop();
            int op1 = operand.pop();
            char top = operators.pop();
            if (top == '+')
                result = op1 + op2;
            else if (top == '-')
                result = op1 - op2;
            else if (top == '*')
                result = op1 * op2;
            else if (top == '/')
                result = op1 / op2;
            operand.push(result);
        }
        return operand.pop();
    }

    //TODO: using stacks only but after watching solution
//    public static int calculate1(String s)
//    {
//
//    }

}
