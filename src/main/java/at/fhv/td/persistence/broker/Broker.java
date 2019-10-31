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
public abstract class Broker<Model> implements BrokerInterface<Model> {
    protected abstract Class<Model> getModelClass();

    @Override
    public Model get(Long id) {
        Model result = null;
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
    public List<Model> getAll() {
        return getAll(new LinkedList<>());
    }

    @Override
    public List<Model> getAll(List<PersistenceFilter> filters) {
        List<Model> result = null;
        Session session;
        try {
            session = DBConnection.getSession();
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Model> criteria = builder.createQuery(getModelClass());
            Root<Model> root = criteria.from(getModelClass());
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

    Predicate getWhereClause(CriteriaBuilder builder, Root<Model> root, PersistenceFilter filter) {
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
    public Long save(Model item) {
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
    public void update(Model item) {
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
    public void delete(Model item) {
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