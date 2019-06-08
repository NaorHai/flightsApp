package com.naor.flightapp.service;

import com.naor.flightapp.ext.CouponResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

@Service
public class CouponService {
    private final double[] DISCOUNT = {0.1, 0.5, 0.6};
    private final HashSet<Integer> COUPONS = new HashSet<>(Arrays.asList(1, 2, 3));

    public CouponResponse checkCoupon(int couponId, double price) {
        String msg = "Coupon not valid!";
        if (isCouponValid(couponId)) {
            msg = "Success!";
            price = applyDiscount(price);
        }
        return new CouponResponse(msg, price);
    }

    private double applyDiscount(double price) {
        Random r = new Random();
        int low = 0;
        int high = 2;
        int result = r.nextInt(high - low) + low;
        return price * DISCOUNT[result];
    }

    private boolean isCouponValid(int couponId) {
        return COUPONS.contains(couponId);
    }
}
