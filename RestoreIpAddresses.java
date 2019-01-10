import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        isTrueIp(s, 0, "", result);
        return result;
    }

    public void isTrueIp(String s, int n, String finish, List<String> res){
        if(n == 4){
            if(s.isEmpty()){
                res.add(finish);
                return;
            }
            return;
        }

        for(int i = 1; i < 4; i++){
            if(s.length() < i){
                break;
            }
            int val = Integer.parseInt(s.substring(0, i));
            if(String.valueOf(val).length() != s.substring(0, i).length() || val > 255){
                continue;
            }
            isTrueIp(s.substring(i), n + 1, finish + s.substring(0, i) + (n == 3 ? "" : "."), res);
        }
    }

    /**
     * 简单范例
     */

    public List<String> easierExample(String s) {
        // 除了下面比较简单的方法外，应该还可以使用递归回溯来解决
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return res;
        }
        for (int i = 1; i <= 3 && i < s.length(); i++) {
            String p1 = s.substring(0, i);
            if (isLegal(p1)) {
                for (int j = i + 1; j <= 6 && j < s.length(); j++) {
                    String p2 = s.substring(i, j);
                    if (isLegal(p2)) {
                        for (int k = j + 1; k <= 9 && k < s.length(); k++) {
                            String p3 = s.substring(j, k);
                            if (isLegal(p3)) {
                                String p4 = s.substring(k);
                                if (isLegal(p4)) {
                                    res.add(p1 + "." + p2 + "." + p3 + "." + p4);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isLegal(String p) {
        if (p.startsWith("0")) {
            return "0".equals(p);
        } else {
            return Integer.valueOf(p) <= 255;
        }
    }
}