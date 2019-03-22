package com.java.bootcamp.fourth_day;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class Unit {

    static final Unit INCH = new Unit(new BigDecimal(1), Type.LENGTH);
    static final Unit FEET = new Unit(new BigDecimal(12), Type.LENGTH);
    static final Unit CENTIMETER = new Unit(new BigDecimal(0.4), Type.LENGTH);
    static final Unit MILLIMETER = new Unit(new BigDecimal(0.04), Type.LENGTH);

    static final Unit LITRE = new Unit(new BigDecimal(1), Type.VOLUME);
    static final Unit GALLON = new Unit(new BigDecimal(3.78), Type.VOLUME);

    private enum Type {
        LENGTH,
        VOLUME
    }

    static Map<Type,Unit> standardOutputUnits = new HashMap<>();

    static{
        standardOutputUnits.put(Type.LENGTH,Unit.INCH);
        standardOutputUnits.put(Type.VOLUME,Unit.LITRE);
    }

    private final BigDecimal RATIO;
    private final Type TYPE;

    private Unit(BigDecimal ratio,Type type) {
        this.RATIO = ratio;
        this.TYPE = type;
    }

    BigDecimal valueInBaseUnit(BigDecimal value) {
        return BigDecimal.valueOf(this.RATIO.multiply(value).floatValue());
    }

    public boolean isOfSameType(Unit unit) {
        return this.TYPE == unit.TYPE;
    }

    public Unit getBaseUnit() {
        return standardOutputUnits.get(this.TYPE);
    }

}
