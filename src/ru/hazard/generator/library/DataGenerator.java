package ru.hazard.generator.library;

import java.util.List;

/**
 * Created on 10.11.17.
 */
public interface DataGenerator {

    /**
     * целые числа в указанном диапазоне
     * от from до to
     *
     * @param from
     * @param to
     * @return List<Integer>
     */
    public List<Integer> next(int from, int to);

    /**
     * целые числа в указанном диапазоне с шагом
     * от from до to с шагом step
     *
     * @param from
     * @param to
     * @param step
     * @return List<Integer>
     */
    public List<Integer> next(int from, int to, int step);

    /**
     * вещественные числа в указанном диапазоне с шагом
     * от from до to с шагом step
     *
     * @param from
     * @param to
     * @param step
     * @return List<Double>
     */
    public List<Double> next(double from, double to, double step);


}