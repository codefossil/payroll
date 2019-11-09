package com.gcaraciolo.payroll.domain;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class UnionAffiliation implements Affiliation {

    private Double dues;
    private Map<String, ServiceCharge> servicecharges = new HashMap<String, ServiceCharge>();

    public UnionAffiliation(Double dues) {
        this.dues = dues;
    }

    public ServiceCharge getServiceCharge(long date) {
        return servicecharges.get(Long.toString(date));
    }

    public ServiceCharge addServiceCharge(long date, double amount) {
        var sc = new ServiceCharge(date, amount);
        servicecharges.put(Long.toString(date), sc);
        return sc;
    }
}