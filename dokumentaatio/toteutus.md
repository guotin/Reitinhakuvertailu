# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelman lähdekoodi on jaettu neljään eri pakkaukseen:

- `ui`
- `domain`
- `algorithms`
- `datastructures`

Pakkauksessa `ui` on JavaFX:llä toteutettu käyttöliittymä. Käyttöliittymä kutsuu `domain` pakkauksen luokkia `Routefinder`
ja `Filereader` tuottaakseen käyttäjälle näkymän, jossa voidaan valita haluttu kartta ja ratkaista reittejä eri hakualgoritmeilla.
`Routefinder` -luokka käyttää pakkauksessa `algorithms` sijaitsevia hakualgoritmeja ja tallentaa tietoja näiden algoritmien
muodostamista reiteistä. Hakualgoritmit käyttävät `datastructures` pakkauksen tietorakenteita apunaan. Näitä tietorakenteita
ovat esimerkiksi prioriteettijono `PriorityQueue` -luokassa ja pino `Stack` -luokassa. Muut luokat toimivat näiden pääluokkien
apuna.

## Saavutetut tila- ja aikavaativuudet

## Suorituskykyvertailu

Ohjelman yksi suorituskykyvertailun muoto on käyttäjän itse valitsemien pisteiden välisen reitin muodostaminen ja sen tulokset.
Tuloksista saa selville reitinhakemiseen käytetyn ajan (joka on melko pieni 512x512 kokoisilla kartoilla), reitin pituuden ja reitinhaun aikana käytyjen tilojen määrän.

<img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/astar_esim.png" height=500> <img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/dijkstra_esim.png" height=500> <img src="https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/kuvat/dfs_esim.png" height=500>


## Puutteet ja parannusehdotukset

## Lähteet
