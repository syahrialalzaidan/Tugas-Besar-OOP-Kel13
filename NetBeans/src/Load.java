import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;

public class Load {
    public static List<Sim> load(String path) {
        String pathreal = String.format(path+ ".json");
        List<Sim> listsim = null;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(pathreal));
            Type tipe = new TypeToken<List<Sim>>(){}.getType();
            listsim = gson.fromJson(reader, tipe);
        }
        catch (Exception e) {
            System.out.println("Error Loading File with a message : " + e.getMessage());
        }
        return listsim;
    }
}