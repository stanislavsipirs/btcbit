package org.homework;

import lombok.Data;

import java.util.List;

@Data
public class Music {

    private final List<Note> notes;

    public Music transpose(int semitones) {
        List<Note> newNotes = notes.stream().map(note -> note.transpose(semitones)).toList();
        return new Music(newNotes);
    }

    @Override
    public String toString() {
        return "[" + String.join(",", notes.stream().map(Note::toString).toList()) + "]";
    }
}
