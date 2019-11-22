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

   Testeissä luetaan muutama kartta testitiedostoista ja vertaillaan tuloksia haluttuun.
   
JavaFX:llä luotua käyttöliittymää ei testata ja se on jätetty testikattavuusraportin ulkopuolelle.
   
## Suorituskykytestaus

Hakualgoritmien suorituskykyä voi testata manuaalisesti käyttöliittymän avulla (kts. [toteutusdokumentti](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/toteutus.md)).
