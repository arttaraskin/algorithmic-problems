// https://leetcode.com/problems/minimum-time-visiting-all-points/description
// 1266. Minimum Time Visiting All Points

import kotlin.math.abs
import kotlin.math.max

class MinimumTimeVisitingAllPoints {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var count = 0
        for (i in 1..<points.size) {
            var step = max(
                abs(points[i - 1][0] - points[i][0]),
                abs(points[i - 1][1] - points[i][1])
            )
            count += step
        }
        return count
    }
}
