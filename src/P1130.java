import java.util.*;

public class P1130 {
    public int mctFromLeafValues(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int result = 0;
        Stack<Integer> s = new Stack<>();
        for (int x : arr) {
            while (!s.empty() && s.peek() <= x) {
                int y = s.pop();
                if (s.empty() || s.peek() >= x) {
                    result += x * y;
                } else {
                    result += y * s.peek();
                }
            }
            s.push(x);
        }
        while (s.size() > 1) {
            int x = s.pop();
            result += x * s.peek();
        }
        return result;
    }
}
