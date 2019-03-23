package com.java.bootcamp.pizzaProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Description {
    private List<String> description;

    Description() {
        this.description = new ArrayList<>();
    }

    void addDescription(String message) {
        this.description.add(message);
    }

    void print() {
        for (String descriptionMessage : this.description) {
            System.out.println(descriptionMessage);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }
}
