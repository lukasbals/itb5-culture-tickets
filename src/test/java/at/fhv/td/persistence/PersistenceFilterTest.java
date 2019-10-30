package at.fhv.td.persistence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersistenceFilterTest {
    private PersistenceFilter<String> testPersistenceFilter;
    private String column = "column";
    private String value = "value";

    @Before
    public void before() {
        testPersistenceFilter = new PersistenceFilter<>(PersistenceFilter.FilterType.EQ, column, value);
    }

    @Test
    public void getValue() {
        assertEquals(value, testPersistenceFilter.getValue());
    }

    @Test
    public void getFilterType() {
        assertEquals(PersistenceFilter.FilterType.EQ, testPersistenceFilter.getFilterType());
    }

    @Test
    public void getColumn() {
        assertEquals(column, testPersistenceFilter.getColumn());
    }
}