class Solution {
    public boolean isRobotBounded(String instructions) {
        int xCoordinate = 0;
        int yCoordinate = 0;
        char dir = 'N';
        
        //Iterate through instructions String.
        for(char ch: instructions.toCharArray()){
            if(ch == 'G'){
                if(dir == 'N'){
                    xCoordinate++; 
                } else if(dir == 'E'){
                    yCoordinate++;
                } else if(dir == 'W'){
                    yCoordinate--;
                } else{
                    xCoordinate--;
                }
                
            } else if(ch == 'L'){
                if(dir == 'N'){
                    dir = 'W'; 
                } else if(dir == 'E'){
                    dir = 'N'; 
                } else if(dir == 'W'){
                    dir = 'S';
                } else{
                    dir = 'E';
                }
            } else{
                if(dir == 'N'){
                    dir = 'E'; 
                } else if(dir == 'E'){
                    dir = 'S'; 
                } else if(dir == 'W'){
                    dir = 'N';
                } else{
                    dir = 'W';
                }
            }
        }
        if(xCoordinate == 0 && yCoordinate == 0)
            return true;   
        if (dir == 'N')
            return false;
        return true;
    }
}