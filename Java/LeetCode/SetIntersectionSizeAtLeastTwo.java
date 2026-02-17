// https://leetcode.com/problems/set-intersection-size-at-least-two/description
// 757. Set Intersection Size At Least Two

public class SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        System.out.println("Result: " + intersectionSizeTwo(new int[][]{{1,3}, {3,7}, {5,8}, {8,9}, {10,20}}));
        System.out.println("Result: " + intersectionSizeTwo(new int[][]{{2,10},{3,7},{3,15},{4,11},{6,12},{6,16},{7,8},{7,11},{7,15},{11,12}}));
        System.out.println("Result: " + intersectionSizeTwo(new int[][]{{1,3},{3,7},{5,7},{7,8}}));
    }

    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        System.out.println(Arrays.deepToString(intervals));

        int result = 0;
        int a = -1, b = -1;
        for (int[] it : intervals) {
            int left = it[0], right = it[1];
            if (left > b) {
                a = right - 1;
                b = right;
                System.out.println(a);
                System.out.println(b);
                result += 2;
            } else if (left > a) {
                a = b;
                b = right;
                System.out.println(b);
                result += 1;
            }
        }
        return result;
    }

    public static int intersectionSizeTwo2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[1]).thenComparing(arr -> arr[0], Comparator.reverseOrder()));
        System.out.println(Arrays.deepToString(intervals));

        int[] found = new int[intervals.length];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (found[i] == 0) {
                check(intervals[i][1] - 1, i, intervals, found);
                System.out.println(intervals[i][1] - 1);
                count++;
            }
            if (found[i] == 1) {
                check(intervals[i][1], i, intervals, found);
                System.out.println(intervals[i][1]);
                count++;
            }
        }
        return count;
    }

    private static void check(int element, int startFrom,  int[][] intervals, int[] found) {
        for (int i = startFrom; i < intervals.length && element >= intervals[i][0] && element <= intervals[i][1]; i++) {
            found[i]++;
        }
    }
}
