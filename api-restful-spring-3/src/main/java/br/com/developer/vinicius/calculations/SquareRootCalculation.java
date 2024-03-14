package br.com.developer.vinicius.calculations;

import br.com.developer.vinicius.exceptions.UnsupportedMathOperationException;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.stereotype.Component;

@Component
public class SquareRootCalculation extends Calculation {
    @Override
    public Double calculate(Double numberOne, Double numberTwo) {
        return this.calculate(numberOne);
    }

    private Double calculate(Double numberOne){
        return Math.sqrt(numberOne);
    }
}
