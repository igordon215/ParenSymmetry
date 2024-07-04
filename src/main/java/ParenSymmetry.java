import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        int balance = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                balance++;
            }else if (c == ')') {
                balance--;
                if (balance < 0 ){
                    return false;
                }
            }
        }
        return balance == 0;
    }

    private void checkFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String x;

        while ((x = br.readLine()) != null) {
            System.out.println(isBalanced(x));
        }


        // open file named filename

        // for each line in the file
        // read the line
        // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);



    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }





}
