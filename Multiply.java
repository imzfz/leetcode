import java.util.Stack;

public class Multiply {
    //相乘 错位相加
    public String multiply(String num1, String num2) {
        Stack<String> strings = new Stack<>();
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        //进位标志
        int goon = 0;
        //成绩
        int product = 0;
        int n = 0;
        String res = "0";
        //直接返回0
        if(num1.length() == 1 && num1.charAt(0) - 48 == 0 || num2.length() == 1 && num2.charAt(0) - 48 == 0){
            return "0";
        }

        if(num1.length() > num2.length()){
            c1 = num2.toCharArray();
            c2 = num1.toCharArray();
        }

        for (int i = c1.length - 1; i >= 0; i--){
            for (int j = c2.length - 1; j >= 0; j--){
                int n1 = c1[i] - 48;
                int n2 = c2[j] - 48;
                int complement = 0;//余数
                product = n1 * n2;
                if(product > 9){
                    complement = product % 10;
                    if(complement + goon <= 9) {
                        strings.push(String.valueOf(complement + goon));
                        //进位
                        goon = product / 10;
                    }
                    else {
                        strings.push(String.valueOf((complement + goon) % 10));
                        goon = product / 10 + 1;
                    }
                }
                else{
                    if(complement + goon + product <= 9) {
                        strings.push(String.valueOf(complement + goon + product));
                        goon = 0;
                    }
                    else {
                        strings.push(String.valueOf((complement + goon + product) % 10));
                        goon = (complement + goon + product) / 10;
                    }
                }
            }
            if(goon != 0) {
                strings.push(String.valueOf(goon));
                goon = 0;
            }
            res = sum(res, stackToString(strings, n));
            n++;
        }
        return String.valueOf(res);
    }

    //通用字符加法
    public String sum(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int goon = 0;
        if(s1.length() < s2.length()){
            c1 = s2.toCharArray();
            c2 = s1.toCharArray();
        }

        int i = 0, j = 0;
        int complement = 0;
        for(i = c1.length - 1, j = c2.length - 1; i >= 0 && j >= 0; i--, j--){
            int sum = c1[i] - 48 + c2[j] - 48;
            if(sum + complement > 9){
                stack.push(String.valueOf((sum + complement) % 10));
                complement = (sum + complement) / 10;
            }
            else {
                stack.push(String.valueOf((sum + complement)));
                complement = 0;
            }
        }

        for(; i >= 0; i--){
            int sum = c1[i] - 48 + complement;
            if(sum > 9){
                stack.push(String.valueOf((sum) % 10));
                complement = sum / 10;
            }
            else {
                stack.push(String.valueOf(sum));
                complement = 0;
            }
        }

        if(complement != 0){
            stack.push(String.valueOf(complement));
        }

        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public String stackToString(Stack<String> s, int n){
        StringBuilder sb = new StringBuilder();
        while(!s.empty()){
            sb.append(s.pop());
        }
        while(n > 0){
            sb.append("0");
            n--;
        }
        return sb.toString();
    }
}
