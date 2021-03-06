class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        // ***********************************一定注意从大往小的时候 k--
        for (int k = nums.length - 1; k >= 2; k--) {
            int start = 0;
            // *************这里一定写成k - 1
            int end = k - 1;
            while (start < end) {
                // **************************nums[k] 不是k
                if (nums[start] + nums[end] > nums[k]) {
                    // 最大的为k的时候，end - start 中间的都符合，start + (end - start) 中间的都是比k大的
                    // *********************total += (end - start);
                    total += (end - start);
                    // 比end大的肯定都合适，为了到达临界值 start < end，所以end--
                    end--;
                } else {
                    start++;
                }
            }
        }
        return total;
    }
}