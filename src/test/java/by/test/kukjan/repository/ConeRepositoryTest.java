package by.test.kukjan.repository;

import by.task.kukjan.comparator.ConeIdComparator;
import by.task.kukjan.comparator.ConeRadiusComparator;
import by.task.kukjan.entity.Cone;
import by.task.kukjan.entity.Point;
import by.task.kukjan.exception.ConeException;
import by.task.kukjan.repository.ConeRepository;
import by.task.kukjan.repository.ConeSpecification;
import by.task.kukjan.repository.impl.IdSpecification;
import by.task.kukjan.repository.impl.RadiusRangeSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ConeRepositoryTest {
    private ConeRepository repository;
    @BeforeClass
    public void createRepository() throws ConeException {
        repository = ConeRepository.getInstance();
        repository.add(new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0));
        repository.add(new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0));
        repository.add(new Cone(new Point(1.0, 1.0, 2.0), 3.0, 5.0));
    }

    @DataProvider(name = "query_data")
    public Object[][] createQueryData() throws ConeException {
        return new Object[][]{
                {new IdSpecification(1), Arrays.asList(new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0))},
                {new RadiusRangeSpecification(0, 2), Arrays.asList(new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0)
                        , new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0))}
        };
    }

    @DataProvider(name = "sort_data")
    public Object[][] createSortData() throws ConeException {
        return new Object[][]{
                {new ConeIdComparator(), Arrays.asList(
                        new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0),
                        new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0),
                        new Cone(new Point(1.0, 1.0, 2.0), 3.0, 5.0))
                },
                {new ConeRadiusComparator(), Arrays.asList(
                        new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0),
                        new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0),
                        new Cone(new Point(1.0, 1.0, 2.0), 3.0, 5.0))
                }
        };
    }

    @Test(dataProvider = "query_data")
    public void queryTest(ConeSpecification specification, List<Cone> expectedConeList) throws ConeException {
        List<Cone> queryData = repository.query(specification);
        assertEquals(queryData, expectedConeList);
    }

    @Test(dataProvider = "sort_data")
    public void sortTest(Comparator comparator, List<Cone> expectedConeList) throws ConeException {
        repository.sort(comparator);
        List<Cone> sortData = repository.getAll();
        assertEquals(sortData, expectedConeList);
    }

}
