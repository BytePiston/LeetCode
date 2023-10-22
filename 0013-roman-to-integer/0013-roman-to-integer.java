class Solution {
    Map<Character, Integer> map = new HashMap<>();

    public int romanToInt(String s) {
        fillMap();
        int index = 0;
        int number = 0;
        while(index < s.length()-1){
            int curr = map.get(s.charAt(index));
            int next = map.get(s.charAt(index+1));
            if(curr >= next){
                number += curr;
                index += 1;
            }  else{
                number += next - curr;
                index += 2;
            }
        }
        if(index+1==s.length())
            number += map.get(s.charAt(index));
        return number;
    }

    void fillMap(){
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

}