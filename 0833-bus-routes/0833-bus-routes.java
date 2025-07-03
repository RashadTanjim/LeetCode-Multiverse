class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        for (int bus : stopToBuses.getOrDefault(source, new ArrayList<>())) {
            queue.offer(bus);
            visitedBuses.add(bus);
        }

        int busesTaken = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int bus = queue.poll();

                for (int stop : routes[bus]) {
                    if (stop == target)
                        return busesTaken;

                    if (visitedStops.contains(stop))
                        continue;
                    visitedStops.add(stop);

                    for (int nextBus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                        if (!visitedBuses.contains(nextBus)) {
                            visitedBuses.add(nextBus);
                            queue.offer(nextBus);
                        }
                    }
                }
            }

            busesTaken++;
        }

        return -1;
    }
}