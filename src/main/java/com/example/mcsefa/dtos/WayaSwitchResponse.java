package com.example.mcsefa.dtos;

public class WayaSwitchResponse {

    private String sessionId;

    private int channelCode;

    private int accountNumber;

    private int bankVerificationNumber;

    private String accountName;

    private int kycLevel;

    private String responseCode;

    public WayaSwitchResponse() {
    }

    public WayaSwitchResponse(String sessionId, int channelCode, String responseCode) {
        this.sessionId = sessionId;
        this.channelCode = channelCode;
        this.responseCode = responseCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(int channelCode) {
        this.channelCode = channelCode;
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

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
