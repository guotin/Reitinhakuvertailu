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
Suorituskykytestausta tehtiin kolmessa mahdollisimmaan erimuotoisessa kartassa.

### Käytetty aika

#### Testikartta 1 (map1.map)

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/map1_aika.png">

#### Testikartta 2 (map2.map)

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/map2_aika.png">

#### Testikartta 3 (map3.map)

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/map3_aika.png">

### Reitin pituus

### Käydyt tilat


### Muuta

Hakualgoritmien suorituskykyä voi testata manuaalisesti käyttöliittymän avulla (kts. [toteutusdokumentti](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/toteutus.md)).
