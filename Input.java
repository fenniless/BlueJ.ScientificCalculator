/**
 * Takes in a string via user input and parses the two ints or doubles the mathematical operator using regex.
 *
 * Mark Moll Feb 10 2019
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Input {
    private static Calculations calc = new Calculations();
    public static double userInput(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        double state = 0;
        String pattern = ("(\\b(sin|cos|tan|sec|csc|cot))?\\s*(-?(\\d+)(\\.\\d+)?)\\s*([+\\-÷−*x·/])\\s*(\\b(sin|cos|tan|sec|csc|cot))?\\s*(-?(\\d+)(\\.\\d+)?)");
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        m.matches();
        String stringTrig1 = m.group(1);
        String stringTrig2 = m.group(7);
        String stringNum1 = m.group(3);
        String stringNum2 = m.group(9);
        String stringOp = m.group(6);
        double unsignedFirstNum = Double.parseDouble(stringNum1);
        double unsignedSecondNum = Double.parseDouble(stringNum2);
        double result = 0.0;
        if (stringOp.equals("/") && unsignedSecondNum == 0){System.out.println("Error! Please don't divide by zero.");
            //} else if (m.find(1) || m.find(7){
            //    switch(Trig1)
        }
        // Evaluates as radians if present
        if(stringTrig1 != null){
            switch (stringTrig1) {
                case"sin": unsignedFirstNum = calc.sin(unsignedFirstNum);
                break;
                case"cos": unsignedFirstNum = calc.cos(unsignedFirstNum);
                break;
                case"tan": unsignedFirstNum = calc.tan(unsignedFirstNum);
                break;
                case"sec": unsignedFirstNum = (1 / calc.cos(unsignedFirstNum));
                break;
                case"csc": unsignedFirstNum = (1 / calc.sin(unsignedFirstNum));
                break;
                case"cot": unsignedFirstNum = (1 / calc.tan(unsignedFirstNum));
                break;}}
        if(stringTrig2 != null){
            switch (stringTrig2) {
                case"sin": unsignedSecondNum = calc.sin(unsignedSecondNum);
                break;
                case"cos": unsignedSecondNum = calc.sin(unsignedSecondNum);
                break;
                case"tan": unsignedSecondNum = calc.sin(unsignedSecondNum);
                break;
                case"sec": unsignedSecondNum = (1 / calc.cos(unsignedSecondNum));
                break;
                case"csc": unsignedSecondNum = (1 / calc.sin(unsignedSecondNum));
                break;
                case"cot": unsignedSecondNum = (1 / calc.tan(unsignedSecondNum));
                break;}}
        switch(stringOp) {
            case"+": result = calc.add(unsignedFirstNum,unsignedSecondNum);
            break;
            case"-": case"−": result = calc.subtract(unsignedFirstNum,unsignedSecondNum);
            break;
            case"*": case"x": case"·": result = calc.multiply(unsignedFirstNum,unsignedSecondNum);
            break;
            case"/": result = calc.divide(unsignedFirstNum,unsignedSecondNum);
            break;
            case"^": result = calc.pow(unsignedFirstNum,unsignedSecondNum);
            break;
        }
        double memoryResult = result;
        System.out.println(result);
        result = 0.0;
        return result;
    }
}
