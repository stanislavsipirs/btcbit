package org.homework

import spock.lang.Specification

class NoteSpec extends Specification {

    def 'should create note successfully'() {
        when:
        Note.of(1, 6)
        Note.of(-3, 10)
        Note.of(5, 1)

        then:
        noExceptionThrown()
    }

    def 'when max exceeded for note should throw exception'() {
        when:
        Note.of(-3, 9)

        then:
        thrown InvalidNoteException
    }

    def 'when min exceeded for note should throw exception'() {
        when:
        Note.of(5, 2)

        then:
        thrown InvalidNoteException
    }

    def 'should transpose note correctly'() {
        expect:
        note.transpose(semitones) == result

        where:
        note           | semitones | result
        Note.of(1, 6)  | 1         | Note.of(1, 7)
        Note.of(1, 12) | 1         | Note.of(2, 1)
        Note.of(1, 6)  | 10        | Note.of(2, 4)
        Note.of(1, 6)  | 20        | Note.of(3, 2)
        Note.of(1, 6)  | 30        | Note.of(3, 12)
        Note.of(1, 6)  | 40        | Note.of(4, 10)
        Note.of(1, 6)  | 43        | Note.of(5, 1)
        Note.of(1, 6)  | -1        | Note.of(1, 5)
        Note.of(1, 1)  | -1        | Note.of(0, 12)
        Note.of(1, 6)  | -10       | Note.of(0, 8)
        Note.of(1, 6)  | -20       | Note.of(-1, 10)
        Note.of(1, 6)  | -30       | Note.of(-2, 12)
        Note.of(1, 6)  | -40       | Note.of(-2, 2)
        Note.of(1, 6)  | -44       | Note.of(-3, 10)
    }

    def 'when max exceeded for transposed note should throw exception'() {
        when:
        Note.of(1, 6).transpose(44)

        then:
        thrown InvalidNoteException
    }

    def 'when min exceeded for transposed note should throw exception'() {
        when:
        Note.of(1, 6).transpose(-45)

        then:
        thrown InvalidNoteException
    }
}
