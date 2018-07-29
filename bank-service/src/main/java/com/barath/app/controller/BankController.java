package com.barath.app.controller;

import com.barath.app.entity.Bank;
import com.barath.app.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/banks")
public class BankController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final BankService BankService;

    public BankController(BankService BankService) {
        this.BankService = BankService;
    }

    @PostMapping(value="/new",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Bank saveBank(@RequestBody  Bank bank){
        if(logger.isInfoEnabled()) { logger.info("creating new bank {}",bank); }
        return this.BankService.createBank(bank);
    }


    @GetMapping(value="/{bankId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Bank getBank(@PathVariable Long bankId){
        if(logger.isInfoEnabled()) { logger.info("finding bank with bankId {}",bankId); }
        return this.BankService.getBank(bankId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Bank> getBanks(){
        if(logger.isInfoEnabled()) { logger.info("retrieving all banks"); }
        return this.BankService.getBanks();
    }
}
