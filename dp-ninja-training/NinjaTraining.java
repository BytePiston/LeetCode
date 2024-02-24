import java.util.*;
public class NinjaTraining {

    //Iterative Solution using DP;
    public int ninjaTrainingIterative(int n, int points[][]) {
        // Write your code here..
        int[][] dp = new int[n][4];
        
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day<n; day++){
            for(int last=0; last<4; last++){
                dp[day][last] = 0;
                for(int task=0; task<3; task++){
                    if(task != last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    //Recursive Solution using DP;
    public int ninjaTrainingRecursive(int day, int last, int[][] points, int[][] dp) {

        // Base case: When it's the first day (day == 0)
        if (day == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    max = Math.max(max, points[0][i]);
            }
            return dp[day][last] = max; // Store and return the result
        }

        // If the result is already calculated, return it
        if (dp[day][last] != -1) return dp[day][last];

        int max = 0;
        // Loop through the three activities on the current day
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                // Calculate the points for the current activity and recursively
                // calculate the maximum points for the previous day
                int activity = points[day][i] + ninjaTrainingRecursive(day - 1, i, points, dp);
                max = Math.max(max, activity); // Update the maximum points
            }
        }

        return dp[day][last] = max; // Store and return the result
    }
}
