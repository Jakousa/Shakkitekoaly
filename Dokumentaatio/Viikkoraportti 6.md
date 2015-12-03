Löysin hienon bugin. Tekoäly ei tiedä että peli tosiaan loppuu oman kuninkaan menetykseen. Uhrasi kuninkaan toisen kuningasta varten ja hävisi pelin siksi.
Ongelma oli helppo korjata, jos merkitään puussa lehdiksi ne joiden lauta-arviot ovat niin "suuret" että jokin kuningas on syöty. Vaati testien uudelleen kirjoittamista.

Päätin kuitenkin että paras tapa tallentaa on vain nappulat listassa. Logiikan puolesta voidaan vain laskea ruudun koolla. Toki siinä pitää käydä lista usein läpi mutta pelin jatkuessa lista pienenee, kun taas 8x8 ruudukkoa on ikävämpi tehdä uudelleen tekoälyn arvioidessa.

Ohjelman edistyminen ei ole nyt oikein kummoista kun olen lähinnä metsästänyt raja- ja poikkeustapauksia.

Mitä opin tältä viikolta:
Jouduin kummastuksiin kun yritin tehdä erästä testiä ja löysin sieltä tilanteen jossa voittava pelaaja ei suostunut syömään kuningasta. Jahtasin bugia puolitoista tuntia kunnes tajusin että tekoäly on vain fiksumpi shakissa kuin tekijänsä..
Ehkä myös jotain TDDstä siinä mielessä, että tuntuu tyhmältä jahdata virheitä niin että teen testin ja huomaan sen jälkeen että se ei menekkään läpi. Erityisesti kun shakin ja samassa tekoälyn säännöt voi vain tehdä virheellisesti vaikka se olisikin toimiva.

Ongelmia:
Se on aika tarkka avunpyyntö mutta olen hieman hukassa alphabetaTest luokassa olevan tapahtuukoKarsintaa testin kanssa. Luvut tuntuvat minusta olevan väärin päin ja en millään keksi mikä vikana. Jos en löydä mitään niin se kyllä tulee lopulliseen palautukseen..

Mitä teen seuraavaksi:
Valmistaudun palautukseen. Esim voisin tehdä luokkien alkuun kentän rajoja vastaavat arvot ja syöttää niitä metodeihin. Kovakoodaus on rumaa hyi hyi.
