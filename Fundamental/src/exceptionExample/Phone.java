package exceptionExample;

public class Phone {
    String phoneType;
    String phoneNumber;

    public Phone(String pT, String pN) {
        if (pT == null || pN == null) {
            throw new IllegalArgumentException("The type and number cannot be null");
        }
        phoneNumber = pN;
        phoneType = pT;
    }
}
