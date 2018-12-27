package com.barath.app.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.validation.Valid;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.entity.Bank;
import com.barath.app.service.BankService;

@CrossOrigin("*")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BankController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final BankService BankService;

    public BankController(BankService BankService) {
        this.BankService = BankService;
    }

    @PostMapping(value="/bank",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Bank saveBank(@RequestBody @Valid Bank bank){
        if(logger.isInfoEnabled()) { logger.info("creating new bank {}",Objects.toString(bank)); }
        return this.BankService.createBank(bank);
    }


    @GetMapping(value="/bank/{bankId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Bank getBank(@PathVariable Long bankId){
        if(logger.isInfoEnabled()) { logger.info("finding bank with bankId {}",bankId); }
        return this.BankService.getBank(bankId);
    }

    @GetMapping(value="/banks")
    public List<Bank> getBanks(){
        if(logger.isInfoEnabled()) { logger.info("retrieving all banks"); }
        return this.BankService.getBanks();
    }
}
