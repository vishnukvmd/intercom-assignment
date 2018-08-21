package com.intercom.interview.test.deserializers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intercom.interview.test.models.Customer;
import com.intercom.interview.test.models.Location;

import java.util.function.Function;

import static com.intercom.interview.test.models.Customer.Fields.latitude;
import static com.intercom.interview.test.models.Customer.Fields.longitude;
import static com.intercom.interview.test.models.Customer.Fields.name;
import static com.intercom.interview.test.models.Customer.Fields.user_id;

public class CustomerDeserializer implements Function<String, Customer> {
    private static final JsonParser PARSER = new JsonParser();

    @Override
    public Customer apply(String input) {
        JsonObject json = PARSER.parse(input).getAsJsonObject();
        Location location = new Location(json.get(latitude.name()).getAsDouble(),
                json.get(longitude.name()).getAsDouble());
        return new Customer(json.get(user_id.name()).getAsLong(), json.get(name.name()).getAsString(), location);
    }
}
