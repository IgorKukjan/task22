package by.task.kukjan.comparator;

import by.task.kukjan.entity.Cone;

import java.util.Comparator;

public class ConeRadiusComparator implements Comparator<Cone> {

    @Override
    public int compare(Cone o1, Cone o2) {
        int result = Double.compare(o1.getRadius(), o2.getRadius());
        return result;
    }
}
