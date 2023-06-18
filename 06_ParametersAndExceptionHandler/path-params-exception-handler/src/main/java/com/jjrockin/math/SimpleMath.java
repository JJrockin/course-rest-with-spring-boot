package com.jjrockin.math;

import com.jjrockin.exceptions.UnsupportedMathOperationException;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multi(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }
    public Double div(Double numberOne, Double numberTwo) throws Exception {

        if (numberTwo == 0){
            throw new UnsupportedMathOperationException("Div by zero not allowed");
        }

        return numberOne / numberTwo;
    }
    public Double avg (Double numberOne, Double numberTwo){
        return (numberOne + numberTwo)/2;
    }
    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }
}
