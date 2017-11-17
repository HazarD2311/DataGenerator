package ru.hazard.generator.implement;

import ru.hazard.generator.implement.models.*;
import ru.hazard.generator.library.DataGenerator;

import java.io.File;
import java.util.*;


public class Generator implements DataGenerator {

    @Override
    public List<Integer> next(int from, int to) {
        IntegerRange intRange = new IntegerRange(from, to);
        intRange.next();
        return intRange.getResult();
    }

    @Override
    public List<Integer> next(int from, int to, int step) {
        IntegerRangeStep intRangeStep = new IntegerRangeStep(from, to, step);
        intRangeStep.next();
        return intRangeStep.getResult();
    }

    @Override
    public List<Double> next(double from, double to, double step) {
        DoubleRangeStep doubleRangeStep = new DoubleRangeStep(from, to, step);
        doubleRangeStep.next();
        return doubleRangeStep.getResult();
    }

    @Override
    public List<Calendar> next(Calendar from, Calendar to, String type) throws CloneNotSupportedException {
        CalendarRange calendarRange = new CalendarRange(from, to, type);
        calendarRange.next();
        return calendarRange.getResult();
    }

    @Override
    public String next(long number) {
        FormatNumber formatNumber = new FormatNumber(number);
        formatNumber.next();
        return formatNumber.getResult();
    }

    @Override
    public List<String> next(String pathOfFile) {
        FromFile fromFile = new FromFile(pathOfFile);
        fromFile.next();
        return fromFile.getResult();
    }


}
