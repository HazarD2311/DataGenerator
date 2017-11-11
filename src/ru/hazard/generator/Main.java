package ru.hazard.generator;

import ru.hazard.generator.implement.Generator;
import ru.hazard.generator.library.DataGenerator;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static DataGenerator data = new Generator();

    public static void main(String[] args) {

        //целые числа в указанном диапазоне
        //от 5 до 15
        //testNext(5, 15);

        //целые числа в указанном диапазоне c шагом
        //от 5 до 15 c шагом 4
        //testNext(5, 15, 4);

        //целые числа в указанном диапазоне c шагом
        //от 5.54 до 15.6 c шагом 2.32
        //testNext(5.54, 15.6, 2.32);

        Calendar fromDate = new GregorianCalendar(2015, Calendar.NOVEMBER, 23);
        Calendar toDate = new GregorianCalendar(2015, Calendar.DECEMBER, 5);
        testNext(fromDate, toDate, "WEEKENDS");

    }

    //тестирование целых чисел в указанном диапазоне
    private static void testNext(int from, int to) {
        List<Integer> list;
        list = data.next(from, to);

        for (Integer buff: list){
            System.out.println(buff);
        }
    }

    //тестирование целых чисел в указанном диапазоне с шагом
    private static void testNext(int from, int to, int step) {
        List<Integer> list;
        list = data.next(from, to, step);

        for (Integer buff: list){
            System.out.println(buff);
        }
    }

    //целые числа в указанном диапазоне c шагом
    private static void testNext(double from, double to, double step) {
        List<Double> list;
        list = data.next(from, to, step);

        for (Double buff: list){
            System.out.println(buff);
        }
    }

    private static void testNext(Calendar from, Calendar to, String type) {
        List<Calendar> list;
        list = data.next(from, to, type);

        Date date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy");

        for (Calendar buff : list) {
            date = buff.getTime();
            System.out.println(dateFormat.format(date));
        }
    }

}
