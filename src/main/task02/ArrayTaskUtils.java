package main.task02;

import java.util.Arrays;

public final class ArrayTaskUtils {
    /**
     * Don't let anyone instantiate this class.
     */
    private ArrayTaskUtils() {}

    public static final int ARRAY_LENGTH = 15;
    public static final int INCREMENT_LENGTH = 3;
    public static final int INCREMENT_BARRIER = ARRAY_LENGTH - INCREMENT_LENGTH;
    public static final int INCREMENT_COUNT = ARRAY_LENGTH / INCREMENT_LENGTH;
    public static final int[] SOME_ARRAY = new int[ARRAY_LENGTH];

    /**
     * just fill an empty SOME_ARRAY with args based on a specific algorithm from the test task
     * in the case of an infinite loop an exception is thrown
     *
     * @param args must not exceed 15;
     */
    public static void fillArray(int... args) {
        for (int arg : args) {
            int i = arg % ARRAY_LENGTH;
            int count = 0;
            while (SOME_ARRAY[i] != 0) {
                i -= i >= INCREMENT_BARRIER ? INCREMENT_BARRIER : -INCREMENT_LENGTH;
                if (count == INCREMENT_COUNT) {
                    System.out.println(arg);
                    System.out.println(Arrays.toString(SOME_ARRAY));
                    throw new RuntimeException("infinite loop");
                }
                count++;
            }
            SOME_ARRAY[i] = arg;
        }
    }
}
