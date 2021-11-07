package by.test.kukjan.util;

import by.task.kukjan.util.ConeIdGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneratorIdTest {
    @Test
    public void generate(){
        long actual = 0;
        long expected = 5;
        for(int i = 0; i < expected; i++){
            actual = ConeIdGenerator.generateId();
        }
        Assert.assertEquals(actual, expected);
    }


}
