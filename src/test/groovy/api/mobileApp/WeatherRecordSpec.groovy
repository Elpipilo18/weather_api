package api.mobileApp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class WeatherRecordSpec extends Specification implements DomainUnitTest<WeatherRecord> {

     void "test domain constraints"() {
        when:
        WeatherRecord domain = new WeatherRecord()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
