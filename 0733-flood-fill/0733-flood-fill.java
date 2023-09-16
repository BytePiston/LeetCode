class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        solve(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void solve(int[][] image, int sr, int sc, int oldColor, int newColor){
        if(sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != oldColor)
            return;
        image[sr][sc] = newColor;
        solve(image, sr + 1, sc, oldColor, newColor);
        solve(image, sr - 1, sc, oldColor, newColor);
        solve(image, sr, sc + 1, oldColor, newColor);
        solve(image, sr, sc - 1, oldColor, newColor);
    }
}