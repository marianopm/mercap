import java.util.Scanner;

public class InternationalCall extends Call{
    private static double AMERICA_PRICE = 0.3;
    private static String[] nearDistanceCountry = {"Colombia", "Brasil", "Mexico"};

    private static double AFRICA_PRICE = 0.5;
    private static String[] mediumDistanceCountry = {"Egipto", "Chad", "Ghana"};

    private static double EUROPE_PRICE = 0.7;
    private static String[] longDistanceCountry = {"Dinamarca", "Inglaterra", "Italia", "Polonia"};

    private String country;

    @Override
    public boolean verifiesInput(){
        boolean auxFound;
        System.out.print("Insert the number of minutes of international calls: ");
        this.minutesAmount = checkError("the number of minutes of international calls: ");
        if(minutesAmount > 0){
            auxFound = auxVerifiesRangeCall();
            if (!auxFound){
                System.out.println("The uploaded country is not in our records");
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
        System.out.print('\t' + "Insert to which country the call was made: ");
        country = scanner.nextLine();
        return (checkPlaces(nearDistanceCountry, country, AMERICA_PRICE) ||
                checkPlaces(mediumDistanceCountry, country, AFRICA_PRICE) ||
                checkPlaces(longDistanceCountry, country, EUROPE_PRICE));
    }

    @Override
    public String printCosts() {
        return "International calls: " + minutesAmount + "*" + priceRate + "=$" + getTotalPriceCalls();
    }
}
