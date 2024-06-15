Explanation

    Project Class:
        A simple helper class to store each project's capital requirement and profit.

    MaxHeap Class:
        Uses a PriorityQueue in reverse order to simulate a max heap.
        Provides methods to push and pop elements and check if the heap is empty.

    findMaximizedCapital Method:
        Converts the profits and capital arrays into a list of Project objects.
        Sorts the projects based on their capital requirements.
        Iterates up to kk times to pick projects:
            Adds all projects that can be started with the current capital to the max heap.
            If the heap is empty, it breaks early as no more projects can be started.
            Picks the most profitable project from the heap and updates the capital.

    main Method:
        Contains test cases to verify the implementation.

Complexity

    Time Complexity: O(nlog⁡n+klog⁡n)O(nlogn+klogn) due to sorting the projects and performing heap operations, where nn is the number of projects.
    Space Complexity: O(n)O(n) due to the heap and sorted projects list.
