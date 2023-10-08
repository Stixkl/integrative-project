package model;

public class Date {
    private int day;
    private int month;
    private int year;
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int compareDates(Date date1, Date date2) {
        if(date1.getYear() < date2.getYear()) {
            return -1;
        } else if (date1.getYear() > date2.getYear()) {
                return 1;
        } else {
            if (date1.getMonth() < date2.getMonth()) {
                return -1;
            } else if (date1.getMonth() > date2.getMonth()) {
                return 1;
            } else {
                if (date1.getDay() < date2.getDay()) {
                    return -1;
                } else if (date1.getDay() > date2.getDay()) {
                    return 1;
                } else {
                    return 0; // Ambas fechas son iguales
                }
            }
        }
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public Date clone() {
        return new Date(day, month, year);
    }


}
