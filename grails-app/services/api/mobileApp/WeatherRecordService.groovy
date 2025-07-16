package api.mobileApp

import grails.gorm.services.Service

@Service(WeatherRecord)
interface WeatherRecordService {

    WeatherRecord get(Serializable id)

    List<WeatherRecord> list(Map args)

    Long count()

    WeatherRecord delete(Serializable id)

    WeatherRecord save(WeatherRecord weatherRecord)

}
