package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Integer> array = new ArrayList<Integer>();
    List<Integer> prime = new ArrayList<Integer>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input first number: ");
        int numone = in.nextInt();
        System.out.print("\n" + "Input second number: ");
        int numtwo = in.nextInt();
        System.out.print("\n" + "Input third number: ");
        int numthree = in.nextInt();
        in.close();
        mod(numone, numtwo, numthree);
        powTwo(BigInteger.valueOf(numone));
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

    private static int mod(int a, int b, int c) {
        int i = 0;
        int k = 0;
        List<Integer> arr = new ArrayList<Integer>();
        while (b > 0){
            while ((int) Math.pow(2, i) <= b){
                i++;
            }
            i--;
            b = b - (int) Math.pow(2, i);
            while (i != 0){
                k = (int) Math.pow(a, 2) % c;
                i--;
            }
            arr.add(k);
        }
        k = 1;
        while (arr.size() > 0){
            k = k * arr.get(arr.size());
            arr.remove(arr.size());
        }
        k = k % c;
        System.out.print(k);
        return k;
    }

    private void plus(BigInteger i){

    }

    private static void powTwo(BigInteger i) {
        multiplication(i, BigInteger.valueOf(2));
    }

    private void generateKey (){
        int x;
        array.add(6);
        x = (array.get(array.size()) * 5 + 28);
        mod(x, 1, 63);
        ferma();
    }

    private void ferma (){
        int a;
        for (int i = 0; array.size() > i; i++)
        {
            a = (int) (Math.random() * ((126 - 114) + 1)) + 114;
            if (((Math.pow(a, array.get(i)) - array.get(i)) % a) == 0) {
                prime.add(array.get(i));
            }
        }
    }

}
