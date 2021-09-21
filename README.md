# Документация к API в библиотеке log-action-lib

### REST c префиксом /ui(пользовательские методы)

#### Получение всех устройств в системах(rfid, barrier, qr) - `GET {application-name}/ui/actions`

данный метод позволяет получить события в различных системах, для этого необходимо в начале адреса указать имя сервиса,
чтобы получить события из конкретного сервиса. Также данный метод позволяет фильтровать записи по 4-м параметрам.
Параметр фильтра нужно передавать в строке запроса. Если таких записей нету, то возвращается пустой лист.

**Список входных параметров:**

```
в url:
по интервалу дат - ?before=2023-11-22T10:00:00&after=2025-12-09T10:00:00,
по полю инфо - ?info="",
по полю гос-номер - ?governmentNumber="",
по полю commonId - ?common=1245
также можно указать какой page и size надо получить - ?page=0&size=20
также можно указать сортировку по полям - ?sort=info,desc
```

**Формат ответа:**

```sh
{
  "content": [
    {
      "description": {
        "erroredServiceName": "string",
        "message": "string",
        "statusCode": "string"
      },
      "deviceId": 0,
      "errored": true,
      "eventTime": "2021-09-21T18:35:51.170Z",
      "eventType": "string",
      "gosNumber": "string",
      "id": 0,
      "info": "string",
      "rfidLabelValue": 0,
      "stateOfAction": "string"
    }
  ],
  "empty": true,
  "first": true,
  "last": true,
  "number": 0,
  "numberOfElements": 0,
  "pageable": {
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 0,
    "paged": true,
    "sort": {
      "empty": true,
      "sorted": true,
      "unsorted": true
    },
    "unpaged": true
  },
  "size": 0,
  "sort": {
    "empty": true,
    "sorted": true,
    "unsorted": true
  },
  "totalElements": 0,
  "totalPages": 0
}
```

**Статус:**

```sh
при успешном отрабатывании - HttpStatus.OK
при неудачном когда сервер недоступен - HttpStatus.INTERNAL_SERVER_ERROR
```