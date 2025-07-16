package api.mobileApp

class WeatherRecord {

    LectureType type
    BigDecimal value
    Date createdAt = new Date()

    static constraints = {
        type nullable: false
        createdAt nullable: false
        value nullable: false
    }

    static mapping = {
        table 'weather_record'
        type column: 'lecture_type', enumType: 'ordinal'
        value column: 'lecture_value', scale: 2, precision: 15
        createdAt column: 'created_at'
    }
}

enum LectureType {
    TEMPERATURE(1, "Temperatura"),
    HUMIDITY(2, "Humedad"),
    PRESSURE(3, "Presión");

    private final int id;
    private final String description;

    LectureType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    static LectureType get(int id) {
        return values().find { it.id == id };
    }
}