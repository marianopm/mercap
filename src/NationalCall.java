import java.util.Scanner;

public class NationalCall extends Call {
    private static double LONG_DISTANCE_PRICE = 0.26;
    private static String[] longLocation = {"Iruya", "Tartagal", "Purmamarca"};

    private static double MEDIUM_DISTANCE_PRICE = 0.24;
    private static String[] mediumLocation = {"Concordia", "Tanti", "Junin"};

    private static double NEAR_DISTANCE_PRICE = 0.22;
    private static String[] nearLocation = {"Miramar", "Lobos", "Tandil"};

    private String location;

    @Override
    public boolean verifiesInput(){
        boolean auxFound;
        System.out.print("Insert the number of minutes of national calls: ");
        this.minutesAmount = checkError("the number of minutes of national calls: ");
        if(minutesAmount > 0){
            auxFound = auxVerifiesRangeCall();
            if (!auxFound){
                System.out.println("The uploaded location is not in our records");
                return false;
            }
            calculatesCosts();
        }
        else{
            minutesAmount = 0;
        }
        return true;
    }

    public boolean auxVerifiesRangeCall(){
        Scanner scanner = new Scanner(System.in);
        System.out.print('\t' + "Insert to which location the call was made: ");
        location = scanner.nextLine();
        return (checkPlaces(longLocation, location, LONG_DISTANCE_PRICE) ||
                checkPlaces(mediumLocation, location, MEDIUM_DISTANCE_PRICE) ||
                checkPlaces(nearLocation, location, NEAR_DISTANCE_PRICE));
    }

    @Override
    public String printCosts() {
        return "National calls: " + minutesAmount + "*" + priceRate + "=$" + getTotalPriceCalls();
    }
}
