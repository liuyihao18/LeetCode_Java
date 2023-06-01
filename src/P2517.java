import java.util.Arrays;

public class P2517 {
    private boolean check(int[] price, int k, int m) {
        int prev = Integer.MIN_VALUE >> 1;
        int cnt = 0;
        for (int p : price) {
            if ((p - prev) >= m) {
                cnt++;
                prev = p;
            }
        }
        return cnt >= k;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        System.out.println(Arrays.toString(price));
        int l = 0, r = price[price.length - 1] - price[0] + 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (check(price, k, m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }
}
