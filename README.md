## Реализация системы мониторинга с использованием Spring Kafka
Создан микросервис "Metrics Consumer", который будет принимать метрики из Kafka топика "metrics-topic"

_**Инструкция по запуску:**_
1. Запуск бэкенда через IDE:
- скачать проект из репозитория;
- загрузить все зависимости;
- запустить проект.
2. Отправляем запрос:
```http
GET http://URL:8080/metrics
```
 Формат ответа
```JSON
[
  {
    "id": 1,
    "metricsName": "asd",
    "metrics": [
      {
        "id": 1,
        "usedTimeMs": 0,
        "usedMemoryMb": 0,
        "serviceName": "dddddd",
        "wasError": false
      },
      {
        "id": 2,
        "usedTimeMs": 0,
        "usedMemoryMb": 0,
        "serviceName": "dddddd",
        "wasError": false
      }
    ]
  },
  {
    "id": 2,
    "metricsName": "asd",
    "metrics": [
      {
        "id": 3,
        "usedTimeMs": 0,
        "usedMemoryMb": 0,
        "serviceName": "dddddd",
        "wasError": false
      },
      {
        "id": 4,
        "usedTimeMs": 0,
        "usedMemoryMb": 0,
        "serviceName": "dddddd",
        "wasError": false
      }
    ]
  }
]
```

```http
GET http://URL:8080/metrics/{metricsName}
```
Формат ответа
```JSON
[
  {
    "id": 1,
    "metricsName": "asd",
    "metrics": [
      {
        "id": 1,
        "usedTimeMs": 0,
        "usedMemoryMb": 0,
        "serviceName": "dddddd",
        "wasError": false
      },
      {
        "id": 2,
        "usedTimeMs": 0,
        "usedMemoryMb": 0,
        "serviceName": "dddddd",
        "wasError": false
      }
    ]
  }
]
```
В микросервисе происходит получения сообщения из Kafka. Сообщение сохраняется в базу данных.

**_Проект использует следующие технологии:_**
- Java 17
- Spring Framework
- Kafka
- H2
- Postman
- Maven
