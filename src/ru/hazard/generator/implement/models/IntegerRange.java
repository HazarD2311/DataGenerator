package ru.hazard.generator.implement.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hazard on 17.11.17.
 */
public class IntegerRange {

    private int from;
    private int to;
    private List<Integer> result;

    public IntegerRange(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public void next() {
        result = new ArrayList<Integer>();
        for (int i = from; i < to; i++) {
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

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
