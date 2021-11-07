package by.task.kukjan.repository.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.repository.ConeSpecification;

public class RadiusRangeSpecification implements ConeSpecification {
    private double minRadius;
    private double maxRadius;

    public RadiusRangeSpecification(double minRadius, double maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean isSpecified = (cone.getRadius() >= minRadius && cone.getRadius() <= maxRadius);
        return isSpecified;
    }
}
