import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Save {
    public static void save(String filename, List<Sim> listSim) {
        String fileName = String.format(filename+ ".json");
        Path path = Paths.get(fileName);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            Gson gson = new GsonBuilder()
                    .enableComplexMapKeySerialization()
                    .setPrettyPrinting().create();
            JsonElement tree = gson.toJsonTree(listSim);
            gson.toJson(tree, writer);

            System.out.println("Game Saved!");
        } catch (Exception e) {
            System.out.println("Save Failed with an Error Message : " + e.getMessage());
        }
    }
}
