package br.com.developer.vinicius;

import br.com.developer.vinicius.calculations.DivisionCalculation;
import br.com.developer.vinicius.calculations.MultiplicationCalculation;
import br.com.developer.vinicius.calculations.SubtractionCalculation;
import br.com.developer.vinicius.calculations.SumCalculation;
import br.com.developer.vinicius.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.developer.vinicius.converters.ConvertToNumberUtil.convertToNumber;
import static br.com.developer.vinicius.converters.ConvertToNumberUtil.isNumeric;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CalculatorController {

    private MultiplicationCalculation multiplicationCalculation;
    private SubtractionCalculation subtractionCalculation;
    private SumCalculation sumCalculation;
    private DivisionCalculation divisionCalculation;

    public CalculatorController(SumCalculation sumCalculation, SubtractionCalculation subtractionCalculation, MultiplicationCalculation multiplicationCalculation, DivisionCalculation divisionCalculation) {
        this.sumCalculation = sumCalculation;
        this.subtractionCalculation = subtractionCalculation;
        this.multiplicationCalculation = multiplicationCalculation;
        this.divisionCalculation = divisionCalculation;
    }

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return sumCalculation.calculate(convertToNumber(numberOne), convertToNumber(numberTwo));
    }
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return subtractionCalculation.calculate(convertToNumber(numberOne), convertToNumber(numberTwo));
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return multiplicationCalculation.calculate(convertToNumber(numberOne), convertToNumber(numberTwo));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return divisionCalculation.calculate(convertToNumber(numberOne), convertToNumber(numberTwo));
    }

    @RequestMapping(value = "/square-root/{numberOne}", method = GET)
    public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToNumber(numberOne));
    }


}
