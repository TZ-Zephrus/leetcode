package hot100.double_pointer;

public class trapRain42 {
    public int trap(int[] height) {
        int i = 0;
        int j = 0;
        int result = 0;
        int part = 0;
        while (j < height.length) {
            if (height[j] < height[i]) {
                part += height[i] - height[j];
            } else {
                result += part;
                part = 0;
                i = j;
            }
            j++;
        }


        //反向
        i = height.length-1;
        j = height.length-1;
        part = 0;
        while (i >= 0) {
            if (height[i] <= height[j]) {
                part += height[j] - height[i];
            } else {
                result += part;
                part = 0;
                j = i;
            }
            i--;
        }
        return result;
    }
}
