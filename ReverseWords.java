import java.util.Stack;

public class ReverseWords {
    public String reverseWords(String s) {
        Stack<String> strings = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        if(s.trim().length() == 0){
            return "";
        }
        s = s.trim();

        for(int i = 0; i < s.length() && k < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(s.substring(k, i).trim().length() != 0){
                    strings.push(s.substring(k, i));
                }
                k = i + 1;
            }
            if(i == s.length() - 1){
                strings.push(s.substring(k));
            }
        }

        while(!strings.empty()){
            sb.append(strings.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
