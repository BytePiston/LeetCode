class Solution {
    public String addBinary(String a, String b) {
        if(a.isEmpty() || b.isEmpty())
            return a.isEmpty() ? b : a;
        int i1 = a.length()-1;
        int i2 = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i1>=0 || i2>=0){
            int sum = carry;
            if(i2>=0)
                sum += b.charAt(i2--)-'0';
            if(i1>=0)
                sum += a.charAt(i1--)-'0';
            sb.insert(0, sum%2);
            carry = sum/2;
        }
        if(carry !=0)
            sb.insert(0, carry);
        return sb.toString();
    }
}