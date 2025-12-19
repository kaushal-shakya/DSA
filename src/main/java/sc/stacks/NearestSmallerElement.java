package sc.stacks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>();
        int num = scan.nextInt();
        do {
            input.add(num);
            num = scan.nextInt();
        } while (num != -1);

        System.out.println(input);
        System.out.println(prevSmaller(input));
    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList<>();
        //Stack
        Stack<Integer> st = new Stack<>();

        for(int i=0; i < A.size(); i++)
        {   int curr = A.get(i);
            //keep popping element from stack until you are getting bigger element than current ele. Why ?
            //let take a case [4,5,6,2, 10,8]
            //index[2] = 6, nearest smaller element = 5
            //index[3] = 2, nearest smaller element = -1
            //index[4] = 10, nearest smaller element = 2. Now, we have found a value(2), smaller than previous values (4,5,6),
            //which will be smaller for any further element. So we don't need to keep them in stack. So we popped.
            while ( !st.isEmpty() && curr <= A.get( st.peek() ) )
            {
                st.pop();
            }
            if ( st.isEmpty() ) { //It means we don't have any nearest element
                result.add(-1);
            } else {
                result.add(A.get(st.peek()));
            }
            st.push(i);
        }

        return result;
    }
}
