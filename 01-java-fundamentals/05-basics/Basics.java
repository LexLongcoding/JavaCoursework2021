import java.util.ArrayList;
import java.util.Arrays;
public class Basics {
	public static void main(String[] args) {
		int[] nums = {23,234,2345,-23,42};
		LoopArray(nums);
		MaxMinAverage(nums);
		System.out.println(GetArraySum(nums));
			
	}
	// Print 1-255
	public void OneTo255() {
		for(int i = 0; i <= 255; i++)
			System.out.println(i);
	}
	//	Print odd numbers between 1-255
	public void PrintOdds() {
		for(int i = 0; i <= 255; i++) {
			if(i % 2 == 1)
				System.out.println(i);
		}
	}
	public int GetArraySum(int[] numbers) {
		int sum = 0;
		for(int i = 0; i < numbers.length; i++) {
			sum += numbers[i];			
		}
		return sum;
	}
	//	Print Sum
	public static void PrintSum() { 
		int sum = 0;
		for(int i = 0; i <= 255; i++) {
			sum += 0;
			System.out.println(String.format("New number: %d, Sum: %d", i, sum));
		}
	}
	// Iterating through an array
	public void LoopArray(int[] arr) {
		for(int val: arr)
			System.out.println(val);
	}
	// Find Max
	public int FindMax(int[] arr) {
        int max = -1000;
        for(int i: arr){
            if(i > max){
                max = i;
            }
        }
        System.out.println(max);
		return max;
    }
	// Get Average
	public double GetAverage(int[] nums) {
		int sum = GetArraySum(nums);
		double avg =(double)sum/nums.length;
		System.out.println(String.format("Sum: %d, Average: %f", sum, avg));
		return avg;
	}
	// Array with Odd Numbers
	public ArrayList<Integer> OddArray() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i <= 255; i++) {
			if(i % 2 != 0)
				nums.add(i);
		}
		System.out.println(nums);
		return nums;
		
	}

	// Greater Than Y
	public int GreaterThanY(int[] arr, int y) {
		int count = 0;
		for(int num: arr) {
			if(num > y)
				count++;
		}
		System.out.println(count);
		return count;
	}
	// Square the values
	public int[] SquareArray(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];	
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	// Eliminate Negative Numbers
	public  int[] EliminateNegatives(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < 0)
				nums[i] = 0;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	public int FindMin(int[] arr) {
		int currMin = Integer.MAX_VALUE;
		for(int val: arr){
			if(val < currMin)
				currMin = val;
		}
		return currMin;
	}
	// Max, Min, and Average
	public void MaxMinAverage(int[] nums) {
		int min = FindMin(nums);
		int max = FindMax(nums);
		double avg = GetAverage(nums);
		System.out.println(String.format("Max: %d, Min: %d, Average: %f", max, min, avg));
	}
	// Shifting the Values in the Array
	public  void ShiftArrayValues(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = 0;
		System.out.println(Arrays.toString(arr));
	}
}
