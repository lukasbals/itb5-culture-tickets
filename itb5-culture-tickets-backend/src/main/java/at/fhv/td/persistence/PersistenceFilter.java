package at.fhv.td.persistence;

/**
 * @author Lukas Bals
 */
public class PersistenceFilter<T extends Object> {

    private FilterType _filterType;
    private String _column;
    private T _value;

    public PersistenceFilter(FilterType filterType, String column, T value) {
        _filterType = filterType;
        _column = column;
        _value = value;
    }

    public T getValue() {
        return _value;
    }

    public FilterType getFilterType() {
        return _filterType;
    }

    public String getColumn() {
        return _column;
    }

    public enum FilterType {
        EQ, // EQUAL
        GT, // Greater than
        LT  // Lower than
    }
}
