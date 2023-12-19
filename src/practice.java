import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class practice {
    static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<Integer> coins = new ArrayList<>(3);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        for (String string : s1) {
            coins.add(Integer.parseInt(string));
        }
        backtrack(coins, num, 0, 0);
        if (minNum == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minNum);
        }
    }

    private static void backtrack(List<Integer> coins, int num, int sum, int coinNum) {
        if (num == sum) {
            if (coinNum < minNum) {
                minNum = coinNum;
            }
            return;
        }
        for (int i = 0; i < coins.size(); i++) {
            sum = sum + coins.get(i);
            coinNum++;
            if (!(sum > num)) {
                backtrack(coins, num, sum, coinNum);
            }
            coinNum--;
            sum = sum - coins.get(i);
        }
    }
}
