class Solution {
    // We only need primes up to 19 because R≤10^6<2^20 -> 20 bits
    // private val PRIMES = setOf(2, 3, 5, 7, 11, 13, 17, 19)
    private val PRIMES = intArrayOf(0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0)

    fun countPrimeSetBits(left: Int, right: Int): Int {
        var ans = 0
        for (x in left..right) {
            // isPrime (a common method) and getSetBit (instead of countOneBits) can be used
            // if (PRIMES.contains(x.countOneBits())) {
            if (PRIMES[x.countOneBits()] == 1) {
                ans++
            }
        }
        return ans
    }

    fun isPrime(n: Int): Boolean {
        // Corner case
        if (n <= 1) return false
        // Check from 2 to sqrt(n)
        val limit = kotlin.math.sqrt(n.toDouble()).toInt()
        for (i in 2..limit) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    fun getSetBit(n: Int): Int {
        var count = 0
        var num = n
        while (num > 0) {
            if (num % 2 != 0) count++
            num /= 2
        }
        return count
    }
}
