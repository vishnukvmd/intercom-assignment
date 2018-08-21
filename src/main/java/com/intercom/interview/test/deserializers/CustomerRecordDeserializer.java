package com.intercom.interview.test.deserializers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intercom.interview.test.models.CustomerRecord;
import com.intercom.interview.test.models.Location;

import java.util.function.Function;

import static com.intercom.interview.test.models.CustomerRecord.Fields.latitude;
import static com.intercom.interview.test.models.CustomerRecord.Fields.longitude;
import static com.intercom.interview.test.models.CustomerRecord.Fields.name;
import static com.intercom.interview.test.models.CustomerRecord.Fields.user_id;

public class CustomerRecordDeserializer implements Function<String, CustomerRecord> {
    private static final JsonParser PARSER = new JsonParser();

    @Override
    public CustomerRecord apply(String input) {
        JsonObject json = PARSER.parse(input).getAsJsonObject();
        Location location = new Location(json.get(latitude.name()).getAsDouble(),
                json.get(longitude.name()).getAsDouble());
        return new CustomerRecord(json.get(user_id.name()).getAsLong(), json.get(name.name()).getAsString(), location);
    }
}
