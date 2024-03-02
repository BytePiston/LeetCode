class Solution {
    Map<Character, Integer> map;
    
    public String decodeMessage(String key, String message) {
        prepareMap(key);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<message.length(); i++){
            char ch = message.charAt(i);
            if(Character.isWhitespace(ch)){
                sb.append(" ");
            } else{
                sb.append((char)(map.get(ch)+'a'));
            }
        }
        return sb.toString();
    }
    
    void prepareMap(String key){
        map = new HashMap<>();
        int i=0;
        int j=0;
        while(i<key.length() && map.size()<27){
            char ch = key.charAt(i);
            if(!map.containsKey(ch) && !Character.isWhitespace(ch)){
                map.put(ch, j);
                j++;
            }
            i++;
        }
    }
}