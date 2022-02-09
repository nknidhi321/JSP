// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1/#

    Definition :-
    ----------
    Celebrity kisi ko nahi janta (0)
    Celebrity ko sab jaante hai (1)
    
    
    Observation :-
    -----------
    1)  Ek se zyada celebrity nahi ho saktey. Why ??
        
        Suppose 2 celebrity hai, mtlb celebrity v ek dusre ko jante honge
        Par celebrity ki definition he ye hai ki celebrity kisi ko nahi jante,
        toh wo ek dusre ko kaise jaan saktey hai, violating rule.
        Hence, there cannot be more than 1 celebrity.
        
    2)  There can be 0 celebrity, atleast koi ek banda hai jo celebrity ko nahi jaanta

    
    Intuition :-
    ---------
    
    Elimination game khelo, kon kon celebrity nahi ho sakta.
    At last stack will consist of only 1 potential celebrity.
    
    Sabko stack me daalo, top se 2 jan ko pop karo(say a & b), a se poocho kya tum b ko jantey ho ?
    If yes, b can be the potential celebrity, put b back to stack.
    If no, b can never be celebrity, put a back to stack.
    
    At last, jo v bachega, uske row & column pe jaake check kar lo
    ki wo potential celebrity, actual celebrity hai ya nahi ?


// Using Stack 

class Solution { 
 
    int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) { // Push everyone in stack, sab potentialCelebrity hai
            stack.push(i);
        }
        
        while(stack.size() != 1) { // Tab tak check karo jab tak sirf 1 potentialCelebrity nahi bach jaata
            int a = stack.pop();
            int b = stack.pop();
            
            if(M[a][b] == 1) stack.push(b); // a knows b => a cannot be potentialCelebrity where b is still potential celebrity
            if(M[a][b] == 0) stack.push(a); // a do not know b => b cannot be potentialCelebrity where a is still potential celebrity
        }
        
        // Ab sirf 1 potentialCelebrity bacha hai, uske row and column pe jaake check kar lo
        // If it is actually a Celebrity or not ??
 
        int pC = stack.pop(); // pC => potentialCelebrity
        
        /* 
           Conditions for potentialCelebrity to be actual celebrity :-
             1) Check columns, saara 0 hona chahiye 
             2) Check rows, saare 1 hone chahiye except diagonal crossing cell
        */
        for(int idx = 0; idx < n; idx++) {
            if((M[pC][idx] != 0) || (idx != pC && M[idx][pC] != 1)) {
                return -1; // potentialCelebrity actual celebrity nahi tha
            }
        }
        
        return pC; // potentialCelebrity he actual celebrity tha
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
