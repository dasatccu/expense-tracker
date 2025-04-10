package org.et.model;

import org.et.util.Currency;
import org.et.util.DateTimeUtils;
import org.et.util.LogService;

import java.util.UUID;

public class Expenses {
    private static final String TAG = "Expenses";

    private UUID uuid;
    private Category category;
    private Currency currency;
    private String date;
    private String time;

    public Expenses(Category category, Currency currency, String time){
        this.uuid = UUID.randomUUID();
        this.category = category;
        this.currency = currency;
        this.date = DateTimeUtils.getNow().getDayOfMonth() + "/" +
                DateTimeUtils.getNow().getMonth() + "/" +
                DateTimeUtils.getNow().getYear();
        this.time = time;

        LogService.info(TAG, "Created new expense: " + this.toString());
    }

    public UUID getUuid() {
        LogService.debug(TAG, "Getting UUID: " + uuid);
        return uuid;
    }

    public Category getCategory() {
        LogService.debug(TAG, "Getting category: " + category.getName());
        return category;
    }

    public Currency getCurrency() {
        LogService.debug(TAG, "Getting currency: " + currency.toString());
        return currency;
    }

    public String getDate() {
        LogService.debug(TAG, "Getting date: " + date);
        return date;
    }

    public String getTime() {
        LogService.debug(TAG, "Getting time: " + time);
        return time;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "uuid=" + uuid +
                ", category=" + (category != null ? category.getName() : "null") +
                ", currency=" + (currency != null ? currency.toString() : "null") +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
