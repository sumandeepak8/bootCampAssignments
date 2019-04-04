package com.java.bootcamp.taxproblem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ItemsCart {

    private List<Item> itemsList;
    private final String OneSpace = " ";
    private final String ENTER = "\n";

    ItemsCart() {
        this.itemsList = new ArrayList<>();
    }

    String getTotalTax() {
        DecimalFormat df = new DecimalFormat("#.00");
        double tax = 0;
        for (Item item : this.itemsList) {
            tax += item.totalTax();
        }
        String angleFormated = df.format(tax);
        return angleFormated;
    }


    String statement() {
        double totalAmount = 0;
        Iterator<Item> items = itemsList.iterator();
        StringBuilder statement = new StringBuilder();
        while (items.hasNext()) {
            double thisAmount = 0;
            Item item = items.next();
            thisAmount = item.totalPrice();

            totalAmount += thisAmount;
            if (item instanceof Imported) {
                statement.append(1).append(" imported").append(OneSpace).append(item.getName()).append(":").append(OneSpace).append(item.totalPrice()).append(ENTER);
            } else {
                statement.append(1).append(OneSpace).append(item.getName()).append(":").append(OneSpace).append(item.totalPrice()).append(ENTER);
            }
        }

        String tax = this.getTotalTax();
        System.out.println("this is tax " + tax);
        statement.append("Sales Taxes: ").append(tax).append(ENTER);
        statement.append("Total: ").append(totalAmount).append(ENTER);
        return statement.toString();
    }

    public void addItem(Item item) {
        this.itemsList.add(item);
    }
}
