package edu.iu.aceresol.c322spring2024homework2.repository;

import edu.iu.aceresol.c322spring2024homework2.model.Builder;
import edu.iu.aceresol.c322spring2024homework2.model.Guitar;
import edu.iu.aceresol.c322spring2024homework2.model.Type;
import edu.iu.aceresol.c322spring2024homework2.model.Wood;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//
class InventoryRepositoryTest {
    Guitar test = new Guitar("12345", 10.00, Builder.FENDER, "123abc", Type.ACOUSTIC, Wood.MAPLE, Wood.INDIAN_ROSEWOOD);
    Guitar test2 = new Guitar("12346", 9.00, Builder.FENDER, "123cd", Type.ELECTRIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER);
    Guitar test3 = new Guitar("12347", 11.00, Builder.GIBSON, "145fpg", Type.ACOUSTIC, Wood.CEDAR, Wood.SITKA);
    Guitar test4 = new Guitar(null, 11.00, null, null, null, Wood.MAPLE, null);
    Guitar test5 = new Guitar("12348", 11.00, Builder.PRS, "145fpg", Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.BRAZILIAN_ROSEWOOD);
    Guitar test6 = new Guitar("12349", 11.00, Builder.PRS, "145fpg", Type.ELECTRIC, Wood.MAPLE, Wood.BRAZILIAN_ROSEWOOD);

    InventoryRepository inventoryRepository = new InventoryRepository();

    @Test
    void addGuitar() throws IOException {
        inventoryRepository.addGuitar(test);
        inventoryRepository.addGuitar(test3);
        inventoryRepository.addGuitar(test6);
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
        ArrayList<Guitar> testList = new ArrayList<>();
        testList.add(test6);
        assertEquals(testList.get(0).getSerialNumber(), inventoryRepository.searchGuitars(test4).get(0).getSerialNumber());
    }
}