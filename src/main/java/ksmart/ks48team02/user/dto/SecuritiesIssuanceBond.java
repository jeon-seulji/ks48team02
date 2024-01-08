package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SecuritiesIssuanceBond {
    private String securitiesIssuanceBondCode;
    private String memberId;
    private String investmentCode;
    private String interestRate;
    private int investMinCost;
    private int bondPrice;
    private String securitiesClassification;
    private int maturity;
    private String subscriptionAllocationRanking;
    private String bondType;
    private LocalDateTime subscriptionDate;
    private LocalDateTime subscriptionDeadline;
    private LocalDateTime maturityDate;
    private LocalDateTime estimatedIssueDate;
    private LocalDateTime allocationConfirmationDate;
    private LocalDateTime paymentDate;
    private int accountToBeIssued;
}
