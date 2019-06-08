package com.naor.flightapp.inter;

import java.io.Serializable;

public class CheckinRequest implements Serializable {
    final private Integer dest;
    final private String bag;

    public CheckinRequest(Integer dest, String bag) {
        this.dest = dest;
        this.bag = bag;
    }

    public Integer getDest() {
        return dest;
    }

    public String getBag() {
        return bag;
    }
}
