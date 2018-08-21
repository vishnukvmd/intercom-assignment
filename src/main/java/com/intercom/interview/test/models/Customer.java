package com.intercom.interview.test.models;

public class Customer {
    public final long id;
    public final String name;
    public final Location location;

    public Customer(long id, String name, Location location) {
        this.id = id;
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
