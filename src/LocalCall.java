import java.util.Scanner;

public class LocalCall extends Call {

    private static double WORKING_DATE_RATE = 0.2;
    private static double NON_WORKING_DATE_RATE = 0.1;

    private int minutesWorkingHours;
    private int minutesNonWorkingHours;
    private int minutesAmount;

    @Override
    public boolean verifiesInput(){
        System.out.print("Insert the total number of minutes of local calls: ");
        this.minutesAmount = checkError("the number of minutes of local calls: ");
        if(minutesAmount > 0) {
            rangeHour();
            if(minutesAmount != (minutesWorkingHours + minutesNonWorkingHours)){
                minutesNonWorkingHours = minutesWorkingHours = 0;
                System.out.println("There is an error uploading minutes");
                return false;
            }
            calculatesCosts();
        }
        return true;
    }

    private void rangeHour(){
        System.out.print('\t' + "Insert how many minutes were done in working hours: ");
        minutesWorkingHours = checkError("the number of minutes done in working hours: ");
        System.out.print('\t' + "Insert how many minutes were done in non-working hours: ");
        minutesNonWorkingHours = checkError("the number of minutes done in non-working hours: ");
    }

    @Override
    public void calculatesCosts() {
        totalPriceCalls = minutesWorkingHours*WORKING_DATE_RATE + minutesNonWorkingHours*NON_WORKING_DATE_RATE;
    }

    @Override
    public String printCosts() {
        return "Local calls: " + minutesWorkingHours + "*" + WORKING_DATE_RATE + "+" +
                minutesNonWorkingHours + "*" + NON_WORKING_DATE_RATE + "=" + "$" + getTotalPriceCalls();
    }
}
