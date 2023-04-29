/**
 *
 * @author ilmag
 */

/**
 * Class Job
 */

public class Job {
    private String name;
    private int dailyPay;

    public Job(String name) {
        this.name = name;

        switch(name) {
            case "Badut Sulap":
                dailyPay = 15;
            case "Koki":
                dailyPay = 30;
            case "Polisi":
                dailyPay = 35;
            case "Programmer":
                dailyPay = 45;
            case "Dokter":
                dailyPay = 50;
            case "Mata-mata":
                dailyPay = 60;
            case "Pengacara":
                dailyPay = 60;
        }


    }

    public String getJobName() {
        return this.name;
    }

    public int getDailyPay() {
        return this.dailyPay;
    }
}
