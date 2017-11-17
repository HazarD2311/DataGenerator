package ru.hazard.generator.implement.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by hazard on 17.11.17.
 */
public class CalendarRange {

    private Calendar from;
    private Calendar to;
    private String type;
    private List<Calendar> result;

    public CalendarRange(Calendar from, Calendar to, String type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public void next() throws CloneNotSupportedException {
        result = new ArrayList();
        Calendar buffCalendar = (Calendar) from.clone();

        switch (type) {
            case "ALL_DAYS": {
                while (buffCalendar.before(to)) {
                    result.add(buffCalendar);
                    buffCalendar = new GregorianCalendar(buffCalendar.get(Calendar.YEAR), buffCalendar.get(Calendar.MONTH), buffCalendar.get(Calendar.DATE));
                    buffCalendar.add(Calendar.DAY_OF_YEAR, 1); //прибавляем один день
                }
                break;
            }
            case "WORKING_DAYS": {
                while (buffCalendar.before(to)) {
                    if (buffCalendar.get(Calendar.DAY_OF_WEEK) != 7 && buffCalendar.get(Calendar.DAY_OF_WEEK) != 1) {
                        result.add(buffCalendar);
                    }
                    buffCalendar = new GregorianCalendar(buffCalendar.get(Calendar.YEAR), buffCalendar.get(Calendar.MONTH), buffCalendar.get(Calendar.DATE));
                    buffCalendar.add(Calendar.DAY_OF_YEAR, 1); //прибавляем один день
                }
                break;
            }
            case "WEEKENDS": {
                while (buffCalendar.before(to)) {
                    if (buffCalendar.get(Calendar.DAY_OF_WEEK) == 7 || buffCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
                        result.add(buffCalendar);
                    }
                    buffCalendar = new GregorianCalendar(buffCalendar.get(Calendar.YEAR), buffCalendar.get(Calendar.MONTH), buffCalendar.get(Calendar.DATE));
                    buffCalendar.add(Calendar.DAY_OF_YEAR, 1); //прибавляем один день
                }
                break;
            }
        }
    }

    public Calendar getFrom() {
        return from;
    }

    public void setFrom(Calendar from) {
        this.from = from;
    }

    public Calendar getTo() {
        return to;
    }

    public void setTo(Calendar to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Calendar> getResult() {
        return result;
    }

    public void setResult(List<Calendar> result) {
        this.result = result;
    }
}
