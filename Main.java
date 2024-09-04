package com.InsurancePolicyManagementSystem_maps;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager policyManager = new PolicyManager();

        // Add some policies
        policyManager.addPolicy(new Policy("P123", "John Doe", LocalDate.of(2024, 9, 10)));
        policyManager.addPolicy(new Policy("P124", "Jane Doe", LocalDate.of(2024, 8, 30)));
        policyManager.addPolicy(new Policy("P125", "John Smith", LocalDate.of(2024, 10, 5)));

        // Retrieve a policy by its number
        System.out.println(policyManager.getPolicyByNumber("P123"));

        // List all policies expiring within the next 30 days
        System.out.println(policyManager.getPoliciesExpiringSoon());

        // List all policies for a specific policyholder
        System.out.println(policyManager.getPoliciesByHolder("John Doe"));

        // Remove policies that are expired
        policyManager.removeExpiredPolicies();
    }
}
