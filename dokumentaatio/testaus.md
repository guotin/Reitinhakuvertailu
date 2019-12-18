# Testausdokumentaatio

## Yksikkötestaus

Ohjelman yksikkötestaus hoidetaan JUnit-testeillä. Testattavat asiat riippuvat luokkien halutusta toiminnallisuudesta:

- Hakualgoritmiluokat

   Testeissä käytetään melko pieniä, itse kirjoitettuja 2d-karttoja hakualgoritmien syötteinä. 
   Testeissä tarkastellaan löytääkö algoritmi reitin, jos se on mahdollista ja päinvastoin. Lisäksi Dijkstran algoritmia ja 
   A*-algoritmia vastaavat luokat testataan niin, että ne palauttavat pienissä testikartoissa halutunlaisen reitin. Myös reitin
   piirtämistä 2d-taulukkoon testataan.
   
- Tietorakenneluokat

   Tietorakenteita (prioriteettijono ja pino) testataan lisäämällä ja poistamalla alkioita. 
   Näin testataan ovatko palautteet halutunlaisia ja toimiiko esimerkiksi tietorakenteen koon muutos kesken ohjelman suorituksen.
   
- `Routefinder`-luokka

   Testauksessa käytetään jälleen apuna itse kirjoitettuja 2d-karttoja. 
   Testattavat asiat ovat esimerkiksi, että muuttuvatko tietyt arvot, kun hakualgoritmeja kutsutaan tämän luokan avulla
   ja toimiiko alku- ja loppupisteen merkitseminen karttaan odotetusti.
   
- `Filereader`-luokka

   Testeissä luetaan muutama kartta ja testipisteet tiedostoista ja vertaillaan tuloksia haluttuun.

- `Benchmark`-luokka
   
   Testeissä tarkastetaan, että suorituskykytestaus muuttaa arvoja suorituksen aikana.
   
JavaFX:llä luotua käyttöliittymää ei testata ja se on jätetty testikattavuusraportin ulkopuolelle.

Sovelluksen testikattavuus:

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/testikattavuus.png">
   
## Suorituskykytestaus

Suorituskykytestauksessa otetaan huomioon reitinhakuun käytetty aika, löydetyn reitin pituus ja käytyjen tilojen määrä. 
Suorituskykytestausta tehtiin kolmessa mahdollisimman erimuotoisessa kartassa.

### Käytetty aika

- Testikartta 1 (map1.map)

   | Algoritmi           |  50 iteraatiota   | 100 iteraatiota | 500 iteraatiota  | 1000 iteraatiota |
   | ------------------- | ------------------| ----------------| -----------------| ---------------- |
   | A*-algoritmi        | 452 ms            | 914 ms          | 4613 ms          | 9096 ms          |
   | Dijkstran algoritmi | 571 ms            | 1140 ms         | 5783 ms          | 11505 ms         |
   | Syvyyshaku          | 176 ms            | 351 ms          | 1742 ms          | 3437 ms          |

   <img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/map1_aika.png">

- Testikartta 2 (map2.map)

   | Algoritmi           |  50 iteraatiota   | 100 iteraatiota | 500 iteraatiota  | 1000 iteraatiota |
   | ------------------- | ------------------| ----------------| -----------------| ---------------- |
   | A*-algoritmi        | 329 ms            | 597 ms          | 3006 ms          | 6020 ms          |
   | Dijkstran algoritmi | 466 ms            | 866 ms          | 4383 ms          | 8696 ms          |
   | Syvyyshaku          | 240 ms            | 468 ms          | 2314 ms          | 4624 ms          |

   <img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/map2_aika.png">

- Testikartta 3 (map3.map)

   | Algoritmi           |  50 iteraatiota   | 100 iteraatiota | 500 iteraatiota  | 1000 iteraatiota |
   | ------------------- | ------------------| ----------------| -----------------| ---------------- |
   | A*-algoritmi        | 259 ms            | 509 ms          | 2586 ms          | 5116 ms          |
   | Dijkstran algoritmi | 302 ms            | 582 ms          | 2907 ms          | 5808 ms          |
   | Syvyyshaku          | 124 ms            | 235 ms          | 1216 ms          | 2441 ms          |


   <img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/map3_aika.png">


### Reitin pituus

Suorituskykytestauksessa tarkasteltiin keskimääräistä löydetyn reitin pituutta. Iteraatioita oli 500, mutta koska testipisteiden joukko oli melko pieni niin tällä ei ollut paljon merkitystä. Tulokset olivat seuraavanlaiset:

| Algoritmi               |  Testikartta 1 (map1.map) | Testikartta 2 (map2.map) | Testikartta 3 (map3.map)|
| ----------------------- | ------------------------  | ------------------------ | ----------------------- |
| A*-algoritmi            | 465                       | 363                      | 622                     |
| Dijkstran algoritmi     | 464                       | 363                      | 622                     |
| Syvyyshaku              | 17782                     | 38770                    | 10679                   |


### Käydyt tilat

Myös käytyjen tilojen tapauksessa tarkasteltiin keskimääräistä tapausta. Iteraatioiden määrä oli jälleen 500.

| Algoritmi               |  Testikartta 1 (map1.map) | Testikartta 2 (map2.map) | Testikartta 3 (map3.map)|
| ----------------------- | ------------------------  | ------------------------ | ----------------------- |
| A*-algoritmi            | 44648                     | 29648                    | 28469                   |
| Dijkstran algoritmi     | 59964                     | 45166                    | 34831                   |
| Syvyyshaku              | 49277                     | 63903                    | 33366                   |

### Päätelmät


### Muuta

Hakualgoritmien suorituskykyä voi testata manuaalisesti käyttöliittymän avulla (kts. [toteutusdokumentti](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/toteutus.md)).
