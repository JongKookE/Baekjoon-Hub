class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletMin = Math.min(wallet[0], wallet[1]);
        int walletMax = Math.max(wallet[0], wallet[1]);
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);
        
        while(isSuccess(walletMin, walletMax, billMin, billMax)){
            
            billMax /= 2;
            if(billMax < billMin){
                int temp = billMax;
                billMax = billMin;
                billMin = temp;
            }
            
            // System.out.println(billMin + " " + billMax);
            answer++;
        }
        return answer;
    }
    
    boolean isSuccess(int walletMin, int walletMax, int billMin, int billMax){
        if(billMin <= walletMin && billMax <= walletMax) return false;
        return true;
    }
}