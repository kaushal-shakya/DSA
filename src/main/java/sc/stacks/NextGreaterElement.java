package sc.stacks;

import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] A) {
        int n = A.length;
        int result[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = A.length-1; i >= 0; i--) {

            while(!s.isEmpty() && A[i] >= A[s.peek()])
                s.pop();

            if(s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = A[s.peek()];
            }
            s.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,3,4,2};

        int[] result = nextGreaterElement(A);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
