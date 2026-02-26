class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum;
            int rightSum = totalSum - prefixSum - nums[i];

            int leftPart = i * nums[i] - leftSum;
            int rightPart = rightSum - (n - i - 1) * nums[i];

            result[i] = leftPart + rightPart;

            prefixSum += nums[i];
        }

        return result;
    }
}
