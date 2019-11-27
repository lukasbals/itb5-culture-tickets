package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.ITopic;
import at.fhv.td.persistence.broker.IModelId;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Lukas Bals
 */
@Entity
@Table(name = "topics")
public class Topic implements ITopic, IModelId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id", updatable = false, nullable = false)
    private Long _topicId;

    @Column(name = "topic_name")
    private String _topicName;

    @ManyToMany(mappedBy = "_topics", fetch = FetchType.LAZY)
    private Set<User> _users;

    @Override
    public Long getId() {
        return _topicId;
    }

    @Override
    public String getName() {
        return _topicName;
    }

    @Override
    public Set<User> getUsers() {
        return _users;
    }

    @Override
    public void setId(Long id) {
        _topicId = id;
    }

    public void setName(String name) {
        _topicName = name;
    }

    public void setUsers(Set<User> users) {
        _users = users;
    }
}
