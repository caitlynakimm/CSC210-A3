# A7 Linked Lists

Your readme should include the following information. **Each student** needs to submit all of this information, even when pair programming. 

## Submission Details

Programming Partner Name (if you are submitting identical code):


Other Collaborators (submitting related but non-identical code):


Kudos/shout-out to particularly helpful members of the class or teaching staff:
- Shoutout to JJ Cham for helping me figure out how to run the tests!

Any references used besides JavaDoc and course materials:
- https://www.geeksforgeeks.org/java/stringbuilder-class-in-java-with-examples/
- https://www.geeksforgeeks.org/dsa/remove-first-node-of-the-linked-list/
- https://www.geeksforgeeks.org/dsa/insert-node-at-the-end-of-a-linked-list/
- https://www.geeksforgeeks.org/java/java-program-to-create-a-singly-linked-list-and-count-the-number-of-nodes/

If you used AI, please describe how and the interaction between AI and your understanding of this assignment and specifically the related data structures and algorithms:
- I understood most of the instructions for the phase 4 methods, but I wasn't quite sure how to implement some concepts such as how to reconnect the rest of a linked list after part of it was extracted or how to refer to this list (that part of the instructions confused me). I used ai to clarify those concepts through visual examples of linked lists changing based on the different methods being called, and I also asked for hints on how to improve my code such as edge cases I didn't think about (ex. list to splice in is equal to original list) or how to simplify my code. 


## Reflection

What do you see as the benefits and downsides of working with linked lists instead of arrays? When might they be most useful versus limiting?
- Some benefits I see from working with linked lists is that I could add, remove, copy, or transfer entire lists or even parts of lists without knowing every index of the elements or the size of the list. I could do this with some pointer changes, compared to inserting elements in arraylists where I have to know every element and their indices to reassign/move them. But, it is easier and faster to access any element in an array since in linked lists you would need to iterate through every node until you find the data you are looking for. It can also get easily confusing reassigning pointers when changing linked lists.

What was the major challenge you faced in completing this assignment?
- I think the major challenge I faced was thinking about all the edge cases/scenarios, especially for the phase 4 methods. I had to think about if the user would leave parameters like list or nodes here, afterHere, and toHere blank, and also if those nodes happened to be the head or tail of the original list and how  that could affect how another list was spliced in, extracted, etc. Thinking about all the different ways a list could change took a very long time. 

What do you feel you learned from this assignment?
- From this assignment I gained a better understanding of how linked lists behave. I learned how to update the head and tail node pointers when I wanted to insert/remove elements or splice in/extract lists, how to reassign what nodes would be the new head or tail, and how to obtain the actual data the nodes contain. I also learned how to create empty linked lists, deep copies of linked lists, and how to transfer nodes from one list to another.

