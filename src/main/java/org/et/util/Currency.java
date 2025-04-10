package org.et.util;

public class Currency {
    private Double value;
    private static final String TAG = "Currency";
    private static final String RUPEES = "\u20B9";

    public Currency(String value){
         try{
             this.value = Double.parseDouble(value);
             LogService.info(TAG,"Currency: "+RUPEES+"("+this.value+")");
         } catch (NumberFormatException e) {
             LogService.error(TAG,e.getMessage(), e);
         }
    }

    public Currency(Double value){
        this.value = value;
        LogService.info(TAG,"Currency: "+RUPEES+"("+this.value+")");
    }

    public Currency(Integer value){
        this.value = Double.valueOf(value);
        LogService.info(TAG,"Currency: "+RUPEES+"("+this.value+")");
    }

    private Double getValue(){
        return this.value;
    }

    public Currency sum(Currency currency){
        Currency result = new Currency(this.value + currency.getValue());
        LogService.info(TAG,"Currency after sum: "+RUPEES+"("+result+")");
        return result;
    }

    public Currency substract(Currency currency){
        Currency result = new Currency(this.value + currency.getValue());
        LogService.info(TAG,"Currency after substract: "+RUPEES+"("+result+")");
        return result;
    }

    public Currency multiply(Currency currency){
        Currency result = new Currency(this.value * currency.getValue());
        LogService.info(TAG,"Currency after multiply: "+RUPEES+"("+result+")");
        return result;
    }

    public Currency divide(Currency currency){
        Currency result = null;
        try{
            result = new Currency(this.value / currency.getValue());
        }catch (Exception e){
            LogService.error(TAG,e.getMessage(), e);
        }
        LogService.info(TAG,"Currency after divide: "+RUPEES+"("+result+")");
        return result;
    }

    public Double getActualValue(){

    }
}
