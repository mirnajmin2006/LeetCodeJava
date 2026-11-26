class Solution {
    public int[][] merge(int[][] intervals) {
        java.util.Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] result = new int[intervals.length][2];
        int j = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (j == 0 || result[j - 1][1] < intervals[i][0]) {
                result[j++] = intervals[i];
            } else {
                result[j - 1][1] = Math.max(result[j - 1][1], intervals[i][1]);
            }
        }

        return java.util.Arrays.copyOf(result, j);
    }
}