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

    public Job(int id) {
        /* In the main class, don't forget to initialize a randomizer for integer
         * with the bound (1, 8)
        */
        switch (id) {
            case 1:
                this.name = "Badut Sulap";
                this.dailyPay = 15;
                break;
            case 2:
                this.name = "Koki";
                this.dailyPay = 30;
                break;
            case 3:
                this.name = "Polisi";
                this.dailyPay = 35;
                break;
            case 4:
                this.name = "Programmer";
                this.dailyPay = 45;
                break;
            case 5:
                this.name = "Dokter";
                this.dailyPay = 50;
            case 6:
                this.name = "Mata-mata";
                this.dailyPay = 60;
            case 7:
                this.name = "Pengacara";
                this.dailyPay = 60;
        }
    }

    public String getJobName() {
        return this.name;
    }

    public int getDailyPay() {
        return this.dailyPay;
    }

    public void setJob(String name) throws IllegalArgumentException {
        this.name = name;
        switch (name) {
            case "Badut Sulap":
                dailyPay = 15;
                break;
            case "Koki":
                dailyPay = 30;
                break;
            case "Polisi":
                dailyPay = 35;
                break;
            case "Programmer":
                dailyPay = 45;
                break;
            case "Dokter":
                dailyPay = 50;
                break;
            case "Mata-mata":
                dailyPay = 60;
                break;
            case "Pengacara":
                dailyPay = 60;
                break;
            default:
                throw new IllegalArgumentException("Job tidak ada");
        }
    }

    public void setJob(int id) {
        /* In the main class, don't forget to initialize a randomizer for integer
         * with the bound (1, 8)
        */
        switch (id) {
            case 1:
                this.name = "Badut Sulap";
                this.dailyPay = 15;
                break;
            case 2:
                this.name = "Koki";
                this.dailyPay = 30;
                break;
            case 3:
                this.name = "Polisi";
                this.dailyPay = 35;
                break;
            case 4:
                this.name = "Programmer";
                this.dailyPay = 45;
                break;
            case 5:
                this.name = "Dokter";
                this.dailyPay = 50;
            case 6:
                this.name = "Mata-mata";
                this.dailyPay = 60;
            case 7:
                this.name = "Pengacara";
                this.dailyPay = 60;
        }
    }

}
