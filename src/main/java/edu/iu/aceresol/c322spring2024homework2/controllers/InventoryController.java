package edu.iu.aceresol.c322spring2024homework2.controllers;

import edu.iu.aceresol.c322spring2024homework2.model.Guitar;
import edu.iu.aceresol.c322spring2024homework2.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryRepository inventoryRepository;
    public InventoryController(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/search")
    public List<Guitar> search(@RequestParam String serialNumber,
                               @RequestParam double price,
                               @RequestParam String builder,
                               @RequestParam String model,
                               @RequestParam String type,
                               @RequestParam String backWood,
                               @RequestParam String topWood) {
        try {
            System.out.println(serialNumber);
            System.out.println(price);
            System.out.println(builder);
            System.out.println(model);
            System.out.println(type);
            System.out.println(backWood);
            System.out.println(topWood);
            return inventoryRepository.find(serialNumber, price, builder, model, type, backWood, topWood);
        } catch (IOException e) {
            return null;
        }
    }

    @PostMapping
    public boolean add(@RequestBody Guitar g){
        try {
            return inventoryRepository.addGuitar(g);
        } catch (IOException e){
            return false;
        }
    }

    @GetMapping("/find")
    public Guitar find(@RequestParam String serialNumber) throws IOException {
        return inventoryRepository.getGuitar(serialNumber);
    }


}
