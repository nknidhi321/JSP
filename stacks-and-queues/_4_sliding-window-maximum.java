// https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/#
// https://nados.io/question/sliding-window-maximum?zen=true

// Brute Force  // TLE

class Solution {
    static ArrayList < Integer > max_of_subarrays(int arr[], int n, int k) {
        ArrayList < Integer > list = new ArrayList < > ();
        for (int sp = 0; sp <= n - k; sp++) { // sp => startingPoint
            int max = Integer.MIN_VALUE;
            for (int win = sp; win < sp + k; win++) { // Har k size k window me check karo
                max = Math.max(max, arr[win]);
            }
            list.add(max);
        }
        return list;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// Using stack


