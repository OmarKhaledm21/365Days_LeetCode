/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        boolean detect = false;
        int first_bad_version = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if(detect && !isBadVersion(h)){
                break;
            }
            if (isBadVersion(m)) {
                detect = true;
                first_bad_version = m;
                h = m-1;
            } else {
                l = m + 1;
            }

        }
        return first_bad_version;
    }
}