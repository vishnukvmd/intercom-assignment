package com.intercom.interview.assignment.deserializers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intercom.interview.assignment.models.CustomerRecord;
import com.intercom.interview.assignment.models.Location;

import static com.intercom.interview.assignment.models.CustomerRecord.Fields.latitude;
import static com.intercom.interview.assignment.models.CustomerRecord.Fields.longitude;
import static com.intercom.interview.assignment.models.CustomerRecord.Fields.name;
import static com.intercom.interview.assignment.models.CustomerRecord.Fields.user_id;

public class CustomerRecordDeserializer extends RecordDeserializer<CustomerRecord> {
    private static final JsonParser PARSER = new JsonParser();

    @Override
    public CustomerRecord apply(String input) {
        JsonObject json = PARSER.parse(input).getAsJsonObject();
        Location location = new Location(json.get(latitude.name()).getAsDouble(),
                json.get(longitude.name()).getAsDouble());
        return new CustomerRecord(json.get(user_id.name()).getAsLong(), json.get(name.name()).getAsString(), location);
    }
}
