package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] result = new Integer[super.array.length];
        int resCounter = -1;
        for(int i = 0; i < super.array.length; i++) {
            int dupCounter = 1;
            for(int j = 0; j < super.array.length; j++) {
                if (j != i && Objects.equals(array[i], array[j])) dupCounter++;
                if (j == super.array.length - 1 && dupCounter < maxNumberOfDuplications) {
                    resCounter++;
                    result[resCounter] = super.array[i];
                }
            }
        }
        int nullCounter = nullCounter(result);
        return Arrays.copyOf(result, nullCounter);
    }

    public int nullCounter(Integer[] result) {
        int nullCounter = 0;
        for (Integer s : result) {
            if (s != null) nullCounter++;
        }
        return nullCounter;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] result = new Integer[super.array.length];
        int resCounter = -1;
        for(int i = 0; i < super.array.length; i++) {
            int dupCounter = 1;
            for(int j = 0; j < super.array.length; j++) {
                if (j != i && Objects.equals(array[i], array[j])) dupCounter++;
                if (j == super.array.length - 1 && dupCounter != exactNumberOfDuplications) {
                    resCounter++;
                    result[resCounter] = super.array[i];
                }
            }
        }
        int nullCounter = nullCounter(result);
        return Arrays.copyOf(result, nullCounter);
    }
}