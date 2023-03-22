public class Solution {
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] data = new int[100002];
        data[0] = 1;
        int i = 0, j = 0;
        int count = 1;
        while (i < n) {
            if (data[j] == 1) {
                if (data[i] == 1) {
                    data[++i] = 2;
                }
                else {
                    data[++i] = 1;
                    if (i < n) {
                        count ++;
                    }
                }
            }
            else {
                if (data[i] == 1) {
                    data[++i] = 1;
                    if (i < n) {
                        count ++;
                    }
                    data[++i] = 2;
                }
                else {
                    data[++i] = 2;
                    data[++i] = 1;
                    if (i < n) {
                        count ++;
                    }
                }
            }
            j ++;
        }
        return count;
    }
}
