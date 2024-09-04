package com.InsurancePolicyManagementSystem_maps;

import java.time.LocalDate;

public class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

     public String toString() {
        return  
                "PolicyNumber=" + policyNumber + '\n' +
                "PolicyHolderName=" + policyHolderName + '\n' +
                "ExpiryDate=" + expiryDate+"\n";
    }
}
