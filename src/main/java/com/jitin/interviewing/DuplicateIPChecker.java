package com.jitin.interviewing;

import java.util.*;

public class DuplicateIPChecker {

    public static void findDuplicateUser(Map<String, List<String>> userIPs) {
        Map<Set<String>, String> seenIPSets = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : userIPs.entrySet()) {
            String username = entry.getKey();
            List<String> ips = entry.getValue();
            Set<String> ipSet = new HashSet<>(ips); // Normalize the IP list

            if (seenIPSets.containsKey(ipSet)) {
                String previousUser = seenIPSets.get(ipSet);
                System.out.println("Duplicate IP set found between users: " + previousUser + " and " + username);
                return;
            } else {
                seenIPSets.put(ipSet, username);
            }
        }

        System.out.println("No duplicate IP sets found.");
    }

    

    public static void main(String[] args) {
        Map<String, List<String>> users = new HashMap<>();
        users.put("mike", Arrays.asList("203.0.3.10", "208.51.0.5", "52.0.2.5"));
        users.put("bob", Arrays.asList("111.0.0.10", "222.0.0.5", "222.0.0.8"));
        users.put("bob2", Arrays.asList("222.0.0.5", "222.0.0.8", "111.0.0.10")); // Same as bob

        findDuplicateUser(users);
    }
}
