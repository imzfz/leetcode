/**
 * Created by zfz on 2019/2/21.
 * atoi function
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        String res = str.trim().split(" ")[0];
        if (res.length() == 0) {
            return 0;
        }
        int i, flag = 0;
        for(i = 0; i < res.length(); i++){
            if(res.charAt(i) < '0' || res.charAt(i) > '9'){
                if(res.charAt(i) == '+' || res.charAt(i) == '-'){
                    if(i == 0) {
                        flag = 1;
                        continue;
                    }
                }
                if(flag == 2){
                    break;
                }
                else return 0;
            }
            flag = 2;
        }
        if(flag == 2) {
            res = res.substring(0, i);
        }
        else return 0;
        try {
            return Integer.parseInt(res);
        } catch (NumberFormatException e) {
            if (res.charAt(0) == '-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
}
