##1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

    Given nums = [2, 7, 11, 15], target = 9,
    
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    
#####Solution
I need to get every element and traverse over them one-after-one.

     Example: nums = [2, 7, 11, 15], target = 18,
     Get 2 and run over list of other elements - [7, 11, 15]
        2 + 7 = 9; continue;
        2 + 11 = 13; continue;
        2 + 15 = 17; continue;
     When other elements list will be ended, then repeat same action 
     to other elements, i.e. get 7 and run over list [11, 15]
        7 + 11 = 18; is equals to target => break;
          
     In addition to that I need to instantiate two counters:
        a) for counting separate element (in the result case it is '7').
        b) for counting index of other element in the list 
           (it will be added to the value of the first counter).
           
#####Accepted
Next challenges: 
- 3Sum
- 4SumTwo 
- Sum II - Input array is sorted
- Two Sum III - Data structure design
- Subarray Sum Equals K
- Two Sum IV - Input is a BST