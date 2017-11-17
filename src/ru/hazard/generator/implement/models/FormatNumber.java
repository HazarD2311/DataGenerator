package ru.hazard.generator.implement.models;

/**
 * Created by hazard on 17.11.17.
 */
public class FormatNumber {

    private long number;
    private String result;

    public FormatNumber(long number) {
        this.number = number;
    }

    public void next() {
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
        result = sNumber.toString();
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

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
