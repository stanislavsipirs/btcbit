package org.homework;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Music music = readMusic();
            int semitones = readSemitones();
            Music result = music.transpose(semitones);
            System.out.println("Result: " + result);
        } catch (InvalidNoteException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Music readMusic() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter notes:");
        String notes = in.nextLine();
        Parser parser = new Parser();
        return parser.parse(notes);
    }

    private static int readSemitones() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of semitones:");
        return in.nextInt();
    }
}