import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean alive = true;

            while (alive && !stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();

                if (Math.abs(top) < Math.abs(ast)) {
                    stack.pop();
                } 
                else if (Math.abs(top) == Math.abs(ast)) {
                    stack.pop(); 
                    alive = false;
                } 
                else {
                    alive = false;
                }
            }

            if (alive) stack.push(ast);
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
