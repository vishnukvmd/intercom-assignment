package com.intercom.interview.assignment.controllers;

import com.intercom.interview.assignment.deserializers.RecordDeserializer;
import com.intercom.interview.assignment.filters.Filter;
import com.intercom.interview.assignment.models.Record;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <T> Type of the record that needs to be de-serialized and filtered.
 */
public class RecordsController<T extends Record> {
    private final RecordDeserializer<T> deserializer;
    private final Filter<T> filter;

    public RecordsController(RecordDeserializer<T> deserializer, Filter<T> filter) {
        this.deserializer = deserializer;
        this.filter = filter;
    }

    /**
     * @param input List of records in their JSON format.
     * @return List of de-serialized and filtered records, sorted according to their `id`.
     */
    public List<T> getRecords(List<String> input) {
        List<T> records = input
                .stream()
                .map(deserializer)
                .filter(filter)
                .collect(Collectors.toList());
        sortRecords(records);
        return records;
    }

    private void sortRecords(List<T> customers) {
        customers.sort(Comparator.comparingLong(o -> o.id));
    }
}
