package com.example.mcsefa.dtos;

public class CustomerDTO {

    private Long id;

    private String name;

    private String phoneNumber;

    private String accountName;

    private int kycLevel;

    private int accountNumber;

    private int bankVerificationNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getKycLevel() {
        return kycLevel;
    }

    public void setKycLevel(int kycLevel) {
        this.kycLevel = kycLevel;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBankVerificationNumber() {
        return bankVerificationNumber;
    }

    public void setBankVerificationNumber(int bankVerificationNumber) {
        this.bankVerificationNumber = bankVerificationNumber;
    }
}
