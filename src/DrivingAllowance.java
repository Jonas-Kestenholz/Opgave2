import java.util.Scanner;

public class DrivingAllowance {
    // Array med navnene på månederne
    private static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    private double totalAmount; // Variabel til at holde det samlede beløb for alle kørsler
    private Scanner scanner; // Scanner objekt til at læse brugerinput

    // Constructor, der initialiserer totalAmount og scanner
    public DrivingAllowance() {
        this.totalAmount = 0.0;
        this.scanner = new Scanner(System.in);
    }


    // Metode til at registrere kørsler
    public void registerDrives() {
        String continueRegistering = "Y"; // Variabel til at styre løkken for at fortsætte registreringen
        while (!continueRegistering.equalsIgnoreCase("N")) { // Så længe brugeren ikke skriver 'N', fortsæt registreringen
            System.out.println("Angiv din kørsel med formatet [måned,antal] (fx 1,3): ");
            String registration = scanner.nextLine(); // Læs brugerens input
            String[] values = registration.split(","); // Split inputtet ved komma for at få måned og antal


            int month = Integer.parseInt(values[0]); // Konverter første værdi til en måned (heltal)
            int drives = Integer.parseInt(values[1]); // Konverter anden værdi til antal kørsel (heltal)


            double amount = 0.0;
            if (month >= 1 && month <= 6) {
                amount = drives * 60.0; // Beregn beløbet for de første 6 måneder
            } else if (month >= 7 && month <= 12) {
                amount = drives * 80.0; // Beregn beløbet for de sidste 6 måneder
            }

            String monthName = MONTHS[month - 1]; // Få navnet på måneden baseret på index
            totalAmount += amount; // Tilføj beløbet til det samlede beløb

            System.out.println("Måned: " + monthName + ", Beregnet beløb: " + amount);

            System.out.println("Vil du fortsætte med at registrere? (Y/N): ");
            continueRegistering = scanner.nextLine(); // Læs brugerens beslutning om at fortsætte eller ej
        }


        System.out.println("Samlet beløb for alle registreringer: " + totalAmount);
    }


}