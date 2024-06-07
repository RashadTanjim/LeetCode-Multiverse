Explanation of the Code:

    -> Ensure nums1 is the smaller array:
        This step ensures that the binary search is done on the smaller array to maintain the complexity of O(log⁡(min(m,n)))O(log(min(m,n))).

    -> Binary Search Initialization:
        Initialize low and high pointers for binary search on nums1.

    -> Binary Search Process:
        While low is less than or equal to high:
            Calculate partitionX and partitionY to divide the arrays into left and right halves.
            Calculate the maximum values in the left partitions (maxX and maxY) and the minimum values in the right partitions (minX and minY).
            If the partitions are correct (maxX <= minY and maxY <= minX):
                If the total number of elements is even, the median is the average of the maximum of the left partitions and the minimum of the right partitions.
                If the total number of elements is odd, the median is the maximum of the left partitions.
            Adjust low and high based on the conditions to move the partitions.

    -> Return the Median:
        The median is returned when the correct partition is found.
        If the input arrays are not sorted or valid, an IllegalArgumentException is thrown.
