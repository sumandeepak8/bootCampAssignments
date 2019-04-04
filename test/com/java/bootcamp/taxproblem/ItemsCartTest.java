package com.java.bootcamp.taxproblem;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class ItemsCartTest {

    private static final String GOLD_PATH = "test/data";

    @Test
    void shouldAddTheImportedItemToCart() throws IOException {
        ItemsCart itemsCart = new ItemsCart();
        NonTaxable book = new NonTaxable("book ", 12.49);
        Taxable music_cd = new Taxable("music CD", 14.99);
        NonTaxable chocolate = new NonTaxable("chocolate bar", 0.85);

        itemsCart.addItem(book);
        itemsCart.addItem(music_cd);
        itemsCart.addItem(chocolate);

        equalsFile("1st Output", "output1", itemsCart.statement());

    }


    @Test
    void shouldGiveTheStatementOfImportedGoodsWhichAreNonTaxable() throws IOException {
        NonTaxable box_of_chocolates = new NonTaxable("box of chocolates", 10);
        Taxable bottle_of_perfume = new Taxable("bottle of perfume", 47.50);
        Imported importedChocolates = new Imported(box_of_chocolates);
        Imported importedPerfume = new Imported(bottle_of_perfume);
        ItemsCart itemsCart = new ItemsCart();
        itemsCart.addItem(importedChocolates);
        itemsCart.addItem(importedPerfume);

        equalsFile("1st Output", "output2", itemsCart.statement());
    }

    protected void equalsFile(String message, String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(GOLD_PATH + "/" + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine = null;
        while ((thisFileLine = file.readLine()) != null) {
            assertEquals(thisFileLine, actualStream.readLine());
        }
    }

}