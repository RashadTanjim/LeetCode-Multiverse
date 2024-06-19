class Solution:
    def getNumOfBouquets(self, bloomDay, mid, k):
        numOfBouquets = 0
        count = 0

        for day in bloomDay:
            if day <= mid:
                count += 1
            else:
                count = 0

            if count == k:
                numOfBouquets += 1
                count = 0

        return numOfBouquets

    def minDays(self, bloomDay, m, k):
        if len(bloomDay) < m * k:
            return -1

        start = 0
        end = max(bloomDay)
        minDays = -1

        while start <= end:
            mid = (start + end) // 2

            if self.getNumOfBouquets(bloomDay, mid, k) >= m:
                minDays = mid
                end = mid - 1
            else:
                start = mid + 1

        return minDays