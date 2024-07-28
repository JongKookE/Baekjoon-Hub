class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int totalTime = getTotalTime(attacks);
        int maximumHealth = health;
        int castingTime = bandage[0];
        int perHeal = bandage[1];
        int addPerHeal = bandage[2];

        int attackTime = 0;
        // 공격을 받지 않은 시간 저장
        int goOnTime = 0;
        for(int i = 1; i <= totalTime; i++) {
            if(i == attacks[attackTime][0]){
                // TODO 공격받고 체력 줄어듬, health가 0 이하가 되면 메소드 종료
                // attacktimes는 공격을 하고 인덱스 1 추가
                health -= attacks[attackTime++][1];
                goOnTime = 0;
                if (health <= 0) return -1;
            }
            else{
                if(++goOnTime == castingTime){
                    health = healing(maximumHealth, health, perHeal, addPerHeal, true);
                    goOnTime = 0;
                }
                else health = healing(maximumHealth, health, perHeal, addPerHeal, false);
            }
        }
        return health;
    }

    int healing(int maximumHealth, int health, int perHeal, int successHeal, boolean goOnTime){
        // Heal이 성공했을때
        health += perHeal;
        if(goOnTime) health += successHeal;
        // maximumHealth는 고정되어있기 때문에 힐로 받은 체력회복량으로 인해서 최대체력을 넘는다면 최대체력으로 리턴
        return Math.min(health, maximumHealth);
    }

    int getTotalTime(int[][] attacks) {
        int totalTime = 0;
        for(int[] attack: attacks) totalTime = Math.max(totalTime, attack[0]);
        return totalTime;
    }
}