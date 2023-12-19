package greedy;

import java.util.Arrays;

public class distributeCoocies455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexCookie = s.length-1;
        int result = 0;
        for (int i = g.length-1; i>=0; i--) {
            if (indexCookie > 0 && s[indexCookie] >= g[i]) {
                indexCookie--;
                result++;
            }
        }
        return result;
    }

}
