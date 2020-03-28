package com.akgcloud.java.application;

import java.util.Calendar;
import java.util.Date;

public final class ImmutableReminder {
    private final Date remindingDate;

    public ImmutableReminder(Date remindingDate) {
        if (remindingDate.getTime() < System.currentTimeMillis()) {
            throw new IllegalArgumentException("Can not set reminder" + " for past time: " + remindingDate);
        }
        this.remindingDate = new Date(remindingDate.getTime());
    }

    public Date getRemindingDate() {
        return remindingDate;
    }

    public static void main(String[] args) {
        Date dt = new Date();
        ImmutableReminder ir = new ImmutableReminder(dt);
        System.out.println(ir.getRemindingDate());
        dt.setTime(1000000000);
        System.out.println(ir.getRemindingDate());
    }
}