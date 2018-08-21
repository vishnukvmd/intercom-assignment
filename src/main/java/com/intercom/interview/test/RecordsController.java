package com.intercom.interview.test;

import com.intercom.interview.test.models.Record;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @param <T> Type of the record that needs to be de-serialized and filtered.
 */
public class RecordsController<T extends Record> {
    private final Function<String, T> deserializer;
    private final Predicate<T> filter;

    public RecordsController(Function<String, T> deserializer, Predicate<T> filter) {
        this.deserializer = deserializer;
        this.filter = filter;
    }

    /**
     *
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
