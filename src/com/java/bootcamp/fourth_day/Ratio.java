package com.java.bootcamp.fourth_day;

import java.math.BigDecimal;

class Ratio extends Unit{

    private final BigDecimal RATIO;
    private final Type TYPE;

    static final Ratio INCH = new Ratio(new BigDecimal(1), Type.LENGTH);
    static final Ratio FEET = new Ratio(new BigDecimal(12), Type.LENGTH);
    static final Ratio CENTIMETER = new Ratio(new BigDecimal(0.4), Type.LENGTH);
    static final Ratio MILLIMETER = new Ratio(new BigDecimal(0.04), Type.LENGTH);

    static final Ratio LITRE = new Ratio(new BigDecimal(1), Type.VOLUME);
    static final Ratio GALLON = new Ratio(new BigDecimal(3.78), Unit.Type.VOLUME);

    private Ratio(BigDecimal ratio, Unit.Type type) {
        this.RATIO = ratio;
        this.TYPE = type;
    }

    boolean isOfSameType(Ratio ratioUnit) {
        return this.TYPE ==  ratioUnit.TYPE;
    }

    @Override
    BigDecimal valueInBaseUnit(BigDecimal value) {
         return this.RATIO.multiply(value);
    }
}
