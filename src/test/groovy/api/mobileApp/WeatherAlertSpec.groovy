package api.mobileApp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class WeatherAlertSpec extends Specification implements DomainUnitTest<WeatherAlert> {

     void "test domain constraints"() {
        when:
        WeatherAlert domain = new WeatherAlert()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
