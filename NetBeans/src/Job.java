import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ilmag
 */

/**
 * Class Job
 */

public class Job {
    private static HashMap<String, Integer> jobs = new HashMap<String, Integer>();
    private String name;
    private int dailyPay;

    static {
        jobs.put("Badut Sulap", 15);
        jobs.put("Koki", 30);
        jobs.put("Polisi", 35);
        jobs.put("Programmer", 45);
        jobs.put("Dokter", 50);
        jobs.put("Mata-mata", 60);
        jobs.put("Pengacara", 60);
    }

    public Job() {
        int randomIndex = randomize();
        List<String> jobKeys = new ArrayList<String>(jobs.keySet());
        this.name = jobKeys.get(randomIndex);
        this.dailyPay = jobs.get(name);

    }

    public Job(String name) throws Exception {
        if (jobs.containsKey(name)) {
            this.name = name;
            this.dailyPay = jobs.get(name);
        } else {
            throw new Exception("Job name not in list of jobs!");
        }

    }

    public String getJobName() {
        return this.name;
    }

    public int getDailyPay() {
        return this.dailyPay;
    }

    public void setJob(String name) throws Exception {
        if (jobs.containsKey(name)) {
            this.name = name;
            this.dailyPay = jobs.get(name);
        } else {
            throw new Exception("Job name not in list of jobs!");
        }
    }

    public int randomize() {
        long currentTime = System.currentTimeMillis();
        Random random = new Random(currentTime);
        Set<String> keySet = jobs.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        int randomIndex = random.nextInt(keyArray.length);
        return randomIndex;
    }
}
