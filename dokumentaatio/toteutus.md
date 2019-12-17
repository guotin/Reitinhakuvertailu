# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelman lähdekoodi on jaettu neljään eri pakkaukseen:

- `ui`
- `domain`
- `algorithms`
- `datastructures`

Pakkauksessa `ui` on JavaFX:llä toteutettu käyttöliittymä. Käyttöliittymä kutsuu `domain`-pakkauksen luokkia `Routefinder`
ja `Filereader` tuottaakseen käyttäjälle näkymän, jossa voidaan valita haluttu kartta ja ratkaista reittejä eri hakualgoritmeilla. Lisäksi käyttöliittymästä on mahdollista kutsua `Benchmark`-luokkaa, jolloin ohjelma suorittaa kaikkien 
hakualgoritmien suorituskykyvertailua halutussa kartassa.
`Routefinder`-luokka käyttää pakkauksessa `algorithms` sijaitsevia hakualgoritmeja ja tallentaa tietoja näiden algoritmien
muodostamista reiteistä. Hakualgoritmit käyttävät `datastructures`-pakkauksen tietorakenteita apunaan. Näitä tietorakenteita
ovat esimerkiksi prioriteettijono `PriorityQueue`-luokassa ja pino `Stack`-luokassa. Muut luokat toimivat näiden pääluokkien
apuna.

## Saavutetut tila- ja aikavaativuudet

### Tietorakenteet

* Prioriteettijono käyttäen binäärikekoa.

| ----------------------- |  Keskimääräinen tapaus | Pahin tapaus |
| ----------------------- | ---------------------  | ------------ |
| Tilavaativuus           | O(n)                   | O(n)         |
| Lisäyksen aikavaativuus | O(1)                   | O(log n)     |
| Poiston aikavaativuus   | O(log n)               | O(log n)     |

* Pino

| ----------------------- |  Keskimääräinen tapaus | Pahin tapaus |
| ----------------------- | ---------------------  | ------------ |
| Tilavaativuus           | O(n)                   | O(n)         |
| Lisäyksen aikavaativuus | O(1)                   | O(1)         |
| Poiston aikavaativuus   | O(1)                   | O(1)         |

### Hakualgoritmit

* A*-algoritmi = O(log h*(x)), missä funktio h on "manhattan etäisyyden" laskemiseen käytetty aika

* Dijkstran algoritmi = O(n + mlogn)

* Syvyyshaku = O(n + m)

## Suorituskykyvertailu

Ohjelman yksi suorituskykyvertailun muoto on käyttäjän itse valitsemien pisteiden välisen reitin muodostaminen ja sen tulokset.
Tuloksista saa selville reitinhakemiseen käytetyn ajan (joka on melko pieni 512x512 kokoisilla kartoilla), reitin pituuden ja reitinhaun aikana käytyjen tilojen määrän.

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/astar_esim.png" height=500 width=230> <img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/dijkstra_esim.png" height=500 width=230> <img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/dfs_esim.png" height=500 width=230>

Toinen suorituskykyvertailun muoto on vertailla käyttöliittymän kautta kaikkia kolmea hakualgoritmia keskenään.
Sovellukseen on määritelty kolmelle kartalle joukko aloitus- ja lopetuspisteitä. Käyttäjä voi valita näistä kolmesta kartasta
mieleisensä ja päättää suorituskykyvertailun pituuden eli montako kertaa reittiä haetaan. Suorituskykyvertailun lopputulos
tulostetaan käyttäjälle ja siitä selviää käytetty aika millisekunteina, keskimääräinen reitin pituus ja keskimääräinen käytyjen tilojen määrä. Alla havainnollistava kuva:

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/suorituskyky_esim.png"> 


## Puutteet ja parannusehdotukset



## Lähteet

- Binäärikeko: [Wikipedia](https://en.wikipedia.org/wiki/Binary_heap)

- Pino: [Wikipedia](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))

- A*-algoritmi: [Wikipedia](https://en.wikipedia.org/wiki/A*_search_algorithm)

- Dijkstran algoritmi: [Wikipedia](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)

- Syvyyshaku: [Wikipedia](https://en.wikipedia.org/wiki/Depth-first_search)

- Tietorakenteet ja algoritmit - Antti Laaksonen - 2.10.2019: [Linkki kirjaan](https://www.cs.helsinki.fi/u/ahslaaks/tirakirja/)
