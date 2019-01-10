import java.util.Arrays;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        int[] index = new int[26];
        int[] offset = new int[26];
        int[] tempOffset = new int[26];
        boolean[] is = new boolean[26];
        boolean[] isNow;
        int j = 0;

        Arrays.sort(c1);

        for (int i = 0; i < c1.length; ++i) {
            for(j = 0; j < 26; ++j) {
                if (!is[j] && c1[i] == (char) (j + 97)) {
                    index[j] = i;
                    is[j] = true;
                    break;
                }
            }
        }

        for (int k = 0; k < s2.length(); ++k) {
            isNow = is.clone();
            tempOffset = offset.clone();
            for (int i = k; i < s2.length(); ++i) {
                if(s2.charAt(i) >= 'a' && s2.charAt(i) <= 'z' &&
                        s2.charAt(i) == c1[index[s2.charAt(i) - 97] + tempOffset[s2.charAt(i) - 97]] &&
                        isNow[s2.charAt(i) - 97]){
                    if(index[s2.charAt(i) - 97] + tempOffset[s2.charAt(i) - 97] + 1 < c1.length &&
                            c1[index[s2.charAt(i) - 97] + tempOffset[s2.charAt(i) - 97]] ==
                            c1[index[s2.charAt(i) - 97] + tempOffset[s2.charAt(i) - 97] + 1]){
                        tempOffset[s2.charAt(i) - 97]++;
                    }
                    else {
                        isNow[s2.charAt(i) - 97] = false;
                    }
                }
                else {
                    break;
                }
                if (i + 1 <= s2.length() && s2.substring(k, i + 1).length() == s1.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
