class Solution {
    public boolean isPalindrome(int x) {
        int res = 0;
        int n=x;
        while(n>0){
            int remainder = n%10;
            n=n/10;
            res = res*10+remainder;
        }
        System.out.println(res);
        return res==x;
    }
}