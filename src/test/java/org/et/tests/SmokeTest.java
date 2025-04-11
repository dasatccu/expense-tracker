package org.et.tests;

import org.et.util.Currency;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SmokeTest {
    @Test
    public void testCurrencyClass(){
        Currency expense = new Currency("13");
        Currency result = expense.sum("2.22");
        Currency expectedResult = new Currency("15.22");
        Assert.assertEquals(result.getActualValue(),expectedResult.getActualValue());
    }
}
