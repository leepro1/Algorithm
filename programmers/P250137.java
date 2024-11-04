package programmers;

public class P250137 {

    public int solution(int[] bandage, int health, int[][] attacks) {

        int nowHealth = health;
        int nowTime = 0;

        for (int[] attack : attacks) {
            int diffTime = attack[0] - nowTime - 1;
            nowHealth += diffTime >= bandage[0] ? (diffTime / bandage[0] * bandage[2]
                + bandage[1] * diffTime) : (bandage[1] * diffTime);

            nowHealth = Math.min(nowHealth, health);
            nowHealth -= attack[1];
            nowTime = attack[0];

            if (nowHealth <= 0) {
                return -1;
            }

        }

        return nowHealth;
    }
}
