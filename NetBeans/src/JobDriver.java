import java.util.Random;

public class JobDriver {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        Job job1 = new Job(rand.nextInt(1, 8));
        System.out.println(job1.getJobName());
        System.out.println(job1.getDailyPay());
        job1.setJob("Badut Sulap");
        System.out.println(job1.getJobName());
        System.out.println(job1.getDailyPay());
    }
}
