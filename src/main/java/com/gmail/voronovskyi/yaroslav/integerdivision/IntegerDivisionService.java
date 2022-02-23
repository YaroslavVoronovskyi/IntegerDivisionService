package com.gmail.voronovskyi.yaroslav.integerdivision;

public class IntegerDivisionService {

    StringBuilder result = new StringBuilder();
    StringBuilder quotient = new StringBuilder();
    StringBuilder reminder = new StringBuilder();
    
    public static final String DELIMETER = "|";
    public static final String SPACE = "";
    public static final String TAB = "\n";
    public static final char GAP = ' ';
    public static final char DASH = '-';
    public static final char LINE = '_';
    
    public String createDivision(int dividend, int divisor) {
        if (dividend <= 0 || divisor <= 0 || dividend < divisor) {
            throw new IllegalArgumentException("Dividend or divisor cannot be 0, division by zero "
                    + "or dividend can't be less than divisor");
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        String[] arrayFigures = String.valueOf(dividend).split(SPACE);
        for (int index = 0; index < arrayFigures.length; index++) {
            reminder.append(arrayFigures[index]);
            Integer reminderNumber = Integer.parseInt(reminder.toString());
            if (reminderNumber >= divisor) {
                Integer module = reminderNumber % divisor;
                Integer multiplyResult = reminderNumber / divisor * divisor;
                String lastReminder = String.format("%" + (index + 2) + "s", LINE + reminderNumber.toString());
                result.append(lastReminder).append(TAB);
                String multiply = String.format("%" + (index + 2) + "d", multiplyResult);
                result.append(multiply).append(TAB);
                Integer tab = lastReminder.length() - calculateFigure(multiplyResult);
                result.append(createDivider(multiplyResult, tab)).append(TAB);
                quotient.append(reminderNumber / divisor);
                reminder.replace(0, reminder.length(), module.toString());
                reminderNumber = Integer.parseInt(reminder.toString());
            }
            if (index == arrayFigures.length - 1) {
                result.append(String.format("%" + (index + 2) + "s", reminderNumber.toString())).append(TAB);
            }
        }
        implementationoResult(dividend, divisor);
        return result.toString();
    }

    public String createDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, GAP) + assemblyString(calculateFigure(reminderNumber), DASH);
    }

    public void implementationoResult(Integer dividend, Integer divisor) {
        int[] arrayFigures = new int[3];
        for (int startIndex = 0, endIndex = 0; startIndex < result.length(); startIndex++) {
            if (result.charAt(startIndex) == '\n') {
                arrayFigures[endIndex] = startIndex;
                endIndex++;
            }
            if (endIndex == 3) {
                break;
            }
        }
        int tab = calculateFigure(dividend) + 1 - arrayFigures[0];
        result.insert(arrayFigures[2], assemblyString(tab, GAP) + DELIMETER + quotient.toString());
        result.insert(arrayFigures[1], assemblyString(tab, GAP) + DELIMETER + assemblyString(quotient.length(), DASH));
        result.insert(arrayFigures[0], DELIMETER + divisor);
        result.replace(1, arrayFigures[0], dividend.toString());
    }

    public int calculateFigure(int figure) {
        return (int) (Math.log10(figure) + 1);
    }

    public String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < numberOfSymbols; index++) {
            stringBuilder.append(symbol);
        }
        return stringBuilder.toString();
    }
}
