package com.kitchen

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class MyFirstTestSpec extends Specification {

    // fields
    def name

    // feature methods
    def "check length of 'Spock'"() {
        expect:
        name.size() == 5
    }
    
    def "'Spock' starts with capital S"() {
        expect:
        name[0] == 'S'
    }

    // fixture methods
    def setup() {
        name = "Spock"
    }

    // helper methods
    def sizeOf(String string) {
        return name.size()
    }

}