package main;

import java.util.ArrayList;
import java.util.List;

public class Digits {

    protected String digits;
    protected List<String> mappedDigits;

    public Digits(String digits) {
        if (digits.length() <= 4) {
            this.digits = digits;
            this.mappedDigits = new ArrayList<>();
        } else throw new RuntimeException("Digits length too long (must be <= 4)!");
    }

    public void mapDigits() {
        List<String> allValues = new ArrayList<>();
        for (int i = 0; i < digits.length(); ++i) {
            allValues.add(getDigitValues(digits.charAt(i)));
        }
        int index;
        for (int i = 0; i < allValues.size(); ++i) {

            int lengthToFill = 1;
            for (int k = i+1; k < allValues.size() ; ++k) {
                lengthToFill *= allValues.get(k).length();
            }

            int charToFill = allValues.get(i).length();
            int l = 0;
            int p = 0;

            if (i == 0) { // firstly, I'll add the first character of all the list elements
                while (p < charToFill) {
                    if (l < lengthToFill) {
                        String s = "" + allValues.get(i).charAt(p);
                        mappedDigits.add(s);
                        ++l;
                    } else {
                        l = 0;
                        ++p;
                    }
                }
            } else { // here I'll add all the other characters to the list
                index = 0;
                while (index < mappedDigits.size()) {
                    while (p < charToFill) {
                        if (l < lengthToFill) {
                            String s = "" + allValues.get(i).charAt(p);
                            String newElement = mappedDigits.get(index) + s;
                            mappedDigits.set(index, newElement);
                            ++l;
                            ++index;
                        } else {
                            l = 0;
                            ++p;
                        }
                    }
                    p = 0;
                }
            }
        }
    }

    public void showMappedDigits() {
        System.out.print("[");
        for (int i = 0; i < mappedDigits.size(); ++i) {
            if (i + 1 < mappedDigits.size()) System.out.print("\"" + mappedDigits.get(i) + "\",");
            else System.out.print("\"" + mappedDigits.get(i) + "\"");
        }
        System.out.print("]");
    }

    private String getDigitValues(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                throw new RuntimeException("Wrong digit used (must be 2-9 inclusive)!");
        }
    }


    public static void main(String[] args) {
        Digits d = new Digits("23");
        d.mapDigits();
        d.showMappedDigits();
    }
}
