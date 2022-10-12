import java.text.NumberFormat;
import java.util.Scanner;

public class AdvancedMortgageCalc {
    public static void main(String[] args) {
        System.out.println("Advanced Mortgage Calculator. \n Please follow the on screen instructions");
        Scanner input = new Scanner(System.in);
        int principal = 0;
        float annualInterestRate = 0.0F;
        short period = 0;

        while (true) {
            System.out.print("Enter principal amount: \t");
            principal = input.nextInt();
            if(principal >= 1_000 && principal <= 1000000 ) {
                break;
            }
            System.out.println("Principal amount should be within $1,000 - $1,000,000: \t");
            continue;
        }

        while (true) {
            System.out.print("Enter Annual Interest: \t");
            annualInterestRate = input.nextFloat();
            if(annualInterestRate > 0 && annualInterestRate <= 30 ) {
                break;
            }
            System.out.println("Annual Interest should be within 0.1% to 30%: \t");
            continue;
        }
        float monthlyInterestRate = annualInterestRate / 100 / 12;
        System.out.print("Monthly interest rate would be " + monthlyInterestRate + "\n");

        while (true) {
            System.out.print("Enter Period (amount of years): \t");
            period = input.nextShort();
            if(period > 0 && period <= 30 ) {
                break;
            }
            System.out.println("Period should be within 1 to 30 years: \t");
            continue;
        }
        period *= 12;
        System.out.print("Calculating, please wait...");
        double morgage = principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, period))/(Math.pow(1 + monthlyInterestRate, period) - 1));
        System.out.println("Mortgage is " + NumberFormat.getCurrencyInstance().format(morgage));
    }
}
