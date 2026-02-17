// https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
// 3005. Count Elements With Maximum Frequency

class CountElementsWithMaximumFrequency {
	fun maxFrequencyElements(nums: IntArray): Int {
        val frequencies = ByteArray(101)
        var max: Byte = 0
        var res: Byte = 0
        for (n in nums) {
            val frequency: Byte = ++frequencies[n]
            if (frequency > max) {
                max = frequency
                res = frequency
            } else if (frequency == max) {
                res = (res + frequency).toByte()
            }
        }
        return res.toInt()
    }
	
    fun maxFrequencyElements2(nums: IntArray): Int {
        val frequencies = HashMap<Int, Int>()
        var maxFrequency = 0
        var totalFrequencies = 0
        for (num in nums) {
            var frequency = frequencies.getOrDefault(num, 0)
            frequencies[num] = ++frequency
            // If we discover a higher frequency element
            // Update maxFrequency
            // Re-set totalFrequencies to the new max frequency
            if (frequency > maxFrequency) {
                maxFrequency = frequency
                totalFrequencies = frequency
                // If we find an element with the max frequency, add it to the total
            } else if (frequency == maxFrequency) {
                totalFrequencies += frequency
            }
        }
        return totalFrequencies
    }
}
