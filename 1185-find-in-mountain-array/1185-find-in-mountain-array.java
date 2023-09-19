/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int peakElement = mountainArr.get(peak);
        int find=agnosticBinarySearch(target, mountainArr,0,peak);
        if(find!=-1){
            return find;
        }
        return agnosticBinarySearch(target, mountainArr,peak+1,mountainArr.length()-1);
    }

    int findPeak(MountainArray mountainArr){
        int s = 0;
        int e = mountainArr.length() - 1;
        while(s<e){
            int mid = s + (e-s)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid+1))
                e = mid;
            else if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                s = mid+1;
            }
        }
        return s;
    }

    int agnosticBinarySearch(int target, MountainArray mountainArr, int s, int e){
        boolean asc=mountainArr.get(s) < mountainArr.get(e);
        while(s<=e){
            int mid = s + (e-s)/2;
            if(mountainArr.get(mid) == target)
                return mid;
            else if(mountainArr.get(mid) < target){
                if(asc)
                    s = mid+1;
                else
                    e = mid-1;
            } else
                if(asc)
                    e = mid-1;
                else
                    s = mid+1;
            }
            return -1;
    }   
}
