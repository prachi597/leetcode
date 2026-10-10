
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int[] count = new int[100001];
        int max = 0;
        long sum = 0;

        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            count[d]++;
            max = Math.max(max, d);
            sum += d;
        }

        if (k >= sum) {
            return 0;
        }

        for (int d = max; d > 0 && k > 0; d--) {
            long move = Math.min(k, count[d]);

            count[d] -= move;
            count[d - 1] += move;
            k -= move;
        }

        long answer = 0;

        for (int d = 1; d <= max; d++) {
            answer += (long) d * d * count[d];
        }

        return answer;
    }
}
