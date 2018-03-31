## Traverse a Tree - Introduction
#### Pre-order Traversal
Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.

#### In-order Traversal
In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.

Typically, for binary search tree, we can retrieve all the data in sorted order using in-order traversal. We will mention that again in another card(Introduction to Data Structure - Binary Search Tree).

#### Post-order Traversal
Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.

It is worth noting that when you delete nodes in a tree, deletion process will be in post-order. That is to say, when you delete a node, you will delete its left child and its right child before you delete the node itself.

Also, post-order is widely use in mathematical expression. It is easier to write a program to parse a post-order expression.

You can easily figure out the original expression using the inorder traversal. However, it is not easy for a program to handle this expression since you have to check the priorities of operations.

If you handle this tree in postorder, you can easily handle the expression using a stack. Each time when you meet a operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.

#### Recursive or Iterative
Try to practice the three different traversal methods in our after-article exercise. You might want to implement the methods recursively or iteratively. Implement both recursion and iteration solutions and compare the differences between them.

##Level-order traversal

Level-order traversal is to traverse the tree level by level.

`Breadth-First Search` is an algorithm to traverse or search in data structures like a tree or a graph. The algorithm starts with a root node and visit the node itself first. Then traverse its neighbors, traverse its second level neighbors, traverse its third level neighbors, so on and so forth.

When we do breadth-first search in a tree, the order of the nodes we visited is in level order.

Typically, we use a queue to help us to do BFS. If you are not so familiar with the queue, you can find more information about that in another card coming soon.



##Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
But the following `[1,2,2,null,3,null,3]` is not:

        1
       / \
      2   2
       \   \
       3    3

Solution:

    Recursively check left and right nodes.
    Input : 
        left - left node,
        right - right node
    Should be true for all of following conditions: 
        - left.val == right.val
        - isSymmetric(left.left, right.right)
        - isSymmetric(left.right, right.left)
    For the root this method call will be like:
        isSymmetric(root, root);
        
    NOTE: Don't forget about null checking.
          If both nodes are null, then return true, else false.

Solved. Accepted

##Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and `sum = 22`,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        
return true, as there exist a root-to-leaf path `5->4->11->2` which sum is 22.

Accepted.

