package org.homework

import spock.lang.Specification

class ParserSpec extends Specification {

    def 'should parse notes correctly'() {
        given:
        Parser parser = new Parser()

        expect:
        parser.parse(input) == result

        where:
        input           | result
        '[[1,1]]'       | new Music([Note.of(1, 1)])
        '[[-1,-1]]'     | new Music([Note.of(-1, -1)])
        '[[1,1],[2,2]]' | new Music([Note.of(1, 1), Note.of(2, 2)])
    }

    def 'when input incorrect should throw exception'() {
        given:
        Parser parser = new Parser()

        when:
        parser.parse('[[1,error]]')

        then:
        thrown Exception
    }
}
