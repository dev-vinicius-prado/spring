package br.com.developer.vinicius.calculations;

import br.com.developer.vinicius.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Component;

@Component
public class DivisionCalculation extends Calculation {
    @Override
    public Double calculate(Double numberOne, Double numberTwo) {
        if (numberOne.equals(0D)) {
            throw new UnsupportedMathOperationException("Please, cannot possible divide for zero. " +
                            "Set a value greater than zero to number one.");
        }
        return numberOne / numberTwo;
    }
}
