package util;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringJoiner;

public class NumberClass {

    public static NumberClass instance = new NumberClass();

    static Random random = new Random();

    public String first = "1";
    public String second = "2";
    public String third = "3";
    public String fourth = "4";
    public String fifth = "5";
    public String sixth = "6";
    public String seventh = "7";
    public String eighth = "8";
    public String ninth = "9";
    public String tenth = "10";

    public static String[] numbers;
    public static String[] speakNumbers;
    static String speakString = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";

    public NumberClass() {
        numbers = new String[]{first, second, third, fourth, fifth, sixth, seventh, eighth,
                ninth, tenth};
        speakNumbers = new String[10];
        generateSpeakString("number");
    }

    public static void generateSpeakString(String type) {
        if (type.equals("number") || type.equals("date") || type.equals("time") || type.equals(
                "dayofweek") || type.equals("month") || type.equals("direction")) {
            System.arraycopy(numbers, 0, speakNumbers, 0, 10);
        }

        if (type.equals("phone")) {
            for(int i = 0; i < 10; i++) {
                StringJoiner joiner = new StringJoiner(" ");
                for (char c : numbers[i].toCharArray()) {
                    joiner.add(String.valueOf(c));
                }
                speakNumbers[i] = joiner.toString();
            }
        }
    }

//    public static void generateSpeakString(String type) {
//        speakString = numbers[0];
//        if (type.equals("number") || type.equals("date") || type.equals("dayofweek") || type.equals("month")) {
//            for(int i = 1; i < 10; i++) {
//                speakString = speakString + ", " + numbers[i];
//            }
//        }
//
//        if (type.equals("phone")) {
//            for(int i = 1; i < 10; i++) {
//                speakString = speakString + " " + numbers[i];
//            }
//        }
//    }

    public static void generateFixedNums(int intDigit, int deciDigit) {
        for(int i = 0; i < 10; i++) {
            numbers[i] = generateOneNum(intDigit, deciDigit);
        }
        generateSpeakString("number");
    }

    public static void generateRangedNums(int intDigitMin, int intDigitMax, int deciDigitMin,
                                          int deciDigitMax) {
        for(int i = 0; i < 10; i++) {
            int intDigit = randomInt(intDigitMin, intDigitMax);
            int deciDigit = randomInt(deciDigitMin, deciDigitMax);
            numbers[i] = generateOneNum(intDigit, deciDigit);
        }
        generateSpeakString("number");
    }

    public static void generatePhoneNums(int digit) {
        for(int i = 0; i < 10; i++) {
            String s = "";
            for (int j = 0; j < digit; j++) {
                s += String.valueOf(randomInt(0, 9));
            }
            numbers[i] = s;
        }
        generateSpeakString("phone");
    }

    public static void generateDates(int dateFrom, int dateTo) {
        String from = dateFrom + "-01-01 00:00:00";
        String to = dateTo + "-12-31 23:59:59";
        for(int i = 0; i < 10; i++) {
            numbers[i] = randomDate(from, to).substring(0, 10);
        }
        generateSpeakString("date");
    }

    public static void generateTime() {
        String from = "2012-01-01 00:00:00";
        String to = "2012-12-31 23:59:59";
        for(int i = 0; i < 10; i++) {
            numbers[i] = randomDate(from, to).substring(11, 16);
        }
        generateSpeakString("time");
    }

    public static void generateDaysOfWeek() {
        for(int i = 0; i < 10; i++) {
            numbers[i] = getDayOfWeek(randomInt(1, 7));
        }
        generateSpeakString("dayofweek");
    }

    public static void generateMonths() {
        for(int i = 0; i < 10; i++) {
            numbers[i] = getMonth(randomInt(1, 12));
        }
        generateSpeakString("month");
    }

    public static void generateDirections() {
        for(int i = 0; i < 10; i++) {
            numbers[i] = getDirection(randomInt(1, 8));
        }
        generateSpeakString("direction");
    }

    private static String getDayOfWeek(int num) {
        switch(num) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
        }
        return null;
    }

    private static String getMonth(int num) {
        switch(num) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return null;
    }

    private static String getDirection(int num) {
        switch(num) {
            case 1:
                return "North";
            case 2:
                return "Northwest";
            case 3:
                return "West";
            case 4:
                return "Southwest";
            case 5:
                return "South";
            case 6:
                return "Southeast";
            case 7:
                return "East";
            case 8:
                return "Northeast";
        }
        return null;
    }

    private static String generateOneNum(int intDigit, int deciDigit) {
        String integer = "";
        String decimal = "";
        for (int i = 0; i < intDigit; i++) {
            if (i == 0) {
                integer += String.valueOf(randomInt(1, 9));
            } else {
                integer += String.valueOf(randomInt(0, 9));
            }
        }

        if (deciDigit == 0) {
            return integer;
        }

        for (int i = 0; i < deciDigit; i++) {
            if (i == deciDigit - 1) {
                decimal += String.valueOf(randomInt(1, 9));
            } else {
                decimal += String.valueOf(randomInt(0, 9));
            }
        }

        if (intDigit == 0) {
            return "0." + decimal;
        }

        return integer + "." + decimal;

//        int minInt = (int)Math.pow(10, intDigit - 1);
//        int maxInt = (int)Math.pow(10, intDigit) - 1;
//        int minDeci = 0;
//        int maxDeci = (int)Math.pow(10, intDigit) - 1;
//        int divisor = (int)Math.pow(10, deciDigit);
//        for(int i = 0; i < 10; i++) {
//            double num = randomInt(minInt, maxInt) + randomInt(minDeci, maxDeci) * 1.0 / divisor;
//            numbers[i] = String.valueOf(num);
//        }
    }

    private static int randomInt(int min, int max) {
        return random.nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 获取随机日期
     * @param beginDate 起始日期
     * @param endDate 结束日期
     * @return
     */
    public static String randomDate(String beginDate, String endDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = sdf.parse(beginDate);
            Date end = sdf.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }

            long date = random(start.getTime(),end.getTime());

            return sdf.format(new Date(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }

}
