package ru.hazard.generator.implement;

import ru.hazard.generator.library.DataGenerator;

import java.util.*;


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

    @Override
    public List<Calendar> next(Calendar from, Calendar to, String type) {
        List<Calendar> list = new ArrayList();
        Calendar buffCalendar = (Calendar) from.clone();

        //todo попробовать другую реализацию
        switch (type) {
            case "ALL_DAYS": {
                while (buffCalendar.before(to)) {
                    list.add(buffCalendar);
                    buffCalendar = new GregorianCalendar(buffCalendar.get(Calendar.YEAR), buffCalendar.get(Calendar.MONTH), buffCalendar.get(Calendar.DATE));
                    buffCalendar.add(Calendar.DAY_OF_YEAR, 1); //прибавляем один день
                }
                break;
            }
            case "WORKING_DAYS": {
                while (buffCalendar.before(to)) {
                    if (buffCalendar.get(Calendar.DAY_OF_WEEK) != 7 && buffCalendar.get(Calendar.DAY_OF_WEEK) != 1) {
                        list.add(buffCalendar);
                    }
                    buffCalendar = new GregorianCalendar(buffCalendar.get(Calendar.YEAR), buffCalendar.get(Calendar.MONTH), buffCalendar.get(Calendar.DATE));
                    buffCalendar.add(Calendar.DAY_OF_YEAR, 1); //прибавляем один день
                }
                break;
            }
            case "WEEKENDS": {
                while (buffCalendar.before(to)) {
                    if (buffCalendar.get(Calendar.DAY_OF_WEEK) == 7 || buffCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
                        list.add(buffCalendar);
                    }
                    buffCalendar = new GregorianCalendar(buffCalendar.get(Calendar.YEAR), buffCalendar.get(Calendar.MONTH), buffCalendar.get(Calendar.DATE));
                    buffCalendar.add(Calendar.DAY_OF_YEAR, 1); //прибавляем один день
                }
                break;
            }
        }

        return list;
    }
}
