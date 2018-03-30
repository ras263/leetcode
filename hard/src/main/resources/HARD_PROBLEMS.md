###4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:

    nums1 = [1, 3]
    nums2 = [2]
    
    The median is 2.0

Example 2:

    nums1 = [1, 2]
    nums2 = [3, 4]
    
    The median is (2 + 3)/2 = 2.5
    
    
Solution:

    Working with sizes of arrays. 
    Find the median index (or two) of two arrays.
    Start merging arrays with merge sort from first element
     to median index (or two).
    If index is single return element,
    else - compute and return (a + b) / 2.
    
    
