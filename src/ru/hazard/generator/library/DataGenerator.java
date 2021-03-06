package ru.hazard.generator.library;

import java.util.Calendar;
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

    /**
     * даты в указанном диапазоне
     * от from до to c указанием type
     * type:
     * "ALL_DAYS" - все дни
     * "WORKING_DAYS" - рабочие дни
     * "WEEKENDS" - выходные дни
     *
     * @param from
     * @param to
     * @param type
     * @return List<CalendarRange>
     */
    public List<Calendar> next(Calendar from, Calendar to, String type) throws CloneNotSupportedException;

    /**
     * форматирование строки по шаблону
     * 123456 -> 12-34-56
     *
     * @param number
     * @return String
     */
    public String next(long number);

    /**
     * считывание слов из файла
     *
     * @param pathOfFile
     * @return List<String>
     */
    public List<String> next(String pathOfFile);
}