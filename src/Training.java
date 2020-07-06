import java.math.BigInteger;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
public class Training {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        a="_"+a;
        String b = in.nextLine();
        b="_"+b;
        String x = in.nextLine();
        System.out.println("You entered string "+x);
        for (NumerationSystemType day : NumerationSystemType.values()) {
            if (a.equals(day.name())){

                Number number = new Number(day, x);
                for (NumerationSystemType day1 : NumerationSystemType.values()) {
                if (b.equals(day1.name())) {
                    Number result = convertNumberToOtherNumerationSystem(number, day1);
                    System.out.println(result);
                }
                }
            }

        }

    }
    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        Number result = null;
        int system = number.getNumerationSystem().getNumerationSystemIntValue();

        try {
            String strNum = "" + new BigInteger(number.getDigit(), system);
            BigInteger a= new BigInteger(strNum);
            String s = a.toString(expectedNumerationSystem.getNumerationSystemIntValue());
            result = new Number(expectedNumerationSystem, s);

        } catch (Exception e){
            throw new NumberFormatException();
        }
        return result;
    }

}