package com.intercom.interview.test.models;

public class Customer extends Record {
    public final String name;
    public final Location location;

    public Customer(long id, String name, Location location) {
        super(id);
        this.name = name;
        this.location = location;
    }

    public enum Fields {
        user_id,
        name,
        latitude,
        longitude
    }
}
