package com.example.mcsefa.services;

import com.example.mcsefa.dtos.FinancialInstution;
import com.example.mcsefa.dtos.WayaSwitchRequest;
import com.example.mcsefa.dtos.WayaSwitchResponse;
import com.example.mcsefa.entities.Customer;
import com.example.mcsefa.mappers.CustomerMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WayaSwitchApiService {
    private final String WAYA_SWITCH_BASE_URL = "http://18.117.154.75:8090/";
    private final String CUSTOMER_ACCOUNT_ENQUIRY = "/customer/account/enquiry";
    private final String FINANCIAL_INSTUTIONS = "/list/financial/institutions";


    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType COLLECTION_TYPE = mapper.getTypeFactory().constructCollectionType(List.class, FinancialInstution.class);

    private static final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    private final CustomerService customerService;

    public WayaSwitchApiService(CustomerService customerService) {
        this.customerService = customerService;
    }


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

    public WayaSwitchResponse filterAndReturn(WayaSwitchRequest wayaSwitchRequest) {
        // filter DB
        List<Customer> customers = customerService.findAllByPhoneNumber(wayaSwitchRequest.getPhoneNumber());
        if (!customers.isEmpty()) {
            WayaSwitchResponse response = customerMapper.entityToWayaStackResponse(customers.get(0));
            response.setSessionId(wayaSwitchRequest.getSessionId());
            response.setChannelCode(wayaSwitchRequest.getChannelCode());
            response.setResponseCode("1");
            return response;
        }
        return new WayaSwitchResponse(wayaSwitchRequest.getSessionId(), wayaSwitchRequest.getChannelCode(), "0");
    }
}
