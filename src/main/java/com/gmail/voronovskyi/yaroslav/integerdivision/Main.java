package com.gmail.voronovskyi.yaroslav.integerdivision;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        IntegerDivisionService integerDivisionService = new IntegerDivisionService();
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Input the first number: ");
                int dividend = scanner.nextInt();
                System.out.println("Input the second number: ");
                int divisor = scanner.nextInt();
                System.out.println(integerDivisionService.createDivision(dividend, divisor));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (RuntimeException exception) {
                System.out.println("Dividend and divisor mast be Integer");
            }
        }
    }
}
