# vet system

## Umawianie wizyty

### POST

Aby umówić się na wizytę wysyłamy JSON:

```json
{
    "start_visit": "początek wizyty format: yyyy-MM-dd HH:mm np: "2021-01-22 11:00"",
    "end_visit": "koniec wizyty format: yyyy-MM-dd HH:mm np: "2021-01-22 11:40"",
    "doctor_id": "id wybranego doktora",
    "customer_id": "id klienta"
}
```

pod adres:

- `/appointments`

Dodanie nowej wizyty wymaga podanie w Headers `customer-pin` pinu klienta.

## Usówanie wizyty

### DELETE

- `/appointments/{id}?customer_id=` - usówa wizytę o podanym id, za parametr customer_id wpisujemy id klienta

Usunięcie wybranej wizyty wymaga podanie w hederze `customer-pin` pinu klienta.


### GET

- `/doctors/{id}?date=` - zwraca listę wizyt doktora o podanym id, za parametr date wpisujemy interesująca nas data wizyt.

np /doctors/2?date=2021-01-22