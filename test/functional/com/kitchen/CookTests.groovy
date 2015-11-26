package com.kitchen

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.Connection.Method
import org.jsoup.Connection.Response


/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
class CookTests extends functionaltestplugin.FunctionalTestCase {

    def testCanCookMeatAndPotatoes() {
        get('/cook/Meat%20&%20Potatoes')

        assertContentContains "Here is your Meat & Potatoes, sir/lady!"
    }
    
}