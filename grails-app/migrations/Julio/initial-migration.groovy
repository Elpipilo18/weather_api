databaseChangeLog = {

    changeSet(author: "root (generated)", id: "1752689511923-1") {
        createTable(tableName: "weather_alert") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "weather_alertPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "detected_value", type: "DECIMAL(15, 2)") {
                constraints(nullable: "false")
            }

            column(name: "alert_message", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "created_at", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "alert_type", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "root (generated)", id: "1752689511923-2") {
        createTable(tableName: "weather_record") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "weather_recordPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "created_at", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "lecture_value", type: "DECIMAL(15, 2)") {
                constraints(nullable: "false")
            }

            column(name: "lecture_type", type: "INT") {
                constraints(nullable: "false")
            }
        }
    }
}
