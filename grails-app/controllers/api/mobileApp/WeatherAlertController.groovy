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
class WeatherAlertController {

    WeatherAlertService weatherAlertService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond weatherAlertService.list(params), model:[weatherAlertCount: weatherAlertService.count()]
    }

    def show(Long id) {
        respond weatherAlertService.get(id)
    }

    @Transactional
    def save(WeatherAlert weatherAlert) {
        if (weatherAlert == null) {
            render status: NOT_FOUND
            return
        }
        if (weatherAlert.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond weatherAlert.errors
            return
        }

        try {
            weatherAlertService.save(weatherAlert)
        } catch (ValidationException e) {
            respond weatherAlert.errors
            return
        }

        respond weatherAlert, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(WeatherAlert weatherAlert) {
        if (weatherAlert == null) {
            render status: NOT_FOUND
            return
        }
        if (weatherAlert.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond weatherAlert.errors
            return
        }

        try {
            weatherAlertService.save(weatherAlert)
        } catch (ValidationException e) {
            respond weatherAlert.errors
            return
        }

        respond weatherAlert, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || weatherAlertService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
