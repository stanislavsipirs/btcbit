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

    def 'should display music correctly'() {
        expect:
        music.toString() == result

        where:
        music                                                    | result
        new Music([Note.of(1, 1)])                               | '[[1,1]]'
        new Music([Note.of(1, 1), Note.of(2, 2)])                | '[[1,1],[2,2]]'
        new Music([Note.of(1, 1), Note.of(2, 2), Note.of(3, 3)]) | '[[1,1],[2,2],[3,3]]'
    }
}
