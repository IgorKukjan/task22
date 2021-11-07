package by.task.kukjan.service.impl;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.service.ConeCalculateService;
import by.task.kukjan.service.ConePassCoordinateAxis;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeCalculateServiceImpl  implements ConeCalculateService {
    private static Logger logger = LogManager.getLogger();


    @Override
    public double calculateVolume(Cone cone) throws ConeException {
        if(cone == null){
            logger.log(Level.ERROR, "Cone is null in calculateVolume method");
            throw new ConeException("Calculation of volume cannot be completed.Argument contains null");
        }
        double volume = 1.0 / 3.0 * cone.getHeight() * Math.PI * Math.pow(cone.getRadius(), 2.0);
        logger.log(Level.INFO, "Volume is " + volume);
        return volume;
    }

    @Override
    public double calculateLateralSurfaceArea(Cone cone) throws ConeException {
        if(cone == null){
            logger.log(Level.ERROR, "Cone is null in calculateLateralSurfaceArea method");
            throw new ConeException("Calculation of lateral surface area cannot be completed.Argument contains null");
        }
        double lateralSurfaceArea = Math.PI * cone.getRadius() * (Math.sqrt(Math.pow(cone.getRadius(), 2.0) + Math.pow(cone.getHeight(), 2.0)));
        logger.log(Level.INFO, "Lateral surface area is " + lateralSurfaceArea);
        return  lateralSurfaceArea;
    }

    @Override
    public double calculateArea(Cone cone) throws ConeException {
        if(cone == null){
            logger.log(Level.ERROR, "Cone is null in calculateArea method");
            throw new ConeException("Calculation of area cannot be completed.Argument contains null");
        }
        double area = calculateLateralSurfaceArea(cone) + calculateBaseArea(cone);
        logger.log(Level.INFO, "Area is " + area);
        return area;
    }

    @Override
    public double calculateVolumeRatio(Cone cone) throws ConeException {
        if(cone == null){
            logger.log(Level.ERROR, "Cone is null in volumeRatio method");
            throw new ConeException("volumeRatio cannot be completed.Argument contains null");
        }
        double smallHeight;
        double smallRadius;
        ConePassCoordinateAxisImpl passCoordinateAxis = new ConePassCoordinateAxisImpl();
        if(passCoordinateAxis.passCoordinateAxisXY(cone)){
            smallHeight = cone.getHeight() - Math.abs(0.0 - cone.getCircleCenter().getZ());
            smallRadius = smallHeight * cone.getRadius() / cone.getHeight();
        }else{
            throw new ConeException("XY coordinate axis are not intersect your pyramid");
        }
        double volumeUp =  1.0 / 3.0 * smallHeight * Math.PI * Math.pow(smallRadius, 2.0);
        double volumeDown = calculateVolume(cone) - volumeUp;
        return volumeUp/volumeDown;
    }

    private double calculateBaseArea (Cone cone){
        return Math.PI * Math.pow(cone.getRadius(), 2.0);
    }

}
















