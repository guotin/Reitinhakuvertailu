# Määrittelydokumentti

Ohjelman ideana on vertailla muutamaa tunnettua reitinhakualgoritmia erilaisilla verkoilla. 
Vertailussa huomioidaan löydetyn polun pituus ja käytetty aika sen etsimiseen.

## Toteutettavat algoritmit ja tietorakenteet

Ohjelmaan toteutetaan seuraavat algoritmit:
 - A*-algoritmi
 - Dijkstran algoritmi
 - Syvyyshaku

Lisäksi ohjelmaan toteutetaan näiden hakualgoritmien vaatimat tietorakenteet. Dijkstran algoritmi ja A*-algoritmi käyttävät 
aputietorakenteenaan kekoa.
Vertailussa käytettävät verkot tullaan toteuttamaan 2d-taulukoilla.

Kyseiset algoritmit valittiin vertailuun siksi, että ne toimivat kaikki hieman eri tavoin ja ovat silti kaikki yleisesti käytettyjä.

## Tavoitteena olevat aika- ja tilavaativuudet

Vertailussa käytettävät verkot tallennetaan 2d-taulukoihin, jolloin verkkojen tilavaativuus on luokkaa O(n * m).
Syvyyshaku toimii ajassa O(n + m) , Dijkstran algoritmi toimii ajassa O(n + m * log * n) ja A*-algoritmin heuristiikka pyritään toteuttamaan 
niin, että algoritmin aikavaativuus olisi pienempää kuin Dijkstran algoritmilla.

## Ohjelman käyttö ja syötteet

Ohjelma käyttää pääasiallisena syötteenään valmiiksi muodostettuja testisyötteitä. Näistä käyttäjä voi valita mieleisensä.
Lisäksi käyttäjältä kysytään minkä algoritmin avulla polku muodostetaan. Ohjelman ideana on lopuksi tulostaa käyttäjälle tietoja muodostetusta polusta, esimerkiksi askelten määrä ja sen löytämiseen käytetty aika.

## Lähteet

- A*-algoritmi: [Wikipedia](https://en.wikipedia.org/wiki/A*_search_algorithm)

- Dijkstran algoritmi: [Wikipedia](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)

- Syvyyshaku: [Wikipedia](https://en.wikipedia.org/wiki/Depth-first_search)

- Tietorakenteet ja algoritmit - Antti Laaksonen - 2.10.2019: [Linkki kirjaan](https://www.cs.helsinki.fi/u/ahslaaks/tirakirja/)



