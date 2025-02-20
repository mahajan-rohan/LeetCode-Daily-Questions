/*
1380. Lucky Numbers in a Matrix
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.

Constraints:
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
 */

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix_19_07_2024 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int low = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                if (low > matrix[i][j]) {
                    low = matrix[i][j];
                }
            }
            min.add(low);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int high = matrix[0][j];
            for (int i = 0; i < matrix.length; i++) {
                if (high < matrix[i][j]) {
                    high = matrix[i][j];
                }
            }
            max.add(high);
        }

        for (Integer num1 : min) {
            if (max.contains(num1) && !ans.contains(num1)) {
                ans.add(num1);
            }
        }
        return ans;
    }
}
