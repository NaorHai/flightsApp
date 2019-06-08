package com.naor.flightapp.controller;

import com.naor.flightapp.ext.CouponResponse;
import com.naor.flightapp.inter.CheckinRequest;
import com.naor.flightapp.service.CheckInService;
import com.naor.flightapp.service.CouponService;
import com.naor.flightapp.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class Controller {

    private final TicketsService ticketsService;
    private final CouponService couponService;
    private final CheckInService checkInService;

    @Autowired
    public Controller(TicketsService ticketsService,
                      CouponService couponService,
                      CheckInService checkInService) {
        this.ticketsService = ticketsService;
        this.couponService = couponService;
        this.checkInService = checkInService;
    }

    @GetMapping("/ticket/available/{id}")
    public @ResponseBody
    boolean getTicketAvailability(@PathVariable int id) {
        return this.ticketsService.isTicketAvailable(id);
    }

    @PostMapping("/coupon/check")
    public @ResponseBody
    CouponResponse checkCoupon(@RequestBody Integer couponId, @RequestBody Double price) {
        return this.couponService.checkCoupon(couponId, price);
    }

    @PostMapping("/checkin")
    public @ResponseBody
    boolean doCheckin(@RequestBody CheckinRequest checkinRequest) {
        return this.checkInService.doCheckIn(checkinRequest.getDest(),checkinRequest.getBag());
    }


}
