package com.java.bootcamp.fourth_day;

import java.math.BigDecimal;

abstract class Unit {

    enum Type {
        LENGTH,
        VOLUME
    }
    abstract BigDecimal valueInBaseUnit(BigDecimal value);
}
