class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        for(int layer=0; layer<(n+1)/2; layer++){
            //Top left --> Top right; row remains same only col changes;
            for(int col=layer; col<=n-layer-1; col++){
                result[layer][col] = count++;
            }

            //Top right --> Bottom right; col remains same only row changes;
            for(int row=layer+1; row<=n-layer-1; row++){
                result[row][n-layer-1] = count++;
            }

            //Bottom right --> Bottom left; row remains same only col changes;
            for(int col=n-layer-2; col>=layer; col--){
                result[n-layer-1][col] = count++;
            }

            //Bottom left --> Top left; col remains same only row changes;
            for(int row=n-layer-2; row>layer; row--){
                result[row][layer] = count++;
            }
        }

        return result;
    }
}