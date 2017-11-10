package ru.hazard.generator;

import ru.hazard.generator.implement.Generator;
import ru.hazard.generator.library.DataGenerator;

import java.util.ArrayList;
import java.util.List;

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
        testNext(5.54, 15.6, 2.32);



    }

    //тестирование целых чисел в указанном диапазоне
    private static void testNext(int from, int to) {
        List<Integer> list = new ArrayList<Integer>();
        list = data.next(from, to);

        for (Integer buff: list){
            System.out.println(buff);
        }
    }

    //тестирование целых чисел в указанном диапазоне с шагом
    private static void testNext(int from, int to, int step) {
        List<Integer> list = new ArrayList<Integer>();
        list = data.next(from, to, step);

        for (Integer buff: list){
            System.out.println(buff);
        }
    }

    private static void testNext(double from, double to, double step) {
        List<Double> list = new ArrayList<Double>();
        list = data.next(from, to, step);

        for (Double buff: list){
            System.out.println(buff);
        }
    }

}
