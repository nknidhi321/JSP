// https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/#
// https://nados.io/question/sliding-window-maximum?zen=true

// Brute Force  // TLE
// Worst case : O(N^2)

class Solution {
    static ArrayList < Integer > max_of_subarrays(int arr[], int n, int win) {
        ArrayList < Integer > list = new ArrayList < > ();
        for (int sp = 0; sp <= n - win; sp++) { // sp => startingPoint
            int max = Integer.MIN_VALUE;
            for (int ep = sp; ep < sp + win; ep++) { // ep => endingPoint
                max = Math.max(max, arr[ep]); // Har k size k window me check karo
            }
            list.add(max);
        }
        return list;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// Using stack // Efficient
// Worst case : O(N^2) jab sbka next greater uske next wala idx ho jaaye
// but somewhat better than brute force.

class Solution {

    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int win) {
        ArrayList <Integer> list = new ArrayList<>();
        int[] ngeIdx = nextGreaterElement(n, arr);
        for(int sp = 0; sp <= n - win; sp++) {
            int ep = sp;
            while(ngeIdx[ep] < sp + win) {
                // Isme ep ek ek kar k nahi, directly apne next greater wale idx pe chala jaaega agar within win hai toh
                // Agar mera next greater mere win se bhr lie krta hai toh hum he max honge apne win k
                // Kuki mere se lekar mere next greater k bich me, saare elements for sure mere se chote he honge, islye mai he max houngi
                ep = ngeIdx[ep]; 
            }
            list.add(arr[ep]);
        }
        return list;
    }
    
    // In terms of idx
    public static int[] nextGreaterElement(int n, int[] arr) {
        int[] ans = new int[n];
        Stack < Integer > stack = new Stack < > ();

        for (int i = arr.length - 1; i >= 0; i--) { // Start from right end, kuki answer bnate waqt easy hoga
            // Agar stack k top pe koi element humse chota exist krta hai toh wo hamara answer kvi nai bn sakta, 
            // Kuki next greater element find karna tha so pop()    
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = n; // Agar pop krte krte stack empty ho gaya mtlb mera next greater n hoga   
            else ans[i] = stack.peek(); // Else agar ab v stack k top pe elements bacha hai then stack ka top mera next greater bnega
            stack.push(i); // Push yourself(idx) because tum apne se piche walo ka answer bn saktey ho 
        }
        return ans;
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
