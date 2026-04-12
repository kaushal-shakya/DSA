package sc.stacks;

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();

        for(int asteroid : asteroids) {
            // "{1, -2} - Collision
            // {-2, 1} - No collision
            // {-1, -2} - No collision
            // {1, 2} - No collision
            while(!st.isEmpty() && st.peek() > 0 && asteroid < 0)
            {
                int sum = st.peek() + asteroid;
                if(sum < 0) {
                    st.pop();
                } else if(sum > 0) {
                    asteroid = 0;
                } else {
                    st.pop();
                    asteroid = 0;
                }
            }
            if(asteroid != 0)
                st.push(asteroid);
        }


        int[] result = new int[st.size()];
        int i = st.size()-1;
        while (!st.isEmpty()) {
            result[i] = st.pop();
            i--;
        }
        return result;


    }

    public static void main(String[] args) {
//        int[] asteroids = {3,5,-6,2,-1,4};
//        int[] asteroids = {10,2,-5};
//        int[] asteroids = {5,-5};
        int[] asteroids = {-2,-1,1,2};
        int[] result = asteroidCollision(asteroids);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
