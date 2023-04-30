public class JobDriver {
    public static void main(String[] args) throws Exception {
        Job job1 = new Job();
        System.out.println(job1.getJobName());
        System.out.println(job1.getDailyPay());

        Job job2 = new Job("Programmer");
        System.out.println(job2.getJobName());
        System.out.println(job2.getDailyPay());

        Job job3 = new Job();
        System.out.println(job3.getJobName());
        System.out.println(job3.getDailyPay());
    }
}
