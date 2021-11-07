package by.task.kukjan.repository.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.repository.ConeSpecification;

public class IdSpecification implements ConeSpecification {
    private final long id;

    public IdSpecification(long id){
        this.id = id;
    }

    @Override
    public boolean specify(Cone cone) {
        return cone.getConeId() == id;
    }
}
