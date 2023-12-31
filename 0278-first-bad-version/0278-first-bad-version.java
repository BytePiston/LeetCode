/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isBadVersion(mid) && !isBadVersion(mid-1))
                return mid;
            else if(!isBadVersion(mid))
                l = mid+1;
            else
                r = mid-1;
        }
        return -1;
    }
}