package by.test.kukjan.filler;

import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.filler.RepositoryFiller;
import by.task.kukjan.filler.impl.RepositoryFillerImpl;
import by.task.kukjan.repository.ConeRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RepositoryFillerTest {
    private RepositoryFiller repositoryFiller;

    @BeforeMethod
    public void initialize(){
        repositoryFiller = new RepositoryFillerImpl();
    }

    @Test
    public void testFillConeRepository(){
        Cone expected = new Cone(new Point(0, 1, 2), 3, 4);

        repositoryFiller.fillConeRepository(expected);

        ConeRepository repository = ConeRepository.getInstance();
        Cone actual = repository.get(repository.size() - 1);

        Assert.assertEquals(actual, expected);
    }
}
