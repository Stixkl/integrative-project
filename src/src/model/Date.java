package model;

public class Date {
    private int day;
    private int month;
    private int year;

// The `public Date(int day, int month, int year)` is a constructor method for the `Date` class. It is
// used to create a new `Date` object with the specified day, month, and year values. The constructor
// assigns the provided values to the corresponding instance variables `day`, `month`, and `year` using
// the `this` keyword.
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

 /**
  * The function returns the value of the "day" variable.
  * 
  * @return The method is returning the value of the variable "day".
  */
    public int getDay() {
        return day;
    }

/**
 * The function returns the value of the month.
 * 
 * @return The method is returning the value of the variable "month".
 */
    public int getMonth() {
        return month;
    }

/**
 * The function returns the value of the year variable.
 * 
 * @return The method is returning the value of the variable "year".
 */
    public int getYear() {
        return year;
    }

/**
 * The function compares two dates and returns -1 if the first date is earlier, 1 if the second date is
 * earlier, and 0 if the dates are the same.
 * 
 * @param date1 The first date to compare.
 * @param date2 The `date2` parameter is a `Date` object representing the second date to compare.
 * @return The method is returning an integer value. It returns -1 if date1 is earlier than date2, 1 if
 * date1 is later than date2, and 0 if both dates are equal.
 */
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

/**
 * The toString() function returns a string representation of the day, month, and year.
 * 
 * @return The method is returning a string representation of the date in the format "day/month/year".
 */
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
