package com.sedykh.union_find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of accounts where each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name, and the rest of the elements
 * are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person
 * if there is some common email to both accounts. Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name. A person can have
 * any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element
 * of each account is the name, and the rest of the elements are emails in sorted order.
 * The accounts themselves can be returned in any order.
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());
        HashMap<String, Integer> emailsToAccountIds = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                Integer accountId = emailsToAccountIds.get(email);
                if (accountId == null) {
                    emailsToAccountIds.put(email, i);
                } else {
                    unionFind.union(accountId, i);
                }
            }
        }
        var result = new ArrayList<List<String>>();
        var merged = new HashMap<Integer, List<String>>();
        emailsToAccountIds.forEach((email, accountId) -> {
            int newAccountId = unionFind.find(accountId);
            var emails = merged.getOrDefault(newAccountId, new ArrayList<>());
            emails.add(email);
            merged.put(newAccountId, emails);
        });
        merged.forEach((accountId, emails) -> {
            var mergedAccount = new ArrayList<String>();
            mergedAccount.add(accounts.get(accountId).get(0));
            Collections.sort(emails);
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        });
        return result;
    }

    private static class UnionFind {

        private final Map<Integer, Integer> parents = new HashMap<>();
        private final Map<Integer, Integer> ranks = new HashMap<>();

        public UnionFind(int n) {
            for (int i = 0; i < n; i++) {
                parents.put(i, i);
                ranks.put(i, 0);
            }
        }

        private int find(int n) {
            int p = parents.get(n);
            while (p != parents.get(p)) {
                parents.put(n, parents.get(p));
                p = parents.get(p);
            }
            return p;
        }

        private boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                return false;
            }
            int rankA = ranks.get(parentA);
            int rankB = ranks.get(parentB);
            if (rankA > rankB) {
                parents.put(parentB, parentA);
            } else if (rankA < rankB) {
                parents.put(parentA, parentB);
            } else {
                parents.put(parentA, parentB);
                ranks.put(parentB, ranks.get(parentB) + 1);
            }
            return true;
        }
    }
}
