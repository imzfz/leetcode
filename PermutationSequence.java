import java.util.*;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] s = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean hasRemove[] = new boolean[9];
        int times = 1, num, complement = k;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            if (i == n) {
                for (int p = 0; p < hasRemove.length; ++p) {
                    if (!hasRemove[p]) {
                        sb.append(s[p]);
                        return sb.toString();
                    }
                }
            }
            times = multiple(n - i);
            num = k / times;
            while (hasRemove[num]) {
                num++;
            }
            hasRemove[num] = true;
            sb.append(s[num]);
            k = complement % times;

        }

        return sb.toString();
    }

    public int multiple(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * multiple(n - 1);
    }
}
