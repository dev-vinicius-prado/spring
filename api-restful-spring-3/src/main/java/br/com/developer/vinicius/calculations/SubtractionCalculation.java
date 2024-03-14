package br.com.developer.vinicius.calculations;

import org.springframework.stereotype.Component;

@Component
public class SubtractionCalculation extends Calculation{
    @Override
    public Double calculate(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }
}
