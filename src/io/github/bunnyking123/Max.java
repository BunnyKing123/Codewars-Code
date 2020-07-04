package io.github.bunnyking123;

/*
 * Prompt:
 * 
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 *
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
 * 
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */

// My solution from Codewars
public class Max {
	  public static int sequence(int[] arr) {
	    //Define variables
	    int maxSum = 0;
	    int currentSum = 0;
	    int numNeg = 0;
	    int searchIndex = 0;
	    int itemIndex = 0;
	    
	    //Start by checking if the list contains negative numbers, positive numbers or nothing
	    for (int i:arr) {
	        if (i < 0) {
	            numNeg++;
	        }
	        maxSum = maxSum + i;
	    }
	    if (numNeg == arr.length) {
	        return 0;
	    } else if (numNeg == 0) {
	        return maxSum;
	    }
	    maxSum = 0;
	    
	    //Now check for subarray with largest sum
	    for (int j:arr) {
	        searchIndex = 0;
	        currentSum = j;
	        for (int k:arr) {
	            if(searchIndex > itemIndex) {
	                currentSum = currentSum + k;
	            }
	            if(currentSum > maxSum) {
	                maxSum = currentSum;
	            }
	            searchIndex++;
	        }
	        
	        itemIndex++;
	    }
	    return maxSum;
	  }
	}