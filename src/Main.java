import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int carSum = 0;
        float proceeds = 0;
        boolean quit = false;


        do {
            System.out.println("Καλώς ήρθατε \n" +
                    "παρακαλώ πληκτρολογήστε 1 για χρέωση οχήματος \n" +
                    "                        2 για Σύνολο αυτοκινήτων και εσόδων \n" +
                    "                        3 για έξοδο. \n" +
                    "πληκτρολογήστε την επιλογή σας: ");
            int selection = getInt();
            switch (selection) {
                case 1:
                    float hours = getFloat();
                    float charges = calculateCharges(hours);
                    proceeds += charges;
                    carSum++;
                    System.out.println("Η τελική χρέωση συνολικά για " + hours + " ώρες είναι: " + charges + " ευρώ" + "\n ευχαριστούμε πολύ για την προτίμηση που μας δείξατε ελπίζουμε να συνεργαστούμε ξανά.");
                    break;
                case 2:
                    System.out.println("Συνολικά έχουν εξυπηρετηθεί " + carSum + " οχήματα και τα συνολικά κέρδη ανέρχονται στα " + proceeds + " ευρώ.");
                    break;
                case 3:
                    quit = true;
                    break;
            }
        } while (!quit);

    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        do {

            try {
                int selection = scanner.nextInt();
                if (selection >= 1 && selection <= 3) {
                    return selection;
                } else {
                    System.out.println("Η επιλογή σας δεν ήταν 1,2 ή 3. Παρακαλώ προσπαθήστε ξανά");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Η επιλογή σας δεν ήταν έγκυρη παρακαλώ προσπαθήστε ξανά (Η επιλογή μπορεί να είναι 1,2 ή 3)");
            }
        } while (true);
    }

    private static float getFloat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Παρακαλώ καταχωρίστε την/τις ώρες παραμονής του οχήματος στο parking.");
        do {
            try {
                float selection = scanner.nextFloat();
                if (selection > 0 && selection <= 24) {
                    return selection;
                } else {
                    System.out.println("Η επιλογή σας δεν ήταν απο 1 έως 24 ώρες. Παρακαλώ προσπαθήστε ξανά");
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Η επιλογή σας δεν ήταν έγκυρη παρακαλώ προσπαθήστε ξανά.");
            }

        } while (true);
    }


    public static float calculateCharges(float hours) {
        if (hours <= 3) {
            return 2;
        } else if (hours <= 19) {
            return (float) ((hours - 3) * 0.5 + 2);
        } else {
            return 10;
        }
    }
}