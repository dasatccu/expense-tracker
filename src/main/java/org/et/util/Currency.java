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
        LogService.info(TAG,"summation() called");
        Currency result = new Currency(this.value + currency.getValue());
        LogService.info(TAG,"Currency after sum: "+"("+result+")");
        return result;
    }

    public Currency sum(String currency){
        LogService.info(TAG,"summation() called");
        Currency result = new Currency(this.value + new Currency(currency).getValue());
        LogService.info(TAG,"Currency after sum: "+"("+result+")");
        return result;
    }

    public Currency sum(Integer currency){
        LogService.info(TAG,"summation() called");
        Currency result = new Currency(this.value + new Currency(currency).getValue());
        LogService.info(TAG,"Currency after sum: "+"("+result+")");
        return result;
    }

    public Currency substract(Currency currency){
        LogService.info(TAG,"substract() called");
        Currency result = new Currency(this.value - currency.getValue());
        LogService.info(TAG,"Currency after substract: "+"("+result+")");
        return result;
    }

    public Currency substract(String currency){
        LogService.info(TAG,"substract() called");
        Currency result = new Currency(this.value - new Currency(currency).getValue());
        LogService.info(TAG,"Currency after substract: "+"("+result+")");
        return result;
    }

    public Currency substract(Integer currency){
        LogService.info(TAG,"substract() called");
        Currency result = null;
        try{
            result = new Currency(this.value * new Currency(currency).getValue());
        }catch (Exception e){
            LogService.error(TAG,e.getMessage(),e);
        }
        LogService.info(TAG,"Currency after substract: "+"("+result+")");
        return result;
    }

    public Currency multiply(Currency currency){
        LogService.info(TAG,"multiply() called");
        Currency result = new Currency(this.value * currency.getValue());
        LogService.info(TAG,"Currency after multiply: "+"("+result+")");
        return result;
    }

    public Currency multiply(String currency){
        LogService.info(TAG,"multiply() called");
        Currency result = null;
        try{
            result = new Currency(this.value * new Currency(currency).getValue());
        }catch (Exception e){
            LogService.error(TAG,e.getMessage(),e);
        }
        LogService.info(TAG,"Currency after multiply: "+"("+result+")");
        return result;
    }

    public Currency multiply(Integer currency){
        LogService.info(TAG,"multiply() called");
        Currency result = new Currency(this.value * new Currency(currency).getValue());
        LogService.info(TAG,"Currency after multiply: "+"("+result+")");
        return result;
    }

    public Currency divide(Currency currency){
        LogService.info(TAG,"divide() called");
        Currency result = null;
        try{
            result = new Currency(this.value / currency.getValue());
        }catch (Exception e){
            LogService.error(TAG,e.getMessage(), e);
        }
        LogService.info(TAG,"Currency after divide: "+"("+result+")");
        return result;
    }

    public Currency divide(String currency){
        LogService.info(TAG,"divide() called");
        Currency result = null;
        try{
            result = new Currency(this.value / new Currency(currency).getValue());
        }catch (Exception e){
            LogService.error(TAG,e.getMessage(), e);
        }
        LogService.info(TAG,"Currency after divide: "+"("+result+")");
        return result;
    }

    public Currency divide(Integer currency){
        LogService.info(TAG,"divide() called");
        Currency result = null;
        try{
            result = new Currency(this.value / new Currency(currency).getValue());
        }catch (Exception e){
            LogService.error(TAG,e.getMessage(), e);
        }
        LogService.info(TAG,"Currency after divide: "+"("+result+")");
        return result;
    }

    public Double getActualValue(){
        LogService.info(TAG,"getActualValue() called");
        return this.value;
    }

    public Currency roundOff(){
        double rounded = Math.round(value * 100.0) / 100.0;
        return new Currency(rounded);
    }

    @Override
    public String toString() {
        return RUPEES + " " + this.value;
    }
}
