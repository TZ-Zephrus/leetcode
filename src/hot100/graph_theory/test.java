package hot100.graph_theory;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-07
 */
public class test {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        CourseSchedule207 courseSchedule207 = new CourseSchedule207();
        boolean b = courseSchedule207.canFinish(5, arr);
        System.out.println(b);
    }
}
