package com.intercom.interview.assignment.deserializers;

import com.intercom.interview.assignment.models.Record;

import java.util.function.Function;

public abstract class RecordDeserializer<T extends Record> implements Function<String, T> {
}
