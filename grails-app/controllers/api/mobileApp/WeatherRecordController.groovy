package api.mobileApp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class WeatherRecordController {

    WeatherRecordService weatherRecordService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.offset = params.offset ?: 0
        def weatherRecordList = WeatherRecord.createCriteria().list(params) {
            if (params.type) {
                eq "type", LectureType.get(params.type as Integer)
            }
        }
        respond weatherRecordList, model: [
                weatherRecordCount: weatherRecordList.totalCount,
                currentMax        : (params.max ?: 10) as Integer,
                currentOffset     : (params.offset ?: 0) as Integer
        ]
    }

    def show(Long id) {
        respond weatherRecordService.get(id)
    }

    @Transactional
    def save(WeatherRecord weatherRecord) {
        if (weatherRecord == null) {
            render status: NOT_FOUND
            return
        }
        if (weatherRecord.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond weatherRecord.errors
            return
        }

        try {
            weatherRecordService.save(weatherRecord)
        } catch (ValidationException e) {
            respond weatherRecord.errors
            return
        }

        respond weatherRecord, [status: CREATED, view: "show"]
    }

    @Transactional
    def update(WeatherRecord weatherRecord) {
        if (weatherRecord == null) {
            render status: NOT_FOUND
            return
        }
        if (weatherRecord.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond weatherRecord.errors
            return
        }

        try {
            weatherRecordService.save(weatherRecord)
        } catch (ValidationException e) {
            respond weatherRecord.errors
            return
        }

        respond weatherRecord, [status: OK, view: "show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || weatherRecordService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
