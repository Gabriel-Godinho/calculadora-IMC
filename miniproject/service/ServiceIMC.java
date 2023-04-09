package miniproject.service;

import miniproject.entity.Entity;
import miniproject.exception.InvalidValueException;

public class ServiceIMC {
    
    public double calculate(Entity data) throws InvalidValueException {
        double weightValue = data.getWeight();
        double highValue = 0;

        if (data.getHigh() != 0) {
            highValue = data.getHigh();
        } else if (data.getHigh() == 0) {
            throw new InvalidValueException("Erro aritmético!\n Não é possível dividir por ZERO ou um número negativo foi inserido!.");
        }

        return weightValue / Math.pow(highValue, 2);
    }

}
