import java.util.*;

public class Puzzling {
    //Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. 
    //Also have the function return an array that only includes numbers that are greater than 10 
    //(e.g. when you pass the array above, it should return an array with the values of 13,25,32)
    public ArrayList<Integer> OverTen(int[] arr){
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for (int i=0; i < arr.length; i++){
            sum+= arr[i];
            if(arr[i] > 10){
                newArr.add(arr[i]);
                
            }
        }
        System.out.print("sum = " + sum);
        return newArr;
    }
    //Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. 
    //Shuffle the array and print the name of each person. 
    public ArrayList<String> Names(ArrayList<String> arr){
        Collections.shuffle(arr);
        return arr;
    }
    //Create an array that contains all 26 letters of the alphabet (this array must have 26 values). 
    //Shuffle the array and, after shuffling, display the last letter from the array. 
    //Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.
    public void Vowels(){
        ArrayList<String> alphabet = new ArrayList<String>();
        for(char ch = 'a'; ch <= 'z'; ++ch){
            alphabet.add(Character.toString(ch));
        }
        System.out.println(alphabet);
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println(String.format("First letter: %s", alphabet.get(0)));
        System.out.println(String.format("Last letter: %s", alphabet.get(25)));
        // did not create this vowel solution myself but it's the simplest / easiest to understand for me. 
        if(alphabet.get(0).equals("a") || alphabet.get(0).equals("e")  || alphabet.get(0).equals("i")  || alphabet.get(0).equals("o")  || alphabet.get(0).equals("u") ){
            System.out.println("First letter is a vowel!");
        }
    }
    // Generate and return an array with 10 random numbers between 55-100
    //have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array.
    // Next, display the minimum value in the array as well as the maximum value.
    public int[] RandomIntArray(int lowerBound, int upperBound) {
        int[] arr = new int[10];
        int offset = upperBound - lowerBound;
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(offset) + lowerBound;
        }
        int max = -1000;
        for(int i: arr){
            if(i > max){
                max = i;
            }
        }
        int min = 1000;
        for(int val: arr){
            if(val < min){
                min = val;
            }
        }
        Arrays.sort(arr);
        System.out.println(min);
        System.out.println(max);
        return arr; 
    }
    // Create a random string that is 5 characters long.
    public String RandomString(){
        ArrayList<String> arr = new ArrayList<String>();
        for(char ch = 'a'; ch <= 'z'; ++ch){
            arr.add(Character.toString(ch));
        }
        String randomWord = "";
        for (int i = 0; i < 5; i++){
            Collections.shuffle(arr);
            randomWord += arr.get(0);
        }
        return randomWord;
    }
    //Generate an array with 10 random strings that are each 5 characters lon
    public String[] RandomStringArr() { 
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = RandomString();
        }
        return arr;
    }
}
