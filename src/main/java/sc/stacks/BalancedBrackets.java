package sc.stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        System.out.println(solve1(input));
    }

    // Examples
    // 1. ()[] = valid
    // 2. [()] = valid
    // 3. {()] = invalid
    // 4. [()]} = invalid
    // 5. [()]}{ = invalid ===>
    // 6. (]) = invalid ===>
    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < A.length())
        {
            char curr = A.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[')
            {
                stack.push(curr);
            }
            else
            {   // This is to handle [()]}. As after traversing '[', '(', ')' and ']', will , stack will be empty.
                //we have '}' remains to be traverse, no corresponding opening bracket is available for '}'.
                //This will prevent accessing element from empty stack
                if(stack.isEmpty())
                    break;
                char top =  stack.peek();
                if(top == '(' && curr == ')' ||
                    top == '{' && curr == '}' ||
                    top == '[' && curr == ']')
                {
                        stack.pop();
                }else {
                    break; // (]) - handle
                }
            }
            i++;
        }

        return stack.isEmpty() && i == A.length() ? 1 : 0;
    }


    //class solution
    public static int solve1(String A)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < A.length(); i++)
        {
            char curr = A.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[')
            {
                stack.push(curr);
            }else {
                if(stack.isEmpty())
                    return 0;
                char top = stack.peek();
                if(top == '(' && curr == ')' ||
                        top == '{' && curr == '}' ||
                        top == '[' && curr == ']')
                {
                    stack.pop();
                }else {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

}
