# Viikko 2

[Tuntikirjanpito](https://github.com/guotin/Reitinhakuvertailu/blob/master/dokumentaatio/tuntikirjanpito.md)

## Mitä olen tehnyt tällä viikolla

- Aloitin sovelluksen ydinaiheen luomisen
- Kirjoitin testejä luoduille luokille
- Loin checkstyle-määritelmät ja kommentoin koodia javadoc-muodossa

## Miten ohjelma on edistynyt

Projektiin on luotu syvyyshakua, dijkstran algoritmia ja A*-algoritmia vastaavat luokat ja niihin alustavat toteutukset.
Apuna on käytetty Javan valmista PriorityQueue-luokkaa. Lisäksi muutamia testejä on tehty.

## Mitä opin tällä viikolla

2d-taulukoiden käsittelyä Dijkstran algoritmissa.

## Ongelmat ja epäselvyydet

Luodun A*-algoritmin heuristiikan oikeellisuudesta en oikeen päässyt vielä perille. Lyhin reitti löytyi pienillä testauksilla,
mutta eroja Dijkstran-algoritmin toteutukseeni en löytänyt. Tätä täytyy pohtia ja A*-algoritmin toteutus lieneekin suurin epäselvyys tässä vaiheessa. 

## Mitä teen seuraavaksi

Ensi viikolla ajattelin ryhtyä tutkimaan määrittelydokumentissa mainittujen testikarttojen tuomista osaksi sovellustani.
Näitä testatessa löytyy varmasti parannuskohteita algoritmeihin. Lisäksi Javan valmiista PriorityQueue-luokasta pitäisi päästä eroon
luomalla oma toteutus siitä.
