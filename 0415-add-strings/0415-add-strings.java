class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        boolean carryDigit = false;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        while(index1 >= 0 && index2 >= 0){
            int sum = (num1.charAt(index1)-'0')+(num2.charAt(index2)-'0');
            if(carryDigit){
                sum += 1;
                carryDigit = false;
            }
            if(sum > 9){
                carryDigit = true;
            }
            sb.append(sum%10);
            index1--;
            index2--;
        }
        
        while(index1 >= 0){
            int sum = (num1.charAt(index1)-'0');
            if(carryDigit){
                sum += 1;
                carryDigit = false;
            }
            if(sum > 9){
                carryDigit = true;
            }
            sb.append(sum%10);
            index1--;
        }
        
        while(index2 >= 0){
            int sum = (num2.charAt(index2)-'0');
            if(carryDigit){
                sum += 1;
                carryDigit = false;
            }
            if(sum > 9){
                carryDigit = true;
            }
            sb.append(sum%10);
            index2--;
        }
        
        if(carryDigit){
            sb.append(1);
        }
        
        sb.reverse();
        return sb.toString();
    }
}