# Reitinhakuvertailu

Helsingin yliopiston Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit -kurssin repositorio. Ohjelmassa toteutetaan muutama tunnettu reitinhakualgoritmi ja testataan niitten suorituskykyä.

## Dokumentaatio

[Määrittelydokumentti](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/maarittely.md)

[Tuntikirjanpito](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/tuntikirjanpito.md)

## Viikkoraportit

[Viikko 1](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/viikkoraportit/viikko_1.md)

[Viikko 2](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/viikkoraportit/viikko_2.md)

[Viikko 3](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/viikkoraportit/viikko_3.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

`gradle test` tai `./gradlew test `

Testikattavuusraportti luodaan komennolla

`gradle test jacocoTestReport` tai `./gradlew test jacocoTestReport`

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston _build/reports/jacoco/test/html/index.html_

### Javadoc

Javadocin voi generoida komennolla

`gradle javadoc` tai `./gradlew javadoc`

Javadocia voi tarkastella avaamalla selaimella tiedoston _build/docs/javadoc/index.html

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/guotin/Reitinhakuvertailu/blob/master/PathFinder/config/checkstyle/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

`gradle checkstyleMain` tai `./gradlew checkstyleMain`
