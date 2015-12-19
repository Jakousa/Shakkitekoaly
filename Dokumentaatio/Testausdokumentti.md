Mitä on testattu: Shakin sääntöjä, perus siirtoja ja rajatapauksia niille. Tekoälyn loogisia siirtoja ja varmistuttiin sen valitsevan järkevästi rajoituksien (syvyysraja) sisällä.

Testit ovat JUnit testejä. Itse tekoälyä on vaikea testata kuten myös käyttöliittymän bugeja ja näitä täytyy käsin kokeilla, kuitenkin joitakin tapauksia on testattu. 

Tekoälyä on testattu kahdella testillä joista ensimmäinen varmistaa että tekoäly valitsee kaikista siirroista sellaisen joka parantaa sen suhteellista tilannetta vastustajaan. Toinen testeistä varmistaa että tekoäly suunnittelee koko syvyydeltä valintansa oikein, testissä uhataan kuningasta mutta jos kuningatar uhrataan niin kuningas selviää lopulta, tekoäly tekee uhrauksen riittävällä syvyydellä.

Tekoälyn suorituskykyä voi tarkastella myös suorituksen aikana jolloin se kertoo jokaiselle tekoälyn tekemälle siirrolle siihen kuluneen ajan. Tätä on voi tarkastella kun peluuttaa tekoälyä toistaan vastaan (jolloin näkee kuinka pelitilanteet vaikuttavat haun pituuteen) tai kasvattamalla tekoälyn haun syvyyttä jolloin ajan pitäisi kasvaa oletetulla O(b^(3d/4)) tavalla. Nämä testit antavat kuvan että kaikki toimii oletetusti.

Ohjelmaa voi myös testata pistämällä helpomman tekoälyn (syvyys n) vaikeampaa tekoälyä vastaan (syvyys m jossa m > n) jolloin vaikeamman pitäisi aina voittaa tai tilanteen päätyä siihen että molemmat pelaajat suojelevat omia nappuloita eikä peli etene.

Tekoälyä on empiirisesti testattu tilanteissa joissa yksinkertaisempaa tekoälyä (syvyys 2) on yritetty hämätä ihmistä vastaan. Tekoäly on valinnut oletettavan reitin. Tämä on helposti tarkasteltu pitämällä silmällä kuinka suuria vaihtoja tekoäly voi tietää tapahtuvan siirtämällä nappula syötiksi. Esimerkiksi syöttämällä vaaraton torni sotilaalle niin, että tämä avaa reitin kuningattarelle voittaa pelin seuraavalla vuorolla.

Suorituskykytestejä on tehty tilanteissa joissa aluksi löytyy paras siirto verrattuna tilanteeseen jossa jokainen edellisestä seuraava siirto on parempi, tällä varmistuttiin myös alpha-beta karsinnan toimivuudesta.

Aikavaativuuteen liittyvät kokeilut: 
Kaikissa valintana on yksi peli, näistä voidaan erikseen tarkastella pelejä jotka eivät sovi kuvaan.
Vaikeustaso 1: 
	1v1: 38ms/11siirtoa ka = 3ms.
	1v1: 21ms/11siirtoa ka = 1ms.
	1v2: 40ms/11siirtoa ka = 3ms.
	1v3: 20ms/14siirtoa ka = 1ms.
	1v4: 14ms/29siirtoa ka = 0,5ms.
	1v5: 15ms/12siirtoa ka = 1ms.
Vaikeustaso 2:
	1v2: 146ms/11siirtoa ka = 13ms.
	2v2: Peli "pysähtyy" nappuloiden edes-takaisin siirtoihin.
	2v3: 152ms/29siirtoa ka = 4ms.
	2v4: 90ms/37siirtoa ka = 2ms.
	2v5: 12ms/8siirtoa ka = 1ms.
Vaikeustaso 3: 
	1v3: 821ms/14siirtoa ka = 58ms.
	2v3: 2463ms/29siirtoa ka = 84ms.
	3v3: Peli "pysähtyy" nappuloiden edes-takaisin siirtoihin.
	3v4: 1507ms/21siirtoa ka = 71ms.
	3v5: 1021ms/16siirtoa ka = 63ms.
Vaikeustaso 4: 
	1v4: 28172ms/29siirtoa ka = 971ms.
	2v4: 51567ms/37siirtoa ka = 1393ms.
	3v4: 48088ms/21siirtoa ka = 2289ms.
	4v4: Peli "pysähtyy" nappuloiden edes-takaisin siirtoihin.
	4v5: Peli "pysähtyy" nappuloiden edes-takaisin siirtoihin.
Vaikeustaso 5:
	1v5: 205570ms/12siirtoa ka = 17130ms.
	2v5: 221555ms/8siirtoa ka = 27694ms.
	3v5: 1030463ms/16siirtoa ka = 64403ms.
	4v5: Peli "pysähtyy" nappuloiden edes-takaisin siirtoihin.

Tarkastellaan siirtojen ajankulutusta keskeneräisessä pelissä. Valkoinen pelaaja ensin ja sitten musta.
	2v2: 237ms. ja 219ms. siirrossa 26. Keskiarvot 9ms ja 8ms.
	3462ms. ja 2741ms. siirrossa 834. Keskiarvot 4ms ja 3ms.
	3v3: 2587ms. ja 2156ms. siirrossa 26. Keskiarvot 99ms ja 82ms.
	4v4: 21885ms. ja 22866ms. siirrossa 26. Keskiarvot 841ms ja 879ms.
	4v5: 4: 55827ms/26siirtoa ka = 2147ms.
	     5: 2120062ms/26siirtoa ka = 81540ms.
	     4: 68820ms/40siirtoa ka = 1720ms.
	     5: 2536876ms/40siirtoa ka = 63671ms.
	5v5: 2476865ms/20siirtoa ka = 123843ms.
	     1067614ms/20siirtoa ka = 53380ms.

Jatkuvalla kokeilulla huomattiin että ainakin ei-keskeneräisten pelien tulokset vastaavat samoja riippumatta kumpi on valkoinen. Ei osata vastata kysymykseen miksi 5v5 toisella pelaajalla kestää huomattavasti pidempään päätöksissä. 
Epäiltiin että ohjelman toteutuksessa musta jää alakynteen jollakin tavalla, mutta 4v4 pelin aikana vuorolla 19-20 muuttuu keskiarvo siten, että vuorolla 19 Musta:783ms Valkoinen: 794 ja vuorolla 20 Musta: 800 Valkoinen: 785. Huomattiin myös että ennen tätä vaihdosta musta on nopeampi ja tämän jälkeen hitaampi.


