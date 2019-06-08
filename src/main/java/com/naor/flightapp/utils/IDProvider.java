package com.naor.flightapp.utils;

public class IDProvider {
    private static int ticketId = 0;
    private static int bagId = 0;

    public static int getNewTicketId() {
        return ++ticketId;
    }
    public static String getNewBagId() {
        return "Bag: " + ++bagId;
    }

}
