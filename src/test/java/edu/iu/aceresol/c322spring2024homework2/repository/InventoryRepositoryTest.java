package edu.iu.aceresol.c322spring2024homework2.repository;

import edu.iu.aceresol.c322spring2024homework2.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//
class InventoryRepositoryTest {

    @Test
    void addGuitarTest() throws IOException {
        Guitar test = new Guitar();
        test.setSerialNumber("3211");
        test.setPrice(11.00);
        test.setBuilder(Guitar.Builder.valueOf("FENDER"));
        test.setModel("v1");
        test.setType(Guitar.Type.valueOf("ELECTRIC"));
        test.setBackWood(Guitar.Wood.valueOf("MAPLE"));
        test.setTopWood(Guitar.Wood.valueOf("CEDAR"));
        InventoryRepository.addGuitar(test);

        Guitar test1 = new Guitar();
        test1.setSerialNumber("1234");
        test1.setPrice(12.00);
        test1.setBuilder(Guitar.Builder.valueOf("GIBSON"));
        test1.setModel("v1");
        test1.setType(Guitar.Type.valueOf("ACOUSTIC"));
        test1.setBackWood(Guitar.Wood.valueOf("MAHOGANY"));
        test1.setTopWood(Guitar.Wood.valueOf("MAPLE"));
        InventoryRepository.addGuitar(test1);


    }

    @Test
    void getGuitarTest() throws IOException {
        Guitar g = InventoryRepository.getGuitar("1111");
        Guitar g1 = InventoryRepository.getGuitar("1234");



    }

    @Test
    void searchTest() throws IOException {
        Guitar g = new Guitar();

        g.setBuilder(Guitar.Builder.valueOf("FENDER"));
        g.setPrice(10.00);

        List<Guitar> testList = InventoryRepository.search(g);

    }
}