package by.task.kukjan.service.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.service.ConePassCoordinateAxis;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConePassCoordinateAxisImpl implements ConePassCoordinateAxis {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean passCoordinateAxisXY(Cone cone) throws ConeException {
        if(cone == null){
            logger.log(Level.ERROR, "Cone is null in passCoordinateAxisXY method");
            throw new ConeException("passCoordinateAxisXY cannot be completed.Argument contains null");
        }
        Point circleCenter = cone.getCircleCenter();
        double height = cone.getHeight();
        boolean pass = circleCenter.getZ() + height < 0 && circleCenter.getZ()  > 0 ||
                circleCenter.getZ() + height > 0 && circleCenter.getZ() < 0;
        return pass;
    }

    @Override
    public boolean passCoordinateAxisYZ(Cone cone) throws ConeException {
        if(cone == null){
            logger.log(Level.ERROR, "Cone is null in passCoordinateAxisYZ method");
            throw new ConeException("passCoordinateAxisYZ cannot be completed.Argument contains null");
        }
        Point circleCenter = cone.getCircleCenter();
        double radius = cone.getRadius();
        boolean pass = circleCenter.getX() + radius < 0 && circleCenter.getX() - radius > 0 ||
                circleCenter.getX() + radius > 0 && circleCenter.getX() - radius < 0;
        return pass;
    }

    @Override
    public boolean passCoordinateAxisXZ(Cone cone) throws ConeException {
        if(cone == null){
            logger.log(Level.ERROR, "Cone is null in passCoordinateAxisXZ method");
            throw new ConeException("passCoordinateAxisXZ cannot be completed.Argument contains null");
        }
        Point circleCenter = cone.getCircleCenter();
        double radius = cone.getRadius();
        boolean pass = circleCenter.getY() + radius < 0 && circleCenter.getY() - radius > 0 ||
                circleCenter.getY() + radius > 0 && circleCenter.getY() - radius < 0;
        return pass;
    }
}
