# Viikko 4

[Tuntikirjanpito](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/tuntikirjanpito.md)

## Mitä olen tehnyt tällä viikolla

- JavaFX-käyttöliittymän kehitystä.
- Refaktorointia.
- Syvyyshaun muutos. Rekursiivinen viritelmä osoittautui väärin tehdyksi ja nyt hakualgoritmi käyttää pinoa.
- Pinon toteutus.

## Miten ohjelma on edistynyt

Käyttöliittymässä voidaan valita haluttu kartta (nyt 11 vaihtoehtoa), merkata aloitus- ja lopetuspiste sekä
ratkaista reitti halutulla algoritmilla. Syvyyshaku käyttää nyt pinoa. Pino toteutettu itse.

## Mitä opin tällä viikolla

JavaFX käyttöliittymällä piirtelyä ja pinon toteutusta. 

## Ongelmat ja epäselvyydet

Suorityskykytestauksen jatkamisen toteutustavasta ei oikein ole varmuutta.
Voisiko käyttäjälle antaa mahdollisuuden valita käyttöliittymästä useampia aloitus- ja lopetuspisteitä joiden perusteella
voitaisiin suorittaa useampia hakuja putkeen niin, että algoritmien erot tulisivat selvemmin näkyviin?
Vai pitäisikö suorituskykytestaus hoitaa erillisesti jollain valmiilla päätepistejoukolla, jolloin testitapaukset olisivat
aina samanlaisia?

## Mitä teen seuraavaksi

Suorituskykytestausta.
