class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int n = products.length;
        String prefix = "";
        
        for (char ch : searchWord.toCharArray()) {
            prefix += ch;
            List<String> suggestions = new ArrayList<>();

            int start = lowerBound(products, prefix);

            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            result.add(suggestions);
        }

        return result;
    }

    private int lowerBound(String[] products, String prefix) {
        int low = 0, high = products.length;

        while (low < high) {
            int mid = (low + high) >> 1;

            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}