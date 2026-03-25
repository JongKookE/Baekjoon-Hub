class Solution{
    long solution(int w, int h){
        int gcd = gcd(w, h);

        long value = (long) gcd * (w/gcd + h/gcd - 1);

        return (long) w * h - value;
    }

    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
