package at.fhv.td.persistence.broker;

import at.fhv.td.exceptions.DBConnectionErrorException;
import at.fhv.td.persistence.DBConnection;
import at.fhv.td.persistence.PersistenceFilter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lukas Bals
 */
public abstract class Broker<T extends IModelId> implements BrokerInterface<T> {
    protected abstract Class<T> getModelClass();

    @Override
    public T get(Long id) {
        T result = null;
        Session session;
        try {
            session = DBConnection.getSession();
            Transaction transaction = session.beginTransaction();
            result = session.get(getModelClass(), id);
            transaction.commit();
        } catch (DBConnectionErrorException e) {
            System.err.println(e.getTitle());
            System.err.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<T> getAll() {
        return getAll(new LinkedList<>());
    }

    @Override
    public List<T> getAll(List<PersistenceFilter> filters) {
        List<T> result = null;
        Session session;
        try {
            session = DBConnection.getSession();
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(getModelClass());
            Root<T> root = criteria.from(getModelClass());
            criteria.select(root);

            // If filters exist add them to the query
            if (!filters.isEmpty()) {
                List<Predicate> criteriaList = new LinkedList<>();
                for (PersistenceFilter filter : filters) {
                    criteriaList.add(getWhereClause(builder, root, filter));
                }
                criteria.where(builder.and(criteriaList.toArray(new Predicate[0])));
            }

            result = session.createQuery(criteria).getResultList();
            transaction.commit();
        } catch (DBConnectionErrorException e) {
            System.err.println(e.getTitle());
            System.err.println(e.getMessage());
        }
        return result;
    }

    Predicate getWhereClause(CriteriaBuilder builder, Root<T> root, PersistenceFilter filter) {
        Predicate condition;
        switch (filter.getFilterType()) {
            default:
            case EQ:
                condition = builder.equal(root.get(filter.getColumn()), filter.getValue());
                break;
            case GT:
                condition = builder.gt(root.get(filter.getColumn()), (Integer) filter.getValue());
                break;
            case LT:
                condition = builder.lt(root.get(filter.getColumn()), (Integer) filter.getValue());
                break;
        }
        return condition;
    }

    @Override
    public Long save(T item) {
        Long result = null;
        Session session;
        try {
            session = DBConnection.getSession();
            Transaction transaction = session.beginTransaction();
            result = (Long) session.save(item);
            session.flush();
            transaction.commit();
        } catch (DBConnectionErrorException e) {
            System.err.println(e.getTitle());
            System.err.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<T> saveMultiple(List<T> items) {
        Session session;
        try {
            session = DBConnection.getSession();
            Transaction transaction = session.beginTransaction();
            items.forEach(item -> {
                long newId = (Long) session.save(item);
                item.setId(newId);
            });
            session.flush();
            transaction.commit();
        } catch (DBConnectionErrorException e) {
            System.err.println(e.getTitle());
            System.err.println(e.getMessage());
            items.clear();
        }

        return items;
    }

    @Override
    public void update(T item) {
        Session session;
        try {
            session = DBConnection.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(item);
            session.flush();
            transaction.commit();
        } catch (DBConnectionErrorException e) {
            System.err.println(e.getTitle());
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(T item) {
        Session session;
        try {
            session = DBConnection.getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(item);
            session.flush();
            transaction.commit();
        } catch (DBConnectionErrorException e) {
            System.err.println(e.getTitle());
            System.err.println(e.getMessage());
        }
    }
}