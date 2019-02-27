import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2019/2/27.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, n, n, "");
        return res;
    }

    public void generate(List<String> res, int left, int right, String s){
        if(left > right){
            return;
        }

        if(left > 0){
            generate(res, left - 1, right, s+"(");
        }
        if(right > 0){
            generate(res, left, right - 1, s+")");
        }
        if(right == 0 && left == 0){
            res.add(s);
        }
    }

}
