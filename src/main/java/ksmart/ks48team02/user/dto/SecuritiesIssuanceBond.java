package ksmart.ks48team02.user.dto;

import lombok.Data;

@Data
public class SecuritiesIssuanceBond {
    private String securitiesIssuanceBondCode;
    private String memberId;
    private String investmentCode;
    private String interestRate;
    private String investMinCost;
    private String bondPrice;
    private String securitiesClassification;
    private String maturity;
    private String subscriptionAllocationRanking;
    private String bondType;
    private String subscriptionDate;
    private String subscriptionDeadline;
    private String maturityDate;
    private String estimatedIssueDate;
    private String allocationConfirmationDate;
    private String paymentDate;
    private String accountToBeIssued;
}
