package br.com.developer.vinicius;

import br.com.developer.vinicius.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CalculatorController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToNumber(numberOne) + convertToNumber(numberTwo);
    }
    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToNumber(numberOne) - convertToNumber(numberTwo);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToNumber(numberOne) * convertToNumber(numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToNumber(numberOne) / convertToNumber(numberTwo);
    }

    private boolean isNumeric(String strNumber) {
        if (null == strNumber) {
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToNumber(String strNumber) {
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }
}
