package at.fhv.td.persistence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersistenceFilterTest {
    private PersistenceFilter<String> _testPersistenceFilter;
    private String _column = "column";
    private String _value = "value";

    @Before
    public void before() {
        _testPersistenceFilter = new PersistenceFilter<>(PersistenceFilter.FilterType.EQ, _column, _value);
    }

    @Test
    public void getValue() {
        assertEquals(_value, _testPersistenceFilter.getValue());
    }

    @Test
    public void getFilterType() {
        assertEquals(PersistenceFilter.FilterType.EQ, _testPersistenceFilter.getFilterType());
    }

    @Test
    public void getColumn() {
        assertEquals(_column, _testPersistenceFilter.getColumn());
    }
}