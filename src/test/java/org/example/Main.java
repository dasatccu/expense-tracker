package org.example;

import org.et.util.Currency;

public class Main {
    public static void main(String[] args) {
        Currency expense1 = new Currency("1.22");
        Currency result = expense1.sum("2.22");
        System.out.println(result.roundOff().toString());
    }
}
