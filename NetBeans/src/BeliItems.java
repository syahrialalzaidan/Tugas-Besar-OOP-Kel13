import java.util.Scanner;

public class BeliItems {
    public static void main(String[] args) throws Exception{
        System.out.println("Berikut adalah items yang tersedia beserta harganya:");
        System.out.println("1. Kasur Single     | 50");
        System.out.println("2. Kasur Queen Size | 100");
        System.out.println("3. Kasur King Size  | 150");
        System.out.println("4. Toilet           | 50");
        System.out.println("5. Kompor Gas       | 100");
        System.out.println("6. Kompor Listrik   | 200");
        System.out.println("7. Meja dan Kursi   | 50");
        System.out.println("8. Jam              | 10");

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nomor item yang ingin dibeli: ");
        int item = input.nextInt();
        int price;
        switch (item) {
            case 1:
                price = 50;
                break;
            case 2:
                price = 100;
                break;
            case 3:
                price = 150;
                break;
            case 4: 
                price = 50;
                break;
            case 5:
                price = 100;
                break;
            case 6:
                price = 200;
                break;
            case 7:
                price = 50;
                break;
            case 8:
                price = 10;
                break;
            default:
                input.close();
                throw new IllegalArgumentException("Item tidak tersedia");
        }
            

        System.out.print("Masukkan jumlah item yang ingin dibeli: ");
        int jumlah = input.nextInt();

        if ((price*jumlah) > 150) {
            System.out.println("Maaf, uang anda tidak cukup untuk membeli item tersebut");
        } else {
            System.out.println("Item berhasil dibeli");
            //code to add item to inventory of the sim
        }
        input.close();
    }
}
