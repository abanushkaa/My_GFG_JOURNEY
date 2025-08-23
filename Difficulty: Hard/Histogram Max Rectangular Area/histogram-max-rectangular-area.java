class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int height = arr[i];

            // expand left
            int left = i;
            while (left - 1 >= 0 && arr[left - 1] >= height) {
                left--;
            }

            // expand right
            int right = i;
            while (right + 1 < n && arr[right + 1] >= height) {
                right++;
            }

            // width = number of bars this height can extend
            int width = right - left + 1;
            int area = height * width;

            res = Math.max(res, area);
        }
        return res;
    }
}
