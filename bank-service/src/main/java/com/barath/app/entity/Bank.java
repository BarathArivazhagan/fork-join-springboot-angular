package com.barath.app.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="BANK")
public class Bank implements Serializable {

	private static final long serialVersionUID = 8768069725040187482L;

	@Id
    @Column(name="BANK_ID")
    private Long bankId;

    @Column(name="BANK_NAME")
    @NotEmpty(message="bank name cannot be empty")
    private String bankName;

    public Bank(Long bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Bank() {
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankId=" + bankId +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
