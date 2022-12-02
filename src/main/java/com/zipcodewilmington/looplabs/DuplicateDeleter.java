package com.zipcodewilmington.looplabs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;
    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }
    public T[] removeDuplicates(int maxNumberOfDuplications) {
        T[] result = Arrays.copyOf(array, array.length);
        int resCounter = -1;
        for (int i = 0; i < array.length; i++) {
            int dupCounter = 1;
            for (int j = 0; j < array.length; j++) {
                if (j != i && Objects.equals(array[i], array[j])) dupCounter++;
                if (j == array.length - 1 && dupCounter < maxNumberOfDuplications) {
                    resCounter++;
                    result[resCounter] = array[i];
                }
            }
        }
        return Arrays.copyOf(result, resCounter+1);
    }
    public T[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        T[] result = Arrays.copyOf(array, array.length);
        int resCounter = -1;
        for(int i = 0; i < array.length; i++) {
            int dupCounter = 1;
            for(int j = 0; j < array.length; j++) {
                if (j != i && Objects.equals(array[i], array[j])) dupCounter++;
                if (j == array.length - 1 && dupCounter != exactNumberOfDuplications) {
                    resCounter++;
                    result[resCounter] = array[i];
                }
            }
        }
        return Arrays.copyOf(result, resCounter+1);
    }
}
