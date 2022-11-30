package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] result = new String[super.array.length];
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

    public int nullCounter(String[] result) {
        int nullCounter = 0;
        for (String s : result) {
            if (s != null) nullCounter++;
        }
        return nullCounter;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] result = new String[super.array.length];
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