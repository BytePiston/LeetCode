class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String operation: operations){
            switch(operation){
                case "--X":
                    x-=1;
                    break;
                case "X--":
                    x-=1;
                    break;
                case "++X":
                    x+=1;
                    break;
                case "X++":
                    x+=1;
                    break;
                default:
                    continue;
            }
        }
        return x;
    }
}