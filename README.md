# WordAppJCF
Wij hebben onze performance test gedaan op twee laptops. Waarop laptop 1 een i7 4th gen cpu heeft en laptop 2 een i5 5th gen cpu heeft.
De performance test is uitgevoerd op 10.000 woorden. (www.lipsum.com)

Laptop 1(Eerste tijd gepakt):
- Aantal: 44ms
- Sorteren: 55ms
- Frequentie: 55ms
- Concordantie: 99ms

Laptop 2 (gemiddelde van meerdere testen):
- Aantal: 10ms
- Sorteren: 23ms
- Frequentie: 12ms
- Concordantie: 29ms

*Voor aantal gebruiken we een Array
 - We gebruiken de split functie van de String. Deze retourneert een String array. Om het aantal woorden te krijgen hoeven we alleen de length van de array op te halen.
*Voor sorteren gebruiken we een TreeSet
 - Een TreeSet is geordend waar een HashSet niet geordend is. De Set gebruiken we om de duplicates eruit te halen.
*Voor Frequentie gebruiken we een HashMap
 - HashMap maakt gebruik van key,value points waardoor we makkelijk de hoeveelheid van woorden kunnen koppelen aan het woord.
*Voor Concordantie gebruiken we een HashMap en een Set
 - De key is het woord en de value is de Set van integers. De Set zorgt ervoor dat elke regel nummer 1 keer voor komt.
  Door de HashSet is het zoeken naar de value effiëcenter.
  
  Complexiteit met de Big O notatie (schatting)
  - Aantal: O(n)
  - Sorteren: O(n)
  - Frequentie: O(n)
  - Concordantie: O(n)
