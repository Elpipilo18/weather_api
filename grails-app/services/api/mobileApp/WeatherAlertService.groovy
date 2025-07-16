package api.mobileApp

import grails.gorm.services.Service

@Service(WeatherAlert)
interface WeatherAlertService {

    WeatherAlert get(Serializable id)

    List<WeatherAlert> list(Map args)

    Long count()

    WeatherAlert delete(Serializable id)

    WeatherAlert save(WeatherAlert weatherAlert)

}
