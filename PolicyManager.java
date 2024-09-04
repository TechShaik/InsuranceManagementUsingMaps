package com.InsurancePolicyManagementSystem_maps;
import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Map<String, Policy> policyMap;
    private LinkedHashMap<String, Policy> linkedPolicyMap;
    private TreeMap<LocalDate, Policy> treePolicyMap;

    public PolicyManager() {
        policyMap = new HashMap<>();
        linkedPolicyMap = new LinkedHashMap<>();
        treePolicyMap = new TreeMap<>();
    }

    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        linkedPolicyMap.put(policy.getPolicyNumber(), policy);
        treePolicyMap.put(policy.getExpiryDate(), policy);
    }
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);
        return new ArrayList<>(treePolicyMap.subMap(today, thirtyDaysFromNow).values());
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String policyHolderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                policies.add(policy);
            }
        } return policies;
    }

    // Remove policies that are expired
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        treePolicyMap.headMap(today).clear();
        // Sync removal with other maps
        for (Iterator<Map.Entry<String, Policy>> it = policyMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Policy> entry = it.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                it.remove();
                linkedPolicyMap.remove(entry.getKey());
            }
        }
    }
}
