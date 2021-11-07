package by.task.kukjan.repository.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.repository.ConeSpecification;

public class HeightRangeSpecification implements ConeSpecification{
    private double minHeight;
    private double maxHeight;

    public HeightRangeSpecification(double minHeight, double maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean isSpecified = (cone.getHeight() >= minHeight && cone.getHeight() <= maxHeight);
        return isSpecified;
    }
}
