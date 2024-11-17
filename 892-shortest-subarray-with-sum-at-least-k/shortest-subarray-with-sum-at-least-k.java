import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int result = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.removeLast();
            }
            
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= k) {
                result = Math.min(result, i - deque.getFirst());
                deque.removeFirst();
            }
            
            deque.addLast(i);
        }
        
        return result <= n ? result : -1;
    }
}