import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Load {
    public static Sim load(String path) {
        String pathreal = String.format(path+ ".json");
        Sim world = null;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(pathreal));
            world = gson.fromJson(reader, Sim.class);
        
            System.out.println("Data loaded from " + path + " successfully.");
        }
        catch (Exception e) {
            System.out.println("Gagal melakukan load file " + path + ". Pesan error: " + e.getMessage());
        }
        return world;
    }
}