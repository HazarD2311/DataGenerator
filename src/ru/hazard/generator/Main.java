package ru.hazard.generator;

import ru.hazard.generator.implement.Generator;
import ru.hazard.generator.library.DataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static DataGenerator data = new Generator();

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("***целые числа в указанном диапазоне***");
        testNext(5, 15);
        System.out.println();

        System.out.println("***целые числа в указанном диапазоне с шагом***");
        testNext(5, 15, 4);
        System.out.println();

        System.out.println("***вещественные числа в диапазоне с шагом***");
        testNext(5.54, 15.6, 2.32);
        System.out.println();

        System.out.println("***даты в указанном диапазоне между двумя датами***");
        Calendar fromDate = new GregorianCalendar(2015, Calendar.NOVEMBER, 23);
        Calendar toDate = new GregorianCalendar(2015, Calendar.DECEMBER, 2);
        System.out.println("*все дни*");
        testNext(fromDate, toDate, "ALL_DAYS");
        System.out.println("*рабочие дни*");
        testNext(fromDate, toDate, "WORKING_DAYS");
        System.out.println("*выходные дни*");
        testNext(fromDate, toDate, "WEEKENDS");
        System.out.println();

        System.out.println("***форматирование строки по правилу***");
        long number = 923128023;
        System.out.println(data.next(number));
        System.out.println();

        System.out.println("***считывание слов из файла***");
        //!!!путь для Linux
        //надеюсь File.separator исправит ситуацию и путь пройдет для Windows :)
        List<String> list = data.next("src" + File.separator + "input");
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();
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

    //даты в диапазоне
    private static void testNext(Calendar from, Calendar to, String type) throws CloneNotSupportedException {
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
