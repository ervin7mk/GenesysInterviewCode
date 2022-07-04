package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DigitsTest {

    @Test
    public void noDataGiven() {
        Digits digits = new Digits("");
        digits.mapDigits();
        List<String> solution = List.of();
        Assertions.assertEquals(digits.mappedDigits,solution);
    }

    @Test
    public void invalidLengthRuntimeError() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Digits digits = new Digits("34554");
        },"Digits length too long (must be <= 4)!");
    }

    @Test
    public void invalidDigitRuntimeError() {
        Digits digits = new Digits("213");
        Assertions.assertThrows(RuntimeException.class, () -> {
            digits.mapDigits();
        },"Wrong digit used (must be 2-9 inclusive)!");
    }

    @Test
    public void singleDigit_3LongSolution(){
        Digits digits = new Digits("2");
        digits.mapDigits();
        List<String> solution = Arrays.asList("a","b","c");
        Assertions.assertEquals(digits.mappedDigits,solution);
    }

    @Test
    public void singleDigit_4LongSolution(){
        Digits digits = new Digits("9");
        digits.mapDigits();
        List<String> solution = Arrays.asList("w","x","y","z");
        Assertions.assertEquals(digits.mappedDigits,solution);
    }

    @Test
    public void multipleDigitSolution_1(){
        Digits digits = new Digits("25");
        digits.mapDigits();
        List<String> solution = Arrays.asList("aj","ak","al","bj","bk","bl","cj","ck","cl");
        Assertions.assertEquals(digits.mappedDigits,solution);
    }

    @Test
    public void multipleDigitSolution_2(){
        Digits digits = new Digits("457");
        digits.mapDigits();
        List<String> solution = Arrays.asList("gjp","gjq","gjr","gjs","gkp","gkq","gkr","gks"
                ,"glp","glq","glr","gls","hjp","hjq","hjr","hjs","hkp","hkq","hkr","hks","hlp"
                ,"hlq","hlr","hls","ijp","ijq","ijr","ijs","ikp","ikq","ikr","iks","ilp","ilq"
                ,"ilr","ils");
        Assertions.assertEquals(digits.mappedDigits,solution);
    }

    @Test
    public void multipleDigitSolution_3(){
        Digits digits = new Digits("9782");
        digits.mapDigits();
        List<String> solution = Arrays.asList("wpta","wptb","wptc","wpua","wpub","wpuc","wpva"
                ,"wpvb","wpvc","wqta","wqtb","wqtc","wqua","wqub","wquc","wqva","wqvb","wqvc"
                ,"wrta","wrtb","wrtc","wrua","wrub","wruc","wrva","wrvb","wrvc","wsta","wstb"
                ,"wstc","wsua","wsub","wsuc","wsva","wsvb","wsvc","xpta","xptb","xptc","xpua"
                ,"xpub","xpuc","xpva","xpvb","xpvc","xqta","xqtb","xqtc","xqua","xqub","xquc"
                ,"xqva","xqvb","xqvc","xrta","xrtb","xrtc","xrua","xrub","xruc","xrva","xrvb"
                ,"xrvc","xsta","xstb","xstc","xsua","xsub","xsuc","xsva","xsvb","xsvc","ypta"
                ,"yptb","yptc","ypua","ypub","ypuc","ypva","ypvb","ypvc","yqta","yqtb","yqtc"
                ,"yqua","yqub","yquc","yqva","yqvb","yqvc","yrta","yrtb","yrtc","yrua","yrub"
                ,"yruc","yrva","yrvb","yrvc","ysta","ystb","ystc","ysua","ysub","ysuc","ysva"
                ,"ysvb","ysvc","zpta","zptb","zptc","zpua","zpub","zpuc","zpva","zpvb","zpvc"
                ,"zqta","zqtb","zqtc","zqua","zqub","zquc","zqva","zqvb","zqvc","zrta","zrtb"
                ,"zrtc","zrua","zrub","zruc","zrva","zrvb","zrvc","zsta","zstb","zstc","zsua"
                ,"zsub","zsuc","zsva","zsvb","zsvc");
        Assertions.assertEquals(digits.mappedDigits,solution);
    }



}
