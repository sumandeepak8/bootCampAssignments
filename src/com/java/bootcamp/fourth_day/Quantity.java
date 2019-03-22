package com.java.bootcamp.fourth_day;

import java.math.BigDecimal;

class Quantity {
    private final BigDecimal value;
    private final Unit unit;

    Quantity(BigDecimal value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        if (!this.unit.isOfSameType(quantity.unit)) return false;
        BigDecimal firstValueInBaseUnit = this.unit.valueInBaseUnit(this.value);
        BigDecimal secondValueInBaseUnit = quantity.unit.valueInBaseUnit(quantity.value);
        return firstValueInBaseUnit.equals(secondValueInBaseUnit);
    }

    Quantity addWith(Quantity anotherQuantity) throws QuantityUnitMismatchException {
        if (!this.unit.isOfSameType(anotherQuantity.unit)) {
            throw new QuantityUnitMismatchException();
        }

        BigDecimal firstValueInBase = this.unit.valueInBaseUnit(this.value);
        BigDecimal secondValueInBase = anotherQuantity.unit.valueInBaseUnit(anotherQuantity.value);
        float totalInFloat = firstValueInBase.add(secondValueInBase).floatValue();

        int sum = Math.round(totalInFloat);
        Unit baseUnit = anotherQuantity.unit.getBaseUnit();
        return new Quantity(new BigDecimal(sum), baseUnit);
    }

}