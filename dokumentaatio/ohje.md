# Käyttöohje

## Sovelluksen lataaminen ja käynnistäminen

Sovellus on luotu [Oraclen JDK 8:lla](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). 
Jos käytät uudempaa Java-versiota, saatat joutua muokkaamaan [build.gradle](https://github.com/guotin/Reitinhakuvertailu/blob/master/PathFinder/build.gradle)
tiedostoa saadaksesi JavaFX-käyttöliittymän toimimaan. Tämä toimenpide vaatii koko projektin kloonaamista.

Sovelluksen `PathFinder.jar` voi ladata tämän repositorion julkaisusta. Navigoituasi latauskansioon, ohjelman voi käynnistää komennolla
`java -jar PathFinder.jar`. Jos kloonaat tämän repositorion niin voit käynnistää ohjelman myös gradlella antamalla komennon
`gradle run` tai `./gradlew run`

## Sovelluksen käyttäminen

Sovelluksen aloitusnäkymä on seuraavanlainen:

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/koko_sovellus.png" height=720 width=1280>

Sovellus piirtää yhden ennaltamääritellyistä kartoista näytölle ja sitä voidaan kelata kuvan vieressa olevilla palkeilla.
Karttaa voidaan vaihtaa valitsemalla haluttu kartta listalta ja painamalla `Change Map`-painiketta. Reitinhaku valitussa
kartassa toimii valitsemalla ensin aloitus- ja lopetuspisteet painamalla karttaa hiirellä ja painamalla sen jälkeen jotain 
kolmesta reitinhakualgoritmia vastaavasta painikkeesta. Sovellus piirtää löydetyn reitin karttaan ja tulostaa tietoja sille
määriteltyyn laatikkoon.

Käyttöliittymän kautta voidaan myös suorittaa kaikkien kolmen hakualgoritmien välistä suorituskykyvertailua. Tähän on käytössä
vain kolme erillistä karttaa ja niille määritellyt aloitus- ja lopetuspisteiden joukot. Käyttäjä voi valita suorituskykyvertailussa
tehtävien iteraatioiden määrän kirjoittamalla sen sille valittuun kenttään. Tämän jälkeen suorituskykyvertailu käynnistetään painamalla
`Benchmark`-painiketta. Suorituskykyvertailun tulokset tulostuvat tietokenttään ja sovellus piirtää valitan suorituskykykartan
näytölle.

## Muita komentoja

Jos kloonaat tämän projektin, voit suorittaa erinäisiä komentorivitoimintoja:

### Testaus

Yksikkötestit suoritetaan komennolla

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
