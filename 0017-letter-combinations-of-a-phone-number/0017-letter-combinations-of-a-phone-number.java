class Solution {
    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return new ArrayList<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        return findPerm("", digits);
    }

    List<String> findPerm(String p, String up){
        
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> result = new ArrayList<>();
        Character ch = up.charAt(0);
        String digitToStr = map.get(ch);
        for(int i=0; i<digitToStr.length(); i++){
            result.addAll(findPerm(p+digitToStr.charAt(i), up.substring(1)));
        }
        return result;
    }
}