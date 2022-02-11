10^9 operations -> 1 sec


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
Since there's no prev ptr which points to the prev node in singly LL, 
Hence, you will again have to travel from head till the last node just to maintain your tail. So, O(N)

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
