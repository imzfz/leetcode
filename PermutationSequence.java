import java.util.*;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        return res(n, k - 1);
    }

    public String res(int n, int k){
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int times, num, complement = k;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            if (i == n) {
                sb.append(list.get(0));
                return sb.toString();
            }

            times = (multiple(n - i));
            num = complement / times;
            if (i != 1) {
                complement = complement % times;
            }


            if (num >= n - i + 1) {
                num = num % (n - i + 1);
            }
            sb.append(list.get(num));
            list.remove((int) (num));
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
