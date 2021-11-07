package by.task.kukjan.observer;

import by.task.kukjan.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {
    public ConeEvent(Cone sourse){
        super(sourse);
    }

    @Override
    public Cone getSource(){
        return (Cone) super.getSource();
    }
}
