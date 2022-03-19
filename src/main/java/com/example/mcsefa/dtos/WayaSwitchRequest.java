package com.example.mcsefa.dtos;

public class WayaSwitchRequest {

    private String sessionId;
    private int channelCode;
    private String phoneNumber;
    private String instructingFinancialInstitutionCode;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstructingFinancialInstitutionCode() {
        return instructingFinancialInstitutionCode;
    }

    public void setInstructingFinancialInstitutionCode(String instructingFinancialInstitutionCode) {
        this.instructingFinancialInstitutionCode = instructingFinancialInstitutionCode;
    }
}
