package com.tusos.project.entities;

import javax.persistence.*;
import java.math.BigDecimal;

public class MonetaryObligation {

    private Long obligationID;
    private Student student;
    private Integer month ;
    private ObligationType type;
    private BigDecimal monetaryValue;
    private boolean isPaid;

    public MonetaryObligation(Student student, Integer month, ObligationType type, BigDecimal monetaryValue, boolean isPaid) {
        this.student = student;
        this.month = month;
        this.type = type;
        this.monetaryValue = monetaryValue;
        this.isPaid = isPaid;
    }

    public MonetaryObligation() {
    }

    public Long getObligationID() {
        return obligationID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public ObligationType getType() {
        return type;
    }

    public void setType(ObligationType type) {
        this.type = type;
    }

    public BigDecimal getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(BigDecimal monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
