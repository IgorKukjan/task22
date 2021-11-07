package by.task.kukjan.service.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.service.ConeBaseCoordinateAxis;

public class ConeBaseCoordinateAxisImpl implements ConeBaseCoordinateAxis {
    @Override
    public boolean isBaseOnCoordinateAxisXY(Cone cone) throws ConeException {
        boolean isBaseOnCoordinateAxis = cone.getCircleCenter().getZ() == 0;
        return isBaseOnCoordinateAxis;
    }

    @Override
    public boolean isBaseOnCoordinateAxisYZ(Cone cone) throws ConeException {
        boolean isBaseOnCoordinateAxis = cone.getCircleCenter().getX() == 0;
        return isBaseOnCoordinateAxis;
    }

    @Override
    public boolean isBaseOnCoordinateAxisXZ(Cone cone) throws ConeException {
        boolean isBaseOnCoordinateAxis = cone.getCircleCenter().getY() == 0;
        return isBaseOnCoordinateAxis;
    }


}
