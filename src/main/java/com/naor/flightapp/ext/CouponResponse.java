package com.naor.flightapp.ext;

import java.io.Serializable;

public class CouponResponse implements Serializable {
    final String msg;
    final double price;

    public CouponResponse(String msg, double price) {
        this.msg = msg;
        this.price = price;
    }

    public String getMsg() {
        return msg;
    }

    public double getPrice() {
        return price;
    }
}
