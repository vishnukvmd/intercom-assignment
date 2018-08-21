package com.intercom.interview.test.deserializers;

import com.intercom.interview.test.models.Record;

import java.util.function.Function;

public abstract class RecordDeserializer<T extends Record> implements Function<String, T> {
}
