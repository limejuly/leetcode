/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if (count != 1)
                for (char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }

    // 自己写的版本, 找找差距.
    // 两个指针移动. 第一遍数 digits, 把重复的置 0. 第二遍compact.
    public int compress2(char[] chars) {
        int lastHead = 0;
        int count = 1;
        char stop = '\u0000';
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else if (count > 1) { // end with a repreating chain
                lastHead = copyCount(chars, lastHead, count);
                while (lastHead != i - 1) {
                    chars[++lastHead] = stop;
                }
                lastHead++;
                count = 1;
            } else { // just by passed a single character
                lastHead = i;
            }

            if (i == (chars.length - 1) && count > 1) {
                lastHead = copyCount(chars, lastHead, count);
                while (lastHead != i) {
                    chars[++lastHead] = stop;
                }
            }
        }
        System.out.println(chars);

        // compress value
        count = 0;
        // to the first blank
        while (count < chars.length && chars[count] != stop) {
            count++;
        }
        lastHead = count;
        while (count < chars.length) {
            if (chars[count] == stop) {
                count++;
            } else {
                chars[lastHead++] = chars[count++];
            }
        }

        return lastHead;
    }

    private static int copyCount(char[] chars, int last, int count) {
        char[] digits = String.valueOf(count).toCharArray();
        int p = 0;
        while (p < digits.length) {
            chars[++last] = digits[p++];
        }
        return last;
    }
}
// @lc code=end
