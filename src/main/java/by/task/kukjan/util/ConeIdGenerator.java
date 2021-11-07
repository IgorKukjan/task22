package by.task.kukjan.util;

public class ConeIdGenerator {
    private static long counter;

    public static long generateId(){
        return counter++;
    }
}
