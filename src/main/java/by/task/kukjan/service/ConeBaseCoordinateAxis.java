package by.task.kukjan.service;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.exception.ConeException;

public interface ConeBaseCoordinateAxis {
    boolean isBaseOnCoordinateAxisXY(Cone cone) throws ConeException;

    boolean isBaseOnCoordinateAxisYZ(Cone cone) throws ConeException;

    boolean isBaseOnCoordinateAxisXZ(Cone cone) throws ConeException;
}
