# ShopService

Ein einfaches Maven-Projekt aus dem Java-Bootcamp bei neue fische. Es verwaltet Produkte und Bestellungen mit Repositories und einem `ShopService`.

## Funktionen

- Produkte hinzufügen, entfernen und anzeigen
- Produkte anhand ihrer ID finden; ein fehlendes Produkt wird mit `Optional` dargestellt
- Bestellungen mit Produkt-ID und Menge aufgeben
- Fehlermeldung durch eine Exception, wenn ein Produkt nicht existiert
- Bestellungen mit Status `PROCESSING`, `IN_DELIVERY` oder `COMPLETED`
- Bestellungen mit der Stream API nach Status filtern
- Bestellstatus mit Lomboks `@With` aktualisieren
- Bestellzeitpunkt mit `Instant` speichern
- Bestellmenge ändern und den Gesamtpreis berechnen
- Bestellungen in einer Liste oder einer HashMap speichern (`OrderListRepo` und `OrderMapRepo`)
- Interaktive Befehlszeilenschnittstelle mit farbigen Meldungen
- Tests mit JUnit 5

## Beispiel

```java
Product product = new Product(1, "Lamp", 2.99);
Order order = new Order(
        10,
        product,
        2,
        OrderStatus.PROCESSING,
        Instant.now()
);

System.out.println(order.getTotalPrice()); // 5.98

```

## Build und Tests

Projekt bauen und Tests ausführen:

```bash
mvn clean verify
```

## Umgesetzte Bonusaufgaben

- Preis und Bestellmenge mit Gesamtpreisberechnung
- CLI zum Verwalten von Produkten und Bestellungen
- Farbige CLI-Meldungen
- Drei Beispielbestellungen in `Main`
- Lomboks `@RequiredArgsConstructor` für den Konstruktor von `ShopService`

## Noch offene Bonusaufgaben

- UUIDs mit einem `IdService` erzeugen
- Älteste Bestellung je Status ermitteln
- Befehle aus `transactions.txt` lesen
- Lagerbestand verwalten