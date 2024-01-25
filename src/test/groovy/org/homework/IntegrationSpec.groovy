package org.homework

import spock.lang.Specification

class IntegrationSpec extends Specification {

    def 'should transpose correctly'() {
        given:
        Parser parser = new Parser()
        String input = '[[2,1],[2,6],[2,1],[2,8],[2,1],[2,9],[2,1],[2,6],[2,1],[2,8],[2,1],[2,9],[2,1],[2,11],[2,1],[2,8],[2,1],[2,9],[2,1],[2,11],[2,1],[3,1],[2,1],[2,9],[2,1],[2,11],[2,1],[3,1],[2,1],[3,2],[2,1],[2,11],[2,1],[3,1],[2,1],[2,9],[2,1],[2,11],[2,1],[2,8],[2,1],[2,9],[2,1],[2,6],[2,1],[2,8],[2,1],[2,5],[2,1],[2,6],[2,1],[2,1],[2,1],[2,2],[2,1],[1,11],[2,1],[2,1],[2,1],[1,9],[2,1],[1,11],[2,1],[1,8],[2,1],[1,9],[2,1],[1,6],[2,1],[1,11],[2,1],[1,8],[2,1],[1,9],[2,1],[1,6],[2,1],[1,8],[2,1],[1,5],[2,1],[1,6]]'
        String output = '[[1,10],[2,3],[1,10],[2,5],[1,10],[2,6],[1,10],[2,3],[1,10],[2,5],[1,10],[2,6],[1,10],[2,8],[1,10],[2,5],[1,10],[2,6],[1,10],[2,8],[1,10],[2,10],[1,10],[2,6],[1,10],[2,8],[1,10],[2,10],[1,10],[2,11],[1,10],[2,8],[1,10],[2,10],[1,10],[2,6],[1,10],[2,8],[1,10],[2,5],[1,10],[2,6],[1,10],[2,3],[1,10],[2,5],[1,10],[2,2],[1,10],[2,3],[1,10],[1,10],[1,10],[1,11],[1,10],[1,8],[1,10],[1,10],[1,10],[1,6],[1,10],[1,8],[1,10],[1,5],[1,10],[1,6],[1,10],[1,3],[1,10],[1,8],[1,10],[1,5],[1,10],[1,6],[1,10],[1,3],[1,10],[1,5],[1,10],[1,2],[1,10],[1,3]]'

        when:
        Music music = parser.parse(input)
        Music transposed = music.transpose(-3)

        then:
        transposed.toString() == output
    }
}