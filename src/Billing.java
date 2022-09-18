public class Billing {
    private static int BASIC_PLAN = 50;

    private double total;
    private LocalCall localCall;
    private NationalCall nationalCall;
    private InternationalCall internationalCall;

    public Billing(){
        localCall = new LocalCall();
        nationalCall = new NationalCall();
        internationalCall = new InternationalCall();
        savesInfo();
    }

    private void savesInfo(){
        localCall.setMinutesAmount();
        nationalCall.setMinutesAmount();
        internationalCall.setMinutesAmount();
    }

    private double calculatesBill(){
        total = BASIC_PLAN + localCall.getTotalPriceCalls() + nationalCall.getTotalPriceCalls() + internationalCall.getTotalPriceCalls();
        return total;
    }

    public void printsInfo(){
        System.out.println();
        System.out.println("*************************************");
        System.out.println("*************** BILL ****************");
        System.out.println("*************************************");
        System.out.println("*** Basic payment:" + '\t' + '\t'+ '\t' + "$" + BASIC_PLAN);
        System.out.println("*** " + localCall.printCosts());
        System.out.println("*** " + nationalCall.printCosts());
        System.out.println("*** " + internationalCall.printCosts());
        System.out.println("*** Total:" + '\t' + '\t' + '\t' + '\t'+ '\t'+ "$" + calculatesBill());
        System.out.println("*************************************");
    }
}
