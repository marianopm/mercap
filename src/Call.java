import java.util.Arrays;
import java.util.Scanner;

public abstract class Call {
    public double totalPriceCalls = 0;
    public int minutesAmount = 0;
    public double priceRate = 0;

    public void setMinutesAmount(){
        boolean flagError;
        do{
            flagError = verifiesInput();
        }while(!flagError);
    }

    abstract public boolean verifiesInput();

    public boolean checkPlaces(String[] places, String location, double price){
        boolean contains = Arrays.stream(places).anyMatch(location::equalsIgnoreCase);
        if(contains)
            priceRate = price;
        return contains;
    }

    public void calculatesCosts() {
        totalPriceCalls = minutesAmount * priceRate;
    }

    public double getTotalPriceCalls(){
        return totalPriceCalls;
    }

    public abstract String printCosts();

    public int checkError(String text){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.print('\t' + "That is not a number. Please insert " + text);
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
