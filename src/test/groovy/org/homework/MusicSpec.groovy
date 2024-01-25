package org.homework

import spock.lang.Specification

class MusicSpec extends Specification {

    def 'should transpose music correctly'() {
        expect:
        music.transpose(semitones) == result

        where:
        music                                     | semitones | result
        new Music([Note.of(1, 1)])                | 1         | new Music([Note.of(1, 2)])
        new Music([Note.of(1, 1), Note.of(1, 2)]) | 1         | new Music([Note.of(1, 2), Note.of(1, 3)])
    }
}
