package com.example.mcsefa.services;

import com.example.mcsefa.dtos.FinancialInstution;
import com.example.mcsefa.dtos.WayaSwitchRequest;
import com.example.mcsefa.dtos.WayaSwitchResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WayaSwitchApiService {

    private final String WAYA_SWITCH_BASE_URL = "http://18.117.154.75:8090/";
    private final String CUSTOMER_ACCOUNT_ENQUIRY = "/cutomer/account/enquiery";
    private final String FINANCIAL_INSTUTIONS = "/list/financial/institutions";


    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType COLLECTION_TYPE = mapper.getTypeFactory().constructCollectionType(List.class, FinancialInstution.class);

    // 1: localhost:8080/bankA/customer/account/enquiry
    public WayaSwitchResponse postDataToWayaSwitch(WayaSwitchRequest wayaSwitchRequest) {
        HttpEntity<WayaSwitchRequest> request = new HttpEntity<>(wayaSwitchRequest);
        ResponseEntity<WayaSwitchResponse> response = restTemplate
                .exchange(WAYA_SWITCH_BASE_URL + CUSTOMER_ACCOUNT_ENQUIRY, HttpMethod.POST, request, WayaSwitchResponse.class);
        WayaSwitchResponse wayaSwitchResponse = response.getBody();
        return wayaSwitchResponse;
    }



    public List<FinancialInstution> getFinancialInstitutions() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate
                .getForEntity(WAYA_SWITCH_BASE_URL + FINANCIAL_INSTUTIONS, String.class);
        return mapper.readValue(response.getBody(), COLLECTION_TYPE);
    }
}
