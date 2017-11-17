package ru.hazard.generator.implement.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hazard on 17.11.17.
 */
public class DoubleRangeStep {

    private double from;
    private double to;
    private double step;
    private List<Double> result;

    public DoubleRangeStep(double from, double to, double step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public void next() {
        result = new ArrayList<Double>();
        for (double i = from; i < to; i += step) {
            result.add(i);
        }
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public List<Double> getResult() {
        return result;
    }

    public void setResult(List<Double> result) {
        this.result = result;
    }
}
