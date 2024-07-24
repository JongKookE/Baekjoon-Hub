class Solution {
    static int[] src;
    static int[] discountPercentages = {40, 30, 20, 10};
    static int maxUser, maxCost;
    public int[] solution(int[][] users, int[] emoticons) {
        src = new int[emoticons.length];
        perm(0, users, emoticons);
        return new int[]{maxUser, maxCost};
    }
    void perm(int idx, int[][] users, int[] emoticons) {
        if(idx == src.length){
            calc(users, emoticons);
            return;
        }
        for(int i = 0; i < 4; i++) {
            src[idx] = discountPercentages[i];
            perm(idx + 1, users, emoticons);
        }
    }

    void calc(int[][] users, int[] emoticons) {
        int amount = 0;
        int membershipCnt = 0;
        for(int[] user: users){
            int canBuyPercentage = user[0];
            int canMemberCost = user[1];
            int currentCost = 0;
            for(int j = 0; j < emoticons.length; j++){
                int emoticonCost = emoticons[j];
                int discountPercentage = src[j];
                // 유저가 원하는 할인률보다 이모티콘의 할인률이 낮으면 결제하지 않겠다
                if(canBuyPercentage > discountPercentage) continue;
                currentCost += (int) (emoticonCost * ((100 - discountPercentage) * 0.01));
            }
            // amount가 canMemberCost보다 크다면 모든 결제를 취소하고 멤버십을 가입한다.
            if(currentCost >= canMemberCost) membershipCnt++;
            else amount += currentCost;
        }

        if(membershipCnt > maxUser) {
            maxUser = membershipCnt;
            maxCost = amount;
        }
        else if(membershipCnt == maxUser) maxCost = Math.max(maxCost, amount);
    }
}