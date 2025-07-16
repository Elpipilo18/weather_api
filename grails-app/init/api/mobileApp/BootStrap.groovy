package api.mobileApp

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        // Initialize the application with some sample data
        addData()

        // Optionally, you can log or print a message to indicate that the data has been added
        println "Sample weather data added successfully."
    }
    def destroy = {
    }

    @Transactional
    def addData() {
        Calendar calendar = Calendar.getInstance()
        for (i in 0..<20) {
            // Create a random date within the last 10 days
            calendar.setTime(new Date())
            calendar.add(Calendar.DAY_OF_YEAR, -((int)(Math.random() * 10)))
            Date randomDate = calendar.getTime()
            new WeatherRecord(
                    type: LectureType.TEMPERATURE,
                    value: new BigDecimal((Math.random() * 40 - 10).toString()),
                    createdAt: randomDate
            ).save(flush: true, failOnError: true)
        }

        for (i in 0..<20) {
            // Create a random date within the last 10 days
            calendar.setTime(new Date())
            calendar.add(Calendar.DAY_OF_YEAR, -((int)(Math.random() * 10)))
            Date randomDate = calendar.getTime()
            new WeatherRecord(
                    type: LectureType.HUMIDITY,
                    value: new BigDecimal((Math.random() * 100).toString()),
                    createdAt: randomDate
            ).save(flush: true, failOnError: true)
        }
    }
}