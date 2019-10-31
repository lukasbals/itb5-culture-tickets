package at.fhv.td.persistence.broker;

import at.fhv.td.exceptions.DBConnectionErrorException;
import at.fhv.td.persistence.DBConnection;
import at.fhv.td.persistence.PersistenceFilter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DBConnection.class)
public class BrokerTest {
    static class TestModel {
        private Long _id;
        private String _name;
        private Integer _age;

        private TestModel(Long id, String name, Integer age) {
            this._id = id;
            this._name = name;
            this._age = age;
        }

        private Long getId() {
            return _id;
        }

        public String getName() {
            return _name;
        }

        public Integer getAge() {
            return _age;
        }
    }

    private TestModel _mockModel = new TestModel(1L, "Name", 12);
    private ArrayList<TestModel> _mockModelList = new ArrayList<>();
    private Class<TestModel> _exampleClass = TestModel.class;
    private Broker<TestModel> _broker;
    private String _column = "name";
    private Integer _value = 12;
    @Mock
    Session _session;
    @Mock
    Transaction _transaction;
    @Mock
    CriteriaBuilder _criteriaBuilder;
    @Mock
    CriteriaQuery _criteriaQuery;
    @Mock
    Root _root;
    @Mock
    Query _query;

    @Before
    public void before() throws DBConnectionErrorException {
        mockStatic(DBConnection.class);
        _mockModelList.add(_mockModel);
        _broker = new Broker<TestModel>() {
            @Override
            protected Class<TestModel> getModelClass() {
                return _exampleClass;
            }
        };

        // Mocks that are needed for all methods
        when(DBConnection.getSession()).thenReturn(_session);
        when(_session.beginTransaction()).thenReturn(_transaction);

        // Mocks that are needed for the get() method
        when(_session.get(_exampleClass, _mockModel.getId())).thenReturn(_mockModel);

        // Mocks that are needed for the getAll() methods
        when(_session.getCriteriaBuilder()).thenReturn(_criteriaBuilder);
        when(_criteriaBuilder.createQuery(_exampleClass)).thenReturn(_criteriaQuery);
        when(_criteriaQuery.from(_exampleClass)).thenReturn(_root);
        when(_session.createQuery(_criteriaQuery)).thenReturn(_query);
        when(_query.getResultList()).thenReturn(_mockModelList);

        // Mocks that are needed for the save() method
        when(_session.save(_mockModel)).thenReturn(_mockModel.getId());
    }

    @Test
    public void get() {
        TestModel model = _broker.get(_mockModel.getId());
        verify(_session, times(1)).get(_exampleClass, _mockModel.getId());
        assertEquals(_mockModel, model);
    }

    @Test
    public void getAll() {
        List<TestModel> modelList = _broker.getAll();
        verify(_query, times(1)).getResultList();
        assertEquals(_mockModelList, modelList);
    }

    @Test
    public void getAllWithEmptyFilterArray() {
        List<TestModel> modelList = _broker.getAll(new LinkedList<>());
        verify(_query, times(1)).getResultList();
        assertEquals(_mockModelList, modelList);
    }

    @Test
    public void getAllWithFilterArray() {
        PersistenceFilter persistenceFilter = new PersistenceFilter<>(PersistenceFilter.FilterType.EQ, _column, _value);
        LinkedList<PersistenceFilter> persistenceFilters = new LinkedList<>();
        persistenceFilters.add(persistenceFilter);
        List<TestModel> modelList = _broker.getAll(persistenceFilters);
        List<Predicate> criteriaList = new LinkedList<>();
        criteriaList.add(_broker.getWhereClause(_criteriaBuilder, _root, persistenceFilter));
        verify(_criteriaBuilder, times(1)).and(criteriaList.toArray(new Predicate[0]));
        verify(_query, times(1)).getResultList();
        assertEquals(_mockModelList, modelList);
    }

    @Test
    public void save() {
        Long modelId = _broker.save(_mockModel);
        verify(_session, times(1)).save(_mockModel);
        assertEquals(_mockModel.getId(), modelId);
    }

    @Test
    public void update() {
        _broker.update(_mockModel);
        verify(_session, times(1)).update(_mockModel);
    }

    @Test
    public void delete() {
        _broker.delete(_mockModel);
        verify(_session, times(1)).delete(_mockModel);
    }

    @Test
    public void getWhereClauseEQ() {
        PersistenceFilter<Integer> persistenceFilter = new PersistenceFilter<>(PersistenceFilter.FilterType.EQ, _column, _value);
        Predicate mockPredicate = _criteriaBuilder.equal(_root.get(persistenceFilter.getColumn()), persistenceFilter.getValue());
        when(_criteriaBuilder.equal(_root.get(persistenceFilter.getColumn()), persistenceFilter.getValue())).thenReturn(mockPredicate);
        Predicate predicate = _broker.getWhereClause(_criteriaBuilder, _root, persistenceFilter);
        assertEquals(mockPredicate, predicate);
    }

    @Test
    public void getWhereClauseGT() {
        PersistenceFilter<Integer> persistenceFilter = new PersistenceFilter<>(PersistenceFilter.FilterType.GT, _column, _value);
        Predicate mockPredicate = _criteriaBuilder.gt(_root.get(persistenceFilter.getColumn()), persistenceFilter.getValue());
        when(_criteriaBuilder.equal(_root.get(persistenceFilter.getColumn()), persistenceFilter.getValue())).thenReturn(mockPredicate);
        Predicate predicate = _broker.getWhereClause(_criteriaBuilder, _root, persistenceFilter);
        assertEquals(mockPredicate, predicate);
    }

    @Test
    public void getWhereClauseLT() {
        PersistenceFilter<Integer> persistenceFilter = new PersistenceFilter<>(PersistenceFilter.FilterType.LT, _column, _value);
        Predicate mockPredicate = _criteriaBuilder.lt(_root.get(persistenceFilter.getColumn()), persistenceFilter.getValue());
        when(_criteriaBuilder.equal(_root.get(persistenceFilter.getColumn()), persistenceFilter.getValue())).thenReturn(mockPredicate);
        Predicate predicate = _broker.getWhereClause(_criteriaBuilder, _root, persistenceFilter);
        assertEquals(mockPredicate, predicate);
    }

    @Test
    public void exceptions() throws DBConnectionErrorException {
        when(DBConnection.getSession()).thenThrow(DBConnectionErrorException.class);
        _broker.get(_mockModel.getId());
        _broker.getAll(new LinkedList<>());
        _broker.save(_mockModel);
        _broker.update(_mockModel);
        _broker.delete(_mockModel);
        verifyStatic(DBConnection.class, times(5));
        DBConnection.getSession();
    }
}