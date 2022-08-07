import collections
from typing import List

#
# @lc app=leetcode id=974 lang=python3
#
# [974] Subarray Sums Divisible by K
# python的 mod % 会自动把负数转成正数, -1 % 5 = 4. 所以比 java 的少操作一步.

# @lc code=start
class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        modCount = collections.Counter([0])
        res = 0
        prefix = 0
        
        for num in nums:
            prefix = (prefix + num) % k
            res += modCount[prefix]
            modCount[prefix] += 1
        
        return res
        
# @lc code=end
so = Solution();
so.subarraysDivByK([4,5,0,-2,-3,1], 5)

