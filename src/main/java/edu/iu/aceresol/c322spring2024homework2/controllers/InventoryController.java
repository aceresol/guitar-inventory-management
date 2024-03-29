package edu.iu.aceresol.c322spring2024homework2.controllers;

import edu.iu.aceresol.c322spring2024homework2.model.*;
import edu.iu.aceresol.c322spring2024homework2.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryRepository inventoryRepository;
    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }
    @PostMapping("/add")
    public boolean add(@RequestBody Guitar data) {
        try {
            return inventoryRepository.addGuitar(data);
        } catch (IOException e){
            return false;
        }
    }

    @RequestMapping("/findAll")
    public List<Guitar> findAll() {
        try {
            return inventoryRepository.findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search")
    public List<Guitar> search (@RequestParam String serialNumber, @RequestParam double price, @RequestParam Guitar.Builder builder, @RequestParam String model,@RequestParam Guitar.Type type,@RequestParam Guitar.Wood backWood, @RequestParam Guitar.Wood topWood){
        try {
            Guitar g = new Guitar();

            g.setSerialNumber(serialNumber);
            g.setPrice(price);
            g.setBuilder(builder);
            g.setModel(model);
            g.setType(type);
            g.setBackWood(backWood);
            g.setTopWood(topWood);

            return inventoryRepository.search(g);
        } catch (IOException e){
            return null;
        }
    }

    @GetMapping("/find/{serialNumber}")
    public Guitar find (@RequestParam String serialNumber){
        try {
            System.out.println(serialNumber);

            return inventoryRepository.getGuitar(serialNumber);
        } catch (IOException e){
            return null;
        }
    }
}