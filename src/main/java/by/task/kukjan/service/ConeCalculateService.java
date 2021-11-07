package by.task.kukjan.service;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.exception.ConeException;

public interface ConeCalculateService {
    double calculateVolume(Cone cone) throws ConeException;

    double calculateLateralSurfaceArea(Cone cone) throws ConeException;

    double calculateArea(Cone cone) throws ConeException;

    double calculateVolumeRatio(Cone cone) throws ConeException;
}
