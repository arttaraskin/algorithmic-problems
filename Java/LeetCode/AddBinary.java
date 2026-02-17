// https://leetcode.com/problems/add-binary/description
// 67. Add Binary
/* Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101" */

class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, sum = 0;

        while (i >= 0 || j >= 0 || sum == 1) {
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2);
            sum /= 2;
        }

        return result.reverse().toString();
    }
	
	public String addBinary2(String a, String b) {
        var aN = new BigInteger(a, 2);
        var bN = new BigInteger(b, 2);
        return aN.add(bN).toString(2);
    }
}
