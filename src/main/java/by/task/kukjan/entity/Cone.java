package by.task.kukjan.entity;

import by.task.kukjan.exception.ConeException;
import by.task.kukjan.observer.ConeEvent;
import by.task.kukjan.observer.ConeObserver;
import by.task.kukjan.observer.Observable;
import by.task.kukjan.util.ConeIdGenerator;

public class Cone implements Observable {
    private final long coneId;
    private Point circleCenter;
    private double radius;
    private double height;
    private ConeObserver observer;

    public Cone(Point circleCenter, double radius, double height) {

        this.coneId = ConeIdGenerator.generateId();
        this.circleCenter = circleCenter;
        this.radius = radius;
        this.height = height;
    }

    public long getConeId() {
        return coneId;
    }

    public Point getCircleCenter() {
        return circleCenter;
    }

    public void setCircleCenter(Point circleCenter) {
        this.circleCenter = circleCenter;
        notifyObservers();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ConeException {
        this.radius = radius;
        notifyObservers();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws ConeException{
        this.height = height;
        notifyObservers();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){return true;}
        if(obj == null || getClass() != obj.getClass()){return false;}
        Cone cone = (Cone) obj;
        return Double.compare(cone.radius, radius) == 0 &&
                Double.compare(cone.height, height) == 0 &&
                circleCenter.equals(cone.circleCenter);
    }

    @Override
    public int hashCode(){
        int result = circleCenter == null ? 0 : circleCenter.hashCode();
        result = 31 * result + (int) radius;
        result = 31 * result + (int) height;
        return result;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("coneId=").append(coneId);
        sb.append(", circleCenter=").append(circleCenter);
        sb.append(", radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(ConeObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if(observer != null){
            observer.updateParameters(new ConeEvent(this));
        }
    }
}















