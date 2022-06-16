package miniproject.service;

import miniproject.entity.Entity;
import miniproject.exception.InvalidValueException;

public class ServiceIMC{
    
    public float calculate(Entity data) throws InvalidValueException{
        float w = data.getWeight();
        float h = 0f;
        if (data.getHigh() != 0f) {
            h = data.getHigh();
        } else if (data.getHigh() == 0) {
            throw new InvalidValueException("Erro Aritmético! Não é possível dividir por ZERO\nou um número negativo foi inserido!.");
        }

        float imc = w / ((float)Math.pow(h, 2));

        return imc;
    }
}
