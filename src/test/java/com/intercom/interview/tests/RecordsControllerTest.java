package com.intercom.interview.tests;

import com.intercom.interview.test.controllers.RecordsController;
import com.intercom.interview.test.models.Record;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class RecordsControllerTest {
    @Mock
    private Function<String, Record> deserializer;
    @Mock
    private Predicate<Record> filter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInvocations() {
        List<Record> records = new ArrayList<>();
        records.add(new Record(1));
        records.add(new Record(2));
        RecordsController<Record> recordsController = new RecordsController<>(deserializer, filter);
        when(deserializer.apply(anyString())).thenReturn(records.get(0)).thenReturn(records.get(1));
        when(filter.test(any())).thenReturn(true).thenReturn(false);

        List<String> input = new ArrayList<>();
        input.add("1");
        input.add("2");
        List<Record> filteredRecords = recordsController.getRecords(input);
        assertEquals(filteredRecords.size(), 1);
        assertEquals(filteredRecords.get(0).id, 1);
    }
}
