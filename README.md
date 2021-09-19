# tree_implementation
Project made for Algorithm and Data Structures University course. The assignment was to implement 3 different Tree type data structures(Binary Search Tree, Red Black Tree and AVL Tree) and compare the execution times of the two main functions: insert and search on increasing inputs.
The results were as expected, in the average situation all three tree types had a logarithmic trend. Not surprising for the AVL Tree and the Red Black Tree because they have a balancing operation. 
The Binary Search Tree also had a logarithmic trend but that was caused by the random generation of new nodes.
Then we used the worst case scenario (new nodes were added with ascending values) to show that the BST's worst case trend is linear while the other two Tree data structures maintain a logarithmic trend (because the balancing operation).
