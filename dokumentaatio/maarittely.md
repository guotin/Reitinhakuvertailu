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

Ohjelma käyttää pääasiallisena syötteenään valmiiksi muodostettuja testisyötteitä. Lisäksi käyttäjältä kysytään
minkä algoritmin avulla polku muodostetaan.



