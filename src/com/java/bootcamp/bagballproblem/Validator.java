package com.java.bootcamp.bagballproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class Validator {
    Map<String, Function> validators;

    Validator() {
        this.validators = new HashMap<>();
    }

    boolean isValid(Bag bag, Ball ball){
        return false;
    }
}
