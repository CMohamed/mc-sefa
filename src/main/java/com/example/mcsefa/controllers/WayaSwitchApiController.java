package com.example.mcsefa.controllers;

import com.example.mcsefa.dtos.FinancialInstution;
import com.example.mcsefa.dtos.WayaSwitchRequest;
import com.example.mcsefa.dtos.WayaSwitchResponse;
import com.example.mcsefa.entities.Customer;
import com.example.mcsefa.services.CustomerService;
import com.example.mcsefa.services.WayaSwitchApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WayaSwitchApiController {

    private final WayaSwitchApiService wayaSwitchApiService;

    public WayaSwitchApiController(WayaSwitchApiService wayaSwitchApiService) {
        this.wayaSwitchApiService = wayaSwitchApiService;
    }

    // 1
    @PostMapping("/bankA/customer/account/enquiry")
    public ResponseEntity<WayaSwitchResponse> postDataToWayaSwitchApi(@RequestBody WayaSwitchRequest wayaSwitchRequest) {
        WayaSwitchResponse res = wayaSwitchApiService.postDataToWayaSwitch(wayaSwitchRequest);
        return ResponseEntity.ok(res);
    }

    //2
    @PostMapping("/bankB/customer/account/enquiry")
    public ResponseEntity<WayaSwitchResponse> filterAndReturn(@RequestBody WayaSwitchRequest wayaSwitchRequest) {
        WayaSwitchResponse res = wayaSwitchApiService.filterAndReturn(wayaSwitchRequest);
        return ResponseEntity.ok(res);
    }



    @GetMapping("/list/financial/institutions")
    public ResponseEntity<List<FinancialInstution>> getFI() throws JsonProcessingException {
        List<FinancialInstution> res = wayaSwitchApiService.getFinancialInstitutions();
        return ResponseEntity.ok(res);
    }

}
