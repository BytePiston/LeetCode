class Solution {
    public String interpret(String command) {
        if(command.length()<=1)
            return command;
        char[] charArray = command.toCharArray();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i+1<=charArray.length){
            if(charArray[i] == '(' && (i+1<charArray.length && charArray[i+1] == ')')){
                sb.append("o");
                i+=2;
            } else if(charArray[i] == '(' && (i+1<charArray.length && charArray[i+1] == 'a')){
                sb.append("al");
                i+=3;
            } else if(charArray[i] == 'g' || charArray[i] == 'G'){
                sb.append(charArray[i]);
                i++;
            }
            else
                i++;
        }
        return sb.toString();
    }
}