package by.task.kukjan.service;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.exception.ConeException;

public interface ConePassCoordinateAxis {
    boolean passCoordinateAxisXY(Cone cone) throws ConeException;

    boolean passCoordinateAxisYZ(Cone cone) throws ConeException;

    boolean passCoordinateAxisXZ(Cone cone) throws ConeException;
}
