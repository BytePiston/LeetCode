class Solution {
    
    //dir int folllows anticlockwise rotation as follows:
    // 0 -> 'N'
    // 1 -> 'W'
    // 2 -> 'S'
    // 3 -> 'E'
    
    //Optimised Approach with less if-else conditions
    public boolean isRobotBounded(String instructions) {
        
        //Initially pos. (0, 0);
        int[] coordinates = {0, 0};
        
        //Initially keeping dir as 0 -> 'N'
        int dir = 0;
        
        //2D Array keeping track of all direction change in X and Y coordinates change N, W, S, E respectively;
        int[][] dirArray = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        
        //Iterating though instructions and processing each char;
        for(char ch: instructions.toCharArray()){
            if(ch == 'L'){
                dir = (dir+1) % 4;
            } else if(ch == 'R'){
                dir = (dir+3) % 4;
            } else{
                coordinates[0] += dirArray[dir][0];
                coordinates[1] += dirArray[dir][1];
            }
            
        }
        if(coordinates[0] == 0 && coordinates[1] == 0)
            return true;   
        if (dir == 0)
            return false;
        return true;
    }
    
/*
    //Native Approach
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
*/
}