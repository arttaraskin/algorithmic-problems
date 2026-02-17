// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description
// 1351. Count Negative Numbers in a Sorted Matrix
/* Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0 */

class CountNegativeNumberInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = m - 1, j = 0;

        int cnt = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                cnt += n - j;
                i--;
            } else
                j++;
        }
        return cnt;
    }
}

class CountNegativeNumberInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int cnt = 0, last = -1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j > last; j--) {
                if (grid[i][j] < 0) {
                    cnt++;
                } else {
                    last = j;
                    break;
                }
            }
            if (last == grid.length - 1) {
                break;
            }
        }
        return cnt;
    }
}
`