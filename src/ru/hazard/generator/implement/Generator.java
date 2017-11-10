package ru.hazard.generator.implement;

import ru.hazard.generator.library.DataGenerator;

import java.util.ArrayList;
import java.util.List;


public class Generator implements DataGenerator {

    @Override
    public List<Integer> next(int from, int to) {
        List list = new ArrayList<Integer>();
        for (int i = from; i < to; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public List<Integer> next(int from, int to, int step) {
        List list = new ArrayList<Integer>();
        for (int i = from; i < to; i += step) {
            list.add(i);
        }
        return list;
    }

    @Override
    public List<Double> next(double from, double to, double step) {
        List list = new ArrayList<Double>();
        for (double i = from; i < to; i += step) {
            list.add(i);
        }
        return list;
    }
}
