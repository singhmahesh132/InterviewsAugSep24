package EYForMS;

import java.util.ArrayList;
import java.util.List;

/*
Question:

Problem: Coin Change Combinations Using Dynamic Programming with Lists
You are given a list of integers coins representing different denominations of coins, and an integer amount
representing a target sum of money. You need to determine the number of unique combinations of the coins that
can sum up to the target amount. Each coin in the list can be used an infinite number of times.
Write a Java program that uses dynamic programming to solve this problem. Instead of using arrays,
your solution should utilize a List<Integer> to represent the dynamic programming table.

Example:
    List<Integer> coins = List.of(1, 2, 5);
    int amount = 5;
    System.out.println(coinChangeCombinations(coins, amount)); // Output: 4

Explanation:
•	The possible combinations to make the amount 5 are:
	1.	1+1+1+1+1
	2.	1+1+1+2
	3.	1+2+2
	4.	5
•	Hence, the function should return 4.
 */
public class CoinChangeCombinations {

    public static int coinChangeCombinations(List<Integer> coins, int amount) {
        // Create a dp list with size amount + 1, initialized to 0
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= amount; i++) {
            dp.add(0);
        }
        // There's exactly one way to make amount 0: using no coins
        dp.set(0, 1);

        // Iterate over each coin
        for (int coin : coins) {
            // Update the dp list for each amount from coin to amount
            for (int i = coin; i <= amount; i++) {
                dp.set(i, dp.get(i) + dp.get(i - coin));
            }
        }

        // Return the number of combinations to make the given amount
        return dp.get(amount);
    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 2, 5);
        int amount = 5;
        System.out.println(coinChangeCombinations(coins, amount)); // Output: 4
    }
}