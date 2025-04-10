package org.example;

import org.et.model.Category;
import org.et.model.CategoryType;
import org.et.model.Expenses;
import org.et.util.Currency;
import org.et.util.DateTimeUtils;

import static org.et.util.DateTimeUtils.CUSTOM_FORMAT;

public class Main {
    public static void main(String[] args) {
        Currency expense = new Currency("13");
        Currency result = expense.sum("2.22");
        System.out.println(result.roundOff().toString());
        System.out.println(DateTimeUtils.getNow().format(CUSTOM_FORMAT));
        Category smoking = new Category("Smoking","Cigarette", CategoryType.EXPENSE);
        System.out.println(smoking.toString());

        Expenses ciggarete = new Expenses(smoking,expense,"11:40");
        System.out.println(ciggarete.toString());
    }
}
