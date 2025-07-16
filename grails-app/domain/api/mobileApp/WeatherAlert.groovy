package api.mobileApp

class WeatherAlert {

    AlertType type
    String message
    BigDecimal detectedValue
    Date createdAt = new Date()

    static constraints = {
        type nullable: false
        message nullable: false
        detectedValue nullable: false
        createdAt nullable: false
    }

    static mapping = {
        table 'weather_alert'
        type column: 'alert_type', enumType: 'ordinal'
        message column: 'alert_message', length: 255
        detectedValue column: 'detected_value', scale: 2, precision: 15
        createdAt column: 'created_at'
    }
}

enum AlertType {
    TEMPERATURA_ALTA(1, "Temperatura alta"),
    TEMPERATURA_BAJA(2, "Temperatura baja"),
    HUMEDAD_ALTA(3, "Humedad alta"),
    HUMEDAD_BAJA(4, "Humedad baja");

    private final int id;
    private final String description;

    AlertType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    static AlertType get(int id) {
        return values().find { it.id == id };
    }
}