# ShopService

Ein einfaches Maven-Projekt aus dem Java-Bootcamp bei neue fische. Es verwaltet Produkte und Bestellungen über Repositories und einen `ShopService`.

## Funktionen

- Produkte hinzufügen, entfernen und anzeigen
- Bestellungen mit Produkt-ID und Menge aufgeben
- Bestellungen in einer Liste oder einer HashMap speichern (`OrderListRepo` und `OrderMapRepo`)
- Bestellmenge ändern
- Gesamtpreis einer Bestellung berechnen
- Interaktive Befehlszeilenschnittstelle mit farbigen Statusmeldungen
- Unit-Tests mit JUnit 5

## Umgesetzte Bonusaufgaben

- **Preis und Bestellmenge:** Produkte haben einen Preis. Bestellungen speichern eine Menge, berechnen den Gesamtpreis und erlauben eine Mengenänderung.
- **Tests:** Tests mit JUnit 5 für `ProductRepo`, `OrderListRepo` und `ShopService`.
- **Befehlszeilenschnittstelle:** Produkte anzeigen, hinzufügen und entfernen sowie Bestellungen aufgeben und anzeigen.
- **Befehlszeilenfarben:** CLI-Statusmeldungen werden farbig ausgegeben.

## Noch offene Bonusaufgaben

- Lagerbestand verwalten und Bestellungen bei fehlendem Bestand ablehnen
- Wareneingang und -ausgang erfassen
- Lagerprotokoll für Bestandsänderungen
- EAN-Datenbank aus einer CSV-Datei verwenden
- 
## Beispiel

Ein Produkt wird mit ID, Name und Preis erstellt. Eine Bestellung verweist auf das Produkt und enthält die bestellte Menge:

```java
Product product = new Product(1, "Lamp", 2.99);
Order order = new Order(10, product, 2);

System.out.println(order.getTotalPrice()); // 5.98