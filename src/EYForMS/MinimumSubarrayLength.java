package EYForMS;/*
Question:
You are given an array of positive integers and a positive integer target.
Write a Java program that finds the minimum length of a contiguous subarray,
whose sum is greater than or equal to the given target. If no such subarray exists, the program should return 0.

Example:
	•	Input:
	•	target = 7
	•	nums = [2, 3, 1, 2, 4, 3]
	•	Output:
	•	2

Explanation:
	•	The smallest subarray whose sum is greater than or equal to the target 7 is [4, 3], which has a length of 2.

Constraints:
	•	The input array nums contains only positive integers.
	•	The target is a positive integer.
 */

public class MinimumSubarrayLength {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum length of subarray: " + result);
    }
}