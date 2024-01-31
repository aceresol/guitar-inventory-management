package edu.iu.aceresol.c322spring2024homework2.repository;

import edu.iu.aceresol.c322spring2024homework2.model.Guitar;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//
class InventoryRepositoryTest {
    Guitar test = new Guitar("12345", 10.00, "Anthony", "123abc", "Wood", "brown", "tan");
    Guitar test2 = new Guitar("12346", 9.00, "Anthony", "123cd", "Metal", "black", "tan");
    Guitar test3 = new Guitar("12347", 11.00, "Anthony", "145fpg", "Electric", "white", "white");
    Guitar test4 = new Guitar(null, 11.00, null, null, null, "white", null);
    Guitar test5 = new Guitar("12348", 11.00, "Anthony", "145fpg", "Electric", "white", "white");

    InventoryRepository inventoryRepository = new InventoryRepository();

    @Test
    void addGuitar() throws IOException {
        inventoryRepository.addGuitar(test);
        inventoryRepository.addGuitar(test3);
    }

    @Test
    void getGuitar() throws IOException {
//        inventoryRepository.addGuitar(test);
//        inventoryRepository.addGuitar(test3);
        assertEquals(test.getSerialNumber(), inventoryRepository.getGuitar("12345").getSerialNumber());
        assertEquals(test3.getSerialNumber(), inventoryRepository.getGuitar("12347").getSerialNumber());
    }

    @Test
    void searchGuitars() throws IOException {
        inventoryRepository.addGuitar(test3);
        inventoryRepository.addGuitar(test5);
        ArrayList<Guitar> testList = new ArrayList<>();
        testList.add(test3);
        testList.add(test5);
        assertEquals(testList, inventoryRepository.searchGuitars(test4));
    }
}