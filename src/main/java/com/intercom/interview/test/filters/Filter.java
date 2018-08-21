package com.intercom.interview.test.filters;

import com.intercom.interview.test.models.Record;

import java.util.function.Predicate;

public abstract class Filter<T extends Record> implements Predicate<T> {
}
