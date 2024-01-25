package org.homework;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Note {

    public static final int MIN_NOTE_NUMBER = -3 * 12 + 10 - 1;
    public static final int MAX_NOTE_NUMBER = 5 * 12 + 1 - 1;

    private final int number;

    private Note(int number) {
        this.number = number;
        if (number < MIN_NOTE_NUMBER || number > MAX_NOTE_NUMBER) {
            throw new InvalidNoteException("Invalid note " + this);
        }
    }

    public static Note of(int octaveNumber, int noteNumber) {
        int number = octaveNumber * 12 + noteNumber - 1;
        return new Note(number);
    }

    public Note transpose(int semitones) {
        return new Note(number + semitones);
    }

    @Override
    public String toString() {
        int octaveNumber = number / 12;
        int noteNumber = number % 12 + 1;
        return "[" + octaveNumber + "," + noteNumber + "]";
    }
}

