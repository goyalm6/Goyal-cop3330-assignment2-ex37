/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution, Exercise 37
 *  Copyright 2021 Mayank Goyal
 */

package ex37;

import java.util.*;
import java.util.Random;
import java.util.ArrayList;

public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        //get user input
        System.out.print("What's the minimum length? ");
        int length = scanner.nextInt();

        System.out.print("How many special characters? ");
        int specialCharacterCount = scanner.nextInt();

        System.out.print("How many numbers? ");
        int numberCount = scanner.nextInt();

        String password = generatePassword(length, specialCharacterCount, numberCount);

        System.out.println("Your password is " + password);
    }

    static String generatePassword(int length, int specialCharacterCount, int numberCount) {
        Random random = new Random();
        List<Character> special = new ArrayList<>();
        specialToArr(special);
        List<Character> numbers = numbersToArr();
        List<Character> alphabets = alphabetsToArr();

        String password = "";
        password = generateAlphabets(random, alphabets, length, specialCharacterCount, numberCount, password);
        password = getSpecialCharacters(random, special, specialCharacterCount, password);
        password = getNumbers(random, numbers, numberCount, password);

        password = ConcatinateAll(random, password);
        return password;
    }

    private static void specialToArr(List<Character> special) {
        String specialChars = "!@#&()–[{}]:;'?/*$^+=<>";
        for(char ch: specialChars.toCharArray())
        {
            special.add(ch);
        }
    }

    private static List<Character> numbersToArr() {
        String nums = "0123456789";
        List<Character> numbers = new ArrayList<>();
        for(char ch: nums.toCharArray())
        {
            numbers.add(ch);
        }
        return numbers;
    }

    private static List<Character> alphabetsToArr() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        List<Character> alphabets = new ArrayList<>();
        for(char ch: letters.toCharArray())
        {
            alphabets.add(ch);
        }
        return alphabets;
    }

    private static String getNumbers(Random random, List<Character> numbers, int numberCount, String password) {
        for (int a = 0; a < numberCount; a++) {
            password += numbers.get(random.nextInt(numbers.size()));
        }
        return password;
    }

    private static String getSpecialCharacters(Random random, List<Character> special, int specialCharacterCount, String password) {
        for (int a = 0; a < specialCharacterCount; a++) {
            password += special.get(random.nextInt(special.size()));
        }
        return password;
    }

    private static String generateAlphabets(Random random, List<Character> alphabets, int length, int specialCharacterCount, int numberCount, String password) {
        for(int a = 0; a < length - specialCharacterCount - numberCount; a++)
        {
            password += alphabets.get(random.nextInt(alphabets.size()));
        }
        return password;
    }

    private static String ConcatinateAll(Random random, String password) {
        char arr[] = password.toCharArray();

        for(int a = arr.length - 1 ; a > 0 ; a--)
        {
            int b = random.nextInt(a+1);
            char temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        password = new String(arr);
        return password;
    }

    /*
    public static void main(String args[])
    {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        List<Character> special = new ArrayList<>();
        String specialChars = "!@#&()–[{}]:;'?/*$^+=<>";

        for(char ch: specialChars.toCharArray())
        {

            special.add(ch);

        }

        String nums = "0123456789";

        for(char ch: specialChars.toCharArray())
        {

            special.add(ch);

        }

        List<Character> numbers = new ArrayList<>();

        for(char ch: nums.toCharArray())
        {

            numbers.add(ch);

        }

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        List<Character> alphabets = new ArrayList<>();

        for(char ch: letters.toCharArray())
        {

            alphabets.add(ch);

        }

        System.out.print("What's the minimum length? ");
        int length = scanner.nextInt();

        System.out.print("How many special characters? ");
        int specialCharacterCount = scanner.nextInt();

        System.out.print("How many numbers? ");
        int numberCount = scanner.nextInt();

        String password = "";

        for(int a = 0 ; a < length - specialCharacterCount - numberCount ; a++)
        {

            password += alphabets.get(random.nextInt(alphabets.size()));

        }

        for(int a = 0 ; a < specialCharacterCount ; a++)
        {

            password+= special.get(random.nextInt(special.size()));

        }

        for(int a = 0 ; a < numberCount ; a++)
        {

            password+=numbers.get(random.nextInt(numbers.size()));

        }

        char arr[] = password.toCharArray();

        for(int a = arr.length - 1 ; a > 0 ; a--)
        {

            int b = random.nextInt(a+1);
            char temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        password = new String(arr);

        System.out.println("Your password is " + password);
    }
    */

}
