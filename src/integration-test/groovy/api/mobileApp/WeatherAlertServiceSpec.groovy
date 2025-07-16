package api.mobileApp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class WeatherAlertServiceSpec extends Specification {

    WeatherAlertService weatherAlertService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new WeatherAlert(...).save(flush: true, failOnError: true)
        //new WeatherAlert(...).save(flush: true, failOnError: true)
        //WeatherAlert weatherAlert = new WeatherAlert(...).save(flush: true, failOnError: true)
        //new WeatherAlert(...).save(flush: true, failOnError: true)
        //new WeatherAlert(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //weatherAlert.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        weatherAlertService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<WeatherAlert> weatherAlertList = weatherAlertService.list(max: 2, offset: 2)

        then:
        weatherAlertList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        weatherAlertService.count() == 5
    }

    void "test delete"() {
        Long weatherAlertId = setupData()

        expect:
        weatherAlertService.count() == 5

        when:
        weatherAlertService.delete(weatherAlertId)
        datastore.currentSession.flush()

        then:
        weatherAlertService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        WeatherAlert weatherAlert = new WeatherAlert()
        weatherAlertService.save(weatherAlert)

        then:
        weatherAlert.id != null
    }
}
