Explanation:

### Two Pointer Method -> 

    Initialization:
        left starts at 0.
        right is calculated using Math.sqrt(c) to find the largest integer whose square is less than or equal to c.

    Loop to Find Sum of Squares:
        Use a while loop to check if the sum of squares of left and right equals c.
        Convert left * left and right * right to long to prevent overflow.
        If the sum matches c, return true.
        If the sum is less than c, increment left to increase the sum.
        If the sum is greater than c, decrement right to decrease the sum.

    Return False:
        If the loop completes without finding such a pair, return false.

This approach ensures that we properly check all possible pairs (a, b) without causing overflow and accurately determine the values for left and right.
