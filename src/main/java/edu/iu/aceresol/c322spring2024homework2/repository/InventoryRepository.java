package edu.iu.aceresol.c322spring2024homework2.repository;

import edu.iu.aceresol.c322spring2024homework2.model.Guitar;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class InventoryRepository {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "guitars_database.txt";
    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    private List<Guitar> guitars;

    public InventoryRepository(){
        this.guitars = new ArrayList<>();
    }

    public boolean addGuitar(Guitar g) throws IOException{
        Path path = Paths.get(DATABASE_NAME);
        String data = g.getSerialNumber() + "," +
                g.getPrice() +
                "," + g.getBuilder() + "," + g.getModel() + "," + g.getType() + "," + g.getBackWood() + "," + g.getTopWood();
        appendToFile(path, data + NEW_LINE);
        guitars.add(g);
        return true;
    }

//    public void addGuitar(Guitar g){
//        String serialNumber = g.getSerialNumber();
//        double price = g.getPrice();
//        String builder = g.getBuilder();
//        String model = g.getModel();
//        String type = g.getType();
//        String backWood = g.getBackWood();
//        String topWood = g.getTopWood();
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("guitars_database.txt", true))) {
//            String guitarData = String.format("%s,%f,%s,%s,%s,%s,%s%n",
//                    serialNumber,
//                    price,
//                    builder,
//                    model,
//                    type,
//                    backWood,
//                    topWood);
//
//            writer.write(guitarData);
//
//        } catch (IOException e) {
//            System.err.println("Error writing to the file: " + e.getMessage());
//        }
//    }

    public Guitar getGuitar(String serial) throws IOException {
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        System.out.println(data.size());
        boolean inDatabase = false;
        for (String line : data) {
            String[] words = line.split(",");
            if (Objects.equals(words[0], serial)) {
                inDatabase = true;
                break;
            }
        }
        if (inDatabase){
            for (Guitar g : guitars){
                String currentSerial = g.getSerialNumber();
                if (Objects.equals(currentSerial, serial)){
                    return g;
                }
            }
        }
        return null;
    }


    public List<Guitar> find(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) throws IOException {
        Guitar g = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        return searchGuitars(g);
    }

    public List<Guitar> searchGuitars(Guitar g){
        ArrayList<Guitar> result = new ArrayList<>();
        int attributes = 0;
        for (Guitar guitar : guitars){
            int matchingAttributes = 0;
            if (Objects.equals(g.getSerialNumber(), guitar.getSerialNumber())){
                matchingAttributes++;
            }
            if (Double.compare(g.getPrice(), guitar.getPrice()) == 0) {
                matchingAttributes++;
            }
            if (Objects.equals(g.getBuilder(), guitar.getBuilder())){
                matchingAttributes++;
            }
            if (Objects.equals(g.getModel(), guitar.getModel())){
                matchingAttributes++;
            }
            if (Objects.equals(g.getType(), guitar.getType())){
                matchingAttributes++;
            }
            if (Objects.equals(g.getBackWood(), guitar.getBackWood())){
                matchingAttributes++;
            }
            if (Objects.equals(g.getTopWood(), guitar.getTopWood())){
                matchingAttributes++;
            }
            if (matchingAttributes > attributes){
                result.clear();
                result.add(guitar);
                attributes = matchingAttributes;
            }
            else if(matchingAttributes == attributes){
                result.add(guitar);
            }
        }
        return result;
    }


}
