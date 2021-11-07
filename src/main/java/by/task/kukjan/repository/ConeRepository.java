package by.task.kukjan.repository;

import by.task.kukjan.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository {
    private final static Logger logger = LogManager.getLogger();
    private static ConeRepository instance;
    private List<Cone> cones;

    private ConeRepository(){
        cones = new ArrayList<Cone>();
    }

    public static ConeRepository getInstance(){
        if(instance == null){
            instance = new ConeRepository();
        }
        return instance;
    }

    public boolean add(Cone cone){
        return cones.add(cone);
    }

    public boolean remove(Cone cone){
        return cones.remove(cone);
    }

    public boolean addAll(List<Cone> cones){
        return this.cones.addAll(cones);
    }

    public boolean removeAll(List<Cone> cones){
        return this.cones.removeAll(cones);
    }

    public Cone get(int index){
        return cones.get(index);
    }

    public List<Cone> getAll(){
        return new ArrayList<Cone>(cones);
    }

    public Cone set(int index, Cone cone){
        return cones.set(index, cone);
    }

    public int size(){
        return cones.size();
    }

    public boolean isEmpty(){
        return cones.isEmpty();
    }

    public List<Cone> sort(Comparator<Cone> c){
        List<Cone> sorted;
        sorted = cones.stream()
                .sorted(c)
                .collect(Collectors.toList());
        return sorted;
    }

    public List<Cone> query(ConeSpecification specification){
        List<Cone> result = new ArrayList<>();
        for(Cone cone : cones){
            if(specification.specify(cone)){
                result.add(cone);
            }
        }
        return result;
    }

    public List<Cone> queryStream(ConeSpecification specification){
        return cones.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }


}
