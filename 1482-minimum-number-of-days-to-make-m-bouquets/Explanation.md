Explanation of the Python based Solution:

    Helper Function: getNumOfBouquets
        This function calculates how many bouquets can be made if the flowers bloom by day mid.
        It iterates through the bloomDay array and counts the number of consecutive flowers that have bloomed by mid.
        If count (consecutive bloomed flowers) reaches k, a bouquet is formed, numOfBouquets is incremented, and count is reset to 0.

    Main Function: minDays
        Checks if it is possible to form m bouquets. If the total number of flowers is less than m * k, it returns -1.
        Initializes start and end to define the range of days to search. start is set to 0 and end is set to the maximum value in bloomDay.
        Performs a binary search within this range to find the minimum number of days required to form m bouquets.
        In each iteration of the binary search:
            mid is calculated as the average of start and end.
            getNumOfBouquets is called to determine the number of bouquets that can be made by day mid.
            If the number of bouquets is greater than or equal to m, it means it's possible to make the required bouquets in mid days or fewer, so minDays is updated to mid and end is moved to mid - 1 to search for a smaller possible day.
            If the number of bouquets is less than m, it means more days are needed, so start is moved to mid + 1.

    Return Result
        After exiting the loop, minDays holds the minimum number of days required to make m bouquets. If it's not possible to form the bouquets, minDays will remain -1, and that value is returned.

This solution uses binary search to efficiently find the minimum number of days required to make the desired number of bouquets, leveraging the counting technique in the helper function.
