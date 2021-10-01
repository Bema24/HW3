package com.company;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        out.println("какую сумму вы хотите ввести?");
        bankAccount.deposit(scanner.nextDouble());
        while (true) {
            try {
                out.println("у вас на счету " + bankAccount.getAmount());
                bankAccount.withDraw(6000);
            } catch (LimitException e) {
                out.println(e.getMessage());
                try {
                    bankAccount.withDraw((int) bankAccount.getAmount());
                    out.println("остаток счета " + bankAccount.getAmount());

                } catch (LimitException limitException) {
                    limitException.printStackTrace();
                }
                break;
            }
        }
    }
}

