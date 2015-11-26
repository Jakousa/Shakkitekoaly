Mitä on testattu: Shakin sääntöjä, perus siirtoja ja rajatapauksia niille. Tekoälyn loogisia siirtoja ja varmistuttiin sen valitsevan järkevästi rajoituksien (syvyysraja) sisällä.

Testit ovat JUnit testejä. Itse tekoälyä on vaikea testata kuten myös käyttöliittymän bugeja ja näitä täytyy käsin kokeilla, kuitenkin joitakin tapauksia on testattu. 

Tekoälyä on testattu kahdella testillä joista ensimmäinen varmistaa että tekoäly valitsee kaikista siirroista sellaisen joka parantaa sen suhteellista tilannetta vastustajaan. Toinen testeistä varmistaa että tekoäly suunnittelee koko syvyydeltä valintansa oikein, testissä uhataan kuningasta mutta jos kuningatar uhrataan niin kuningas selviää lopulta, tekoäly tekee uhrauksen riittävällä syvyydellä.

Tekoälyn suorituskykyä voi tarkastella myös suorituksen aikana jolloin se kertoo jokaiselle tekoälyn tekemälle siirrolle siihen kuluneen ajan. Tätä on voi tarkastella kun peluuttaa tekoälyä toistaan vastaan (jolloin näkee kuinka pelitilanteet vaikuttavat haun pituuteen) tai kasvattamalla tekoälyn haun syvyyttä jolloin ajan pitäisi kasvaa oletetulla O(b^(3d/4)) tavalla. Nämä testit antavat kuvan että kaikki toimii oletetusti.

Ohjelmaa voi myös testata pistämällä helpomman tekoälyn (syvyys n) vaikeampaa tekoälyä vastaan (syvyys m jossa m > n) jolloin vaikeamman pitäisi aina voittaa tai tilanteen päätyä siihen että molemmat pelaajat suojelevat omia nappuloita eikä peli etene.

Tilanne jossa peli ei etene on hieman turhauttavaa katsella, törmäsin kummalliseen tilanteeseen jossa tekoälyt ensin siirtelivät torneja vuorotellen eikä peli edennyt muutamaan sekuntiin kunnes yllättäen toinen pelaajista siirsikin eri nappulaa. Yritän vielä selvittää syitä tai saada näin tapahtumaan toistuvasti.

Tekoälyä on empiirisesti testattu tilanteissa joissa yksinkertaisempaa tekoälyä (syvyys 2) on yritetty hämätä ihmistä vastaan. Tekoäly on valinnut oletettavan reitin. Tämä on helposti tarkasteltu pitämällä silmällä kuinka suuria vaihtoja tekoäly voi tietää tapahtuvan siirtämällä nappula syötiksi. Esimerkiksi syöttämällä vaaraton torni sotilaalle niin, että tämä avaa reitin kuningattarelle voittaa pelin seuraavalla vuorolla.

Suorituskykytestejä on tehty tilanteissa joissa aluksi löytyy paras siirto verrattuna tilanteeseen jossa jokainen edellisestä seuraava siirto on parempi, tällä varmistuttiin myös alpha-beta karsinnan toimivuudesta.
