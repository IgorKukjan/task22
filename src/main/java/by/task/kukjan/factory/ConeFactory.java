package by.task.kukjan.factory;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeFactory {
    private  final static Logger logger = LogManager.getLogger();
    private static final int NUMBER_OF_PARAMS = 5;

    public static Cone createCone(Point point, double radius, double height) throws ConeException{
       if(radius <= 0 || height <= 0){
           logger.log(Level.ERROR, "Cannot be cone because radius {} or height {} is invalid: "+radius+"or"+height);
           throw new ConeException("Cannot be cone because radius {} or height {} is invalid: "+radius+"or"+height);
       }
        Cone cone = new Cone(point, radius, height);
        logger.log(Level.INFO, "Cone is created successfully: " + cone.toString());
        return cone;
    }
//
//    public static Cone createCone(double x, double y, double z,  double radius, double height)throws ConeException{
//        Point point = new Point(x, y, z);
//        Cone cone = createCone(point, radius, height);
//        return cone;
//    }

    public static Cone createCone(double[] parameters) throws ConeException{
        if(parameters == null || parameters.length != NUMBER_OF_PARAMS){
            logger.log(Level.ERROR, "wrong array length or argument contains null", parameters.length);
            throw  new ConeException("wrong array length or argument contains null" + parameters.length);
        }
        Point point = new Point(parameters[0], parameters[1], parameters[2]);
        double radius = parameters[3];
        double height = parameters[4];
        Cone cone = createCone(point, radius, height);
        return cone;
    }

    public static List<Cone> createListOfCones(List<double[]>parameters) throws ConeException{
        if(parameters == null || parameters.isEmpty()){
            logger.log(Level.ERROR, "argument contains null or empty");
            throw  new ConeException("argument contains null or empty");
        }
        List<Cone> listOfCones = new ArrayList<>();
        for(double[] parameter : parameters){
            Cone cone = createCone(parameter);
            listOfCones.add(cone);
            logger.log(Level.INFO, "List of cones is created successfully: " + listOfCones);
        }
        return listOfCones;
    }

}
