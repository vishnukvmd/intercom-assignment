package com.intercom.interview.assignment.filters;

import com.intercom.interview.assignment.models.Record;

import java.util.function.Predicate;

public abstract class Filter<T extends Record> implements Predicate<T> {
}
