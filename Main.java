package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<BigInteger> array = new ArrayList<BigInteger>();
    static List<BigInteger> prime = new ArrayList<BigInteger>();


    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        System.out.print("Input first number: ");
        int numone = in.nextInt();
        System.out.print("\n" + "Input second number: ");
        int numtwo = in.nextInt();
        System.out.print("\n" + "Input third number: ");
        int numthree = in.nextInt();
        in.close();
        mod(numone, numtwo, numthree);
        powTwo(BigInteger.valueOf(numone));*/
        generateKey();
    }

    //Katsuraba
    private static BigInteger multiplication(BigInteger i, BigInteger j) {
        BigInteger Ten = new BigInteger("10");
        if (i.compareTo(Ten) == -1 || j.compareTo(Ten) == -1)
            return i.multiply(j);
        String length = getLength(i.max(j));
        BigInteger n = new BigInteger(length);
        if (n.mod(new BigInteger("2")) == new BigInteger("1"))
            n.add(new BigInteger ("1"));

        BigInteger a = i.divide(Ten.pow((n.divide(new BigInteger("2"))).intValue()));
        BigInteger b = i.mod(Ten.pow((n.divide(new BigInteger("2"))).intValue()));
        BigInteger c = j.divide(Ten.pow((n.divide(new BigInteger("2"))).intValue()));
        BigInteger d = j.mod(Ten.pow((n.divide(new BigInteger("2"))).intValue()));

        BigInteger first = multiplication(a,c);
        BigInteger second = multiplication(b,d);
        BigInteger third = multiplication(a.add(b),c.add(d));

        System.out.print(((first.multiply(Ten.pow(n.intValue()))).add (((third.subtract(first).subtract( second)))).multiply(Ten.pow((n.divide(new BigInteger("2"))).intValue())).add(second)));

        return ((first.multiply(Ten.pow(n.intValue()))).add (((third.subtract(first).subtract( second)))).multiply(Ten.pow((n.divide(new BigInteger("2"))).intValue())).add(second));
    }

    public static String getLength( BigInteger a){
        String b = a.toString();
        return Integer.toString(b.length());
    }

    private static BigInteger mod(BigInteger a, BigInteger b, BigInteger c) {
        int i = 0;
        BigInteger k;
        k = BigInteger.valueOf(1);
        List<BigInteger> arr = new ArrayList<>();
        while (b.compareTo(BigInteger.valueOf(0)) > 0){
            while (BigInteger.valueOf((long) Math.pow(2, i)).compareTo(b) > 0){
                i++;
            }
            i--;
            b = b.subtract( BigInteger.valueOf((long) Math.pow(2, i)));
            while (i != 0){
                k = a.pow(2).mod(c);
                i--;
            }
            arr.add(k);
        }
        k = BigInteger.valueOf(1);
        while (arr.size() > 0){
            k = k.multiply(arr.get(arr.size()));
            arr.remove(arr.size());
        }
        k = k.mod(c);
        System.out.print(k);
        return k;
    }

    private void plus(BigInteger i, BigInteger j){
            BigInteger k = i.add(j);
    }

    private static void powTwo(BigInteger i) {
        multiplication(i, BigInteger.valueOf(2));
    }

    private static void generateKey(){
        BigInteger x;
        array.add(BigInteger.valueOf(1145236989 * 523697));
        for (int i=0; i < 100; i++) {
            x = (array.get(i).multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(3)));
            mod(x, BigInteger.valueOf(1), BigInteger.valueOf(63));
            array.add(x);
        }
        ferma();
    }

    private static void ferma(){
        int a;
        for (int i = 0; array.size() > i; i++)
        {
            a = (int) (Math.random() * ((126 - 114) + 1)) + 114; //72057594037927936
            if ((BigInteger.valueOf(a).pow(array.get(i).intValue()).subtract(array.get(i)).mod(BigInteger.valueOf(a)).intValue()) == 0) {
                prime.add(array.get(i));
            }
        }
    }

    private void toBinar() {
        for (int i = 0; prime.size() > i; i++)
        {
            prime.get(i).toString(2);
            prime.add(BigInteger.valueOf(i));
        }
    }
}
