package ru.hazard.generator.implement;

import ru.hazard.generator.library.DataGenerator;

import java.io.File;
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

    @Override
    public String next(long number) {
        int length = (int) Math.ceil(Math.log10(number)); //кол-во цифр в номере
        int count = 0;
        int[] numerals = parseNumber(number, length);
        StringBuilder sNumber = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sNumber.append(numerals[i]);
            if (count % 2 != 0 && i != 0)
                sNumber.append('-');
            count++;
        }
        return sNumber.toString();
    }

    @Override
    public List<String> next(String pathOfFile) {
        List<String> list = new ArrayList();
        Scanner scn = null;
        try {
            scn = new Scanner(new File(pathOfFile));
        } catch (Exception e) {
            System.out.println("Файл не найден");
            return null;
        }

        while (scn.hasNext()) {
            list.add(scn.next());
        }

        return list;
    }

    private int[] parseNumber(long number, int length) {
        int[] numerals = new int[length];
        long buffNumb = number;
        int i = 0;
        while (buffNumb > 0) {
            numerals[i] = (int) buffNumb % 10;
            buffNumb = buffNumb / 10;
            i++;
        }

        return numerals;
    }


}
