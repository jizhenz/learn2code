package com.jz.dwguice

import ru.vyarus.dropwizard.guice.test.spock.UseDropwizardApp
import spock.lang.Specification

/**
 * @author Vyacheslav Rusakov
 * @since 06.03.2017
 */
@UseDropwizardApp(SampleApplication)
class SampleApplicationTest extends Specification {

//    def "Check application startup"() {
//
//        when: "call resource directly"
//        new URL("http://localhost:8080/sample/").getText()
//        then: "not allowed"
//        def ex = thrown(IOException)
//        ex.message.startsWith('Server returned HTTP response code: 401 for URL')
//
//        when: "call resource correctly"
//        def res = new URL("http://localhost:8080/sample/?user=me").getText()
//        then: "allowed"
//        res
//    }

    def "Check guice sub resource"() {

        when: "call guice managed sub resource"
        def res = new URL("http://localhost:8080/root/12/guice-sub").getText()
        then: "correct"
        res == 'guice root1 12'
    }

    def "Check hk sub resource"() {

        when: "call hk managed sub resource"
        def res = new URL("http://localhost:8080/root/11/hk-sub").getText()
        then: "correct"
        res == 'hk root2 11'
    }

}
