package com.example.mcsefa.dtos;

public class FinancialInstution {
    private boolean bank;
    private String centralBankCode;
    private String city;
    private boolean connectedToWaya;
    private String financialInstitutionId;
    private String financialInstitutionName;
    private String wayaConnectUrl;

    public boolean isBank() {
        return bank;
    }

    public void setBank(boolean bank) {
        this.bank = bank;
    }

    public String getCentralBankCode() {
        return centralBankCode;
    }

    public void setCentralBankCode(String centralBankCode) {
        this.centralBankCode = centralBankCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isConnectedToWaya() {
        return connectedToWaya;
    }

    public void setConnectedToWaya(boolean connectedToWaya) {
        this.connectedToWaya = connectedToWaya;
    }

    public String getFinancialInstitutionId() {
        return financialInstitutionId;
    }

    public void setFinancialInstitutionId(String financialInstitutionId) {
        this.financialInstitutionId = financialInstitutionId;
    }

    public String getFinancialInstitutionName() {
        return financialInstitutionName;
    }

    public void setFinancialInstitutionName(String financialInstitutionName) {
        this.financialInstitutionName = financialInstitutionName;
    }

    public String getWayaConnectUrl() {
        return wayaConnectUrl;
    }

    public void setWayaConnectUrl(String wayaConnectUrl) {
        this.wayaConnectUrl = wayaConnectUrl;
    }
}
