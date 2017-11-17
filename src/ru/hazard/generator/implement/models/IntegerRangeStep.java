package ru.hazard.generator.implement.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hazard on 17.11.17.
 */
public class IntegerRangeStep {

    private int from;
    private int to;
    private int step;
    private List<Integer> result;

    public IntegerRangeStep(int from, int to, int step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public void next() {
        result = new ArrayList<Integer>();
        for (int i = from; i < to; i += step) {
            result.add(i);
        }
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
