Asc. Order :-
     Pass (a,b) {
          if(a - b > 0) return 1 => a > b
     }

------------------------------------------

Dsc. Order :-
     Pass (a,b) {
          if(b - a > 0) return 1 => b > a
     }

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


floor     <=        data      <       ceil
     Lower bound           upperbound



NOTE : In BS always think for of target && and not for arr[mid]
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

Since answer can be very large, return your answer mod 10^9+7
public static int mod = (int)(1e9 + 7);
  
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  
10^9 operations -> 1 sec
Array size at max can be 10^7
Never convert LL question in array and try to solve because LL constraint can be greater that 10^7, mostly constraint will be 10^9
Never solve LL question using recursion unless asked, because recursion stacks size is 10^4, and LL constraint is 10^9, always try solving iteratively 
LL k question ko hamesha pehle bich k situation ko socho, itna kaam ho gaya hai ab kaise move karna hai, it will create your insight
List ko toro maroroge toh sahi kar he return krna, interviewer expect this atleast

String is made as final thats why it is immutable [Can be initialized only once in its life cycle]
StringBuilder is internally built on ArrayList

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

ArrayDeque && LinkedList :-
------------------------

ArrayDeque and LinkedList both are exactly same its just that ArrayDeque is based on array and LinkedList is based on LinkedList
ArrayDeque has certain limits only upto 10^7 size, but LinkedList can grow until there is enough space to make a node.
but ArrayDeque needs contiguous memory. So, ArrayDeque has some space constrains, but it is faster than LL
Apart from space whereEver necessary use ArrayDeque instead of LinkedList, since ArrayDequeu is fatser than LL

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX


Difference between :   next()   ||    nextLine()   ||   nextInt() 
-----------------------------------------------------------------
  
Behaviour :-
---------
next() -> reads till it encounters a space
nextLine() -> reads till it encounters a new line [ NOTE : Its new line -> enter button and not space ]
nextInt() -> reads an integer


In the below section of code :-
----------------------------
int val = sc.nextInt();
String s = sc.nextLine();
System.out.println(val);
System.out.println(s);
System.out.println("Length of s : " + s.length());

                                                                                                          
Example 1)  
---------
                                                     
i/p :-
---
10 
hello

o/p :-
---
10

Length of s : 1

Observation :-
-----------                                                   
In cosole if you give an integer(say 10) then "enter" and then a string(say hello) then 
The integer would be read in val(10) and s will read a new line( ) and not the string hello Why ?? 
                                                     
Because job of nextLine() is to read until it finds a new line
So after feeding 10, the enter which you hit, nextLine starts reading from that enter you had hit. 
And in the very first time it encouters an enter, that's it job of nextLine() is done [ And theres no other nextLine() in the code to read that hello input ]
                                                     
Also note size of newLine is 1 obviously because new Line(enter) is a char
                                                     
--------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                     
Example 2)
----------
                                                     
i/p :-                                                 
10 hello

o/p :-
----
10
 hello
Length of s : 6
                                                     
Observation :-
-----------                                                   
In cosole if you give an integer(say 10) then "space" and then a string(say hello) then 
The integer would be read in val(10) and s will read a space + hello [Observe the space in the o/p before hello getting printed]  Why ??

Because job of nextLine() is to read until it finds a new line
So after feeding 10, the space which you hit, nextLine starts reading from that space you had hit till it finds a new line
So it reads space + hello in s

Also note size of s is 6 => space + hello => 1 + 5 => 6       

  
-----------------------------------------------------------------------------------------------------------------------------------------------------------

  
Correct format of code if you want to feed every input in new line :-
------------------------------------------------------------------

int val = sc.nextInt();
sc.nextLine();
String s = sc.nextLine();
System.out.println(val);
System.out.println(s);
System.out.println("Length of s : " + s.length());

                                                     
i/p :-
---
10 
hello

o/p :-
---
10
hello
Length of s : 5
  
Observation :-
-----------
Give one extra nextLine() in your code for that enter which you hit after 10
  
  
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

NOTE : While solving stack questions, add -1 in stack and instead of !isEmpty() check, just make != -1 check, works in most of the problem, use accordingly.
  
  
Stack adapter using SinglyLL :-
----------------------------
  
If you are using LL in the form of Stack always remember to push pop from head.
Add new node to the head [left of the stack node chain, pointing to right]
Because when you pop the last added element that is the head,
Since, stack is LIFO, so when you pop an element simply move to head.next that is push pop in O(1)

Suppose if you do push pop from tail then,
When you add the new node to the last(tail) then push is O(1) && pop is O(N). Why ?
Because, if you delete the tail your element will be popped for sure O(1) but
now how will you move to the previous element, to maintain your tail, if it would be a singly LL ?
Since theres no prev ptr which points to the prev node in singly LL, 
Hence, you will again have to travel from head till the last node just to maintain your tail. So, O(N)

  
--------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  
Queue adapter using SinglyLL :-
----------------------------  

Add nodes to the right hand side of the chain, tail pe offer karo, head se poll karo
Reason khud smjh jaao like above.
  
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
