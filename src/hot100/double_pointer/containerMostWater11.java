package hot100.double_pointer;

public class containerMostWater11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxVolume = 0;
        while (i < j) {
            maxVolume = Math.max(maxVolume, (j-i)*Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxVolume;
    }
}
