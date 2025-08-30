class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        
        // Step 1: Initialize parent pointers
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);
            }
        }

        // Step 2: Union emails in same account
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                union(parent, firstEmail, account.get(i));
            }
        }

        // Step 3: Group emails by root parent
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.putIfAbsent(root, new TreeSet<>());
            unions.get(root).add(email);
        }

        // Step 4: Build result
        List<List<String>> res = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));
            merged.addAll(unions.get(root));
            res.add(merged);
        }

        return res;
    }

    private String find(Map<String, String> parent, String s) {
        if (!parent.get(s).equals(s)) {
            parent.put(s, find(parent, parent.get(s)));
        }
        return parent.get(s);
    }

    private void union(Map<String, String> parent, String a, String b) {
        String pa = find(parent, a);
        String pb = find(parent, b);
        if (!pa.equals(pb)) {
            parent.put(pa, pb);
        }
    }
}