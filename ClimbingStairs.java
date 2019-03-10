/**
 * Created by zfz on 2019/3/10.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return climb(n, new int[n + 1]);
    }

    public int climb(int n, int record[]){
        if(n <= 3){
            record[n] = n;
            return n;
        }

        if(record[n - 2] == 0){
            record[n - 2] = climb(n - 2, record);
        }
        if(record[n - 1] == 0){
            record[n - 1] = climb(n - 1, record);
        }
        return record[n - 2] + record[n - 1];
    }

//    433494437
}
