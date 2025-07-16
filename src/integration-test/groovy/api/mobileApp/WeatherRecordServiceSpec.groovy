package api.mobileApp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class WeatherRecordServiceSpec extends Specification {

    WeatherRecordService weatherRecordService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new WeatherRecord(...).save(flush: true, failOnError: true)
        //new WeatherRecord(...).save(flush: true, failOnError: true)
        //WeatherRecord weatherRecord = new WeatherRecord(...).save(flush: true, failOnError: true)
        //new WeatherRecord(...).save(flush: true, failOnError: true)
        //new WeatherRecord(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //weatherRecord.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        weatherRecordService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<WeatherRecord> weatherRecordList = weatherRecordService.list(max: 2, offset: 2)

        then:
        weatherRecordList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        weatherRecordService.count() == 5
    }

    void "test delete"() {
        Long weatherRecordId = setupData()

        expect:
        weatherRecordService.count() == 5

        when:
        weatherRecordService.delete(weatherRecordId)
        datastore.currentSession.flush()

        then:
        weatherRecordService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        WeatherRecord weatherRecord = new WeatherRecord()
        weatherRecordService.save(weatherRecord)

        then:
        weatherRecord.id != null
    }
}
