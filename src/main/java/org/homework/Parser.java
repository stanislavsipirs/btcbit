package org.homework;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public Music parse(String input) {
        String[] parts = input
                .replace(" ", "")
                .replace("[[", "")
                .replace("]]", "")
                .split("],\\[");
        List<Note> notes = Arrays.stream(parts).map(this::parseNote).toList();
        return new Music(notes);
    }

    private Note parseNote(String input) {
        String[] parts = input.split(",");
        int octaveNumber = Integer.parseInt(parts[0]);
        int noteNumber = Integer.parseInt(parts[1]);
        return Note.of(octaveNumber, noteNumber);
    }
}
