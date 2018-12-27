package com.barath.app.service;


import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.barath.app.entity.Bank;
import com.barath.app.exception.BankNotFoundException;
import com.barath.app.repository.BankRepository;


/**
 * 
 * @author barath
 *
 */
@Service
public class BankService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank createBank(Bank bank){

        return this.bankRepository.save(bank);
    }

    public Bank getBank(Long bankId){

      Optional<Bank> bankOptional= this.bankRepository.findById(bankId);
      bankOptional.orElseThrow(() -> new BankNotFoundException("Bank with bank id "+bankId+" not found"));
      return bankOptional.get();
     
    }

    public List<Bank> getBanks(){

        List<Bank> banks = this.bankRepository.findAll();
        if(logger.isInfoEnabled()){
            banks.forEach(bank -> logger.info(Objects.toString(bank)));
        }
        return banks;
    }



    @PostConstruct
    public void init(){

        Bank bank1 = new Bank(1L,"ICICI BANK");
        Bank bank2 = new Bank(2L,"HDFC BANK");
        Bank bank3 = new Bank(3L,"IDBC BANK");
        Bank bank4 = new Bank(4L,"SBI BANK");
        Bank bank5 = new Bank(5L,"PUNJAB BANK");
        Bank bank6 = new Bank(6L,"KODAK BANK");
        Bank bank7 = new Bank(7L,"INDIAN BANK");
        Bank bank8 = new Bank(7L,"INDIAN OVERSEAS BANK");
        Arrays.asList(bank1,bank2,bank3,bank4,bank5,bank6,bank7,bank8)
                .forEach(this::createBank);

    }
}
