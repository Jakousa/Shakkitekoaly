Viikkoraportti kirjoitettu jaksottaisen edistymisen jälkeen/aikana.

Poistettiin deque ja korvattiin kahdella listalla joita kopioidaan.

Lisättiin listat musta ja valkoinen ja niille toiminnot metodeihin, valmistaudutaan poistamaan vanhat "lauta" viittaukset joissa vain halutaan toinen väri. (Tämän pitäisi vähentää aikavaativuutta).

Kokeillaan aluksi vaihtoehtoa jossa tallennetaan nappulat matriisiin niin voidaan löytää nappuloille reitti tarkastelemalla vain sijainteja.

Keksin suorituskykytestin jota en ole vielä 17:09 torstaina toteuttanut. Aion pistää nappulat listaan niin että jokainen listan seuraava siirto on edellistä parempi ja toisinpäin saman. Alpha-beta karsinnan pitäisi leikata ensimmäinen heti ja tapauksessa jossa se on toisinpäin sen pitäisi käydä läpi loppuun asti.

Paljon metodien uudelleen kirjoittamista hieman tehokkaampiin versioihin. Luin https://chessprogramming.wikispaces.com/Alpha-Beta sivulta ja sivun linkeistä hyviä keinoja tehokkuuden parantelemiseen: Jos saisin järjestettyä oksat niin että mahdollisesti paras käydään ensin, esimerkiksi tilanne jossa syödään, niin alpha-beta karsisi enemmän pois.

Nappuloilla uusi metodi joka palauttaa nappulan mahdolliset paikat. Nyt ei enää tarvitse käydä jokaista pelilaudan ruutua läpi, säilytettiin vanhat metodit koska niillä on helpompi tehdä tarkistuksia muualla. Aikavaativuus pieneni.

Miten ohjelma on edistynyt:
Hienosti, keksin muutaman eri kokeilemisen arvoisen yrityksen ja yhden tein lopulliseksi. Lisäsin javadoceja luokille ja kirjoitin testaus- ja toteutusdokumentin. Testejä en kirjoittanut mutta keksin muutaman tekemisen arvoisen. Tosin ei ne aivan valmiita vielä ole kun muutoksia tuli tälläkin viikolla ohjelman tehokkuuteen.

Mitä opin tällä viikolla:
Testien kunnioitusta, oli helpottavaa tietää että ohjelma toimii kun lähti muuttamaan isoja osia.
Kävin myös https://chessprogramming.wikispaces.com/Alpha-Beta lukemassa Alpha-Betasta ja mietin tuota liikkeen järjestämistä "Move Ordering" ja miten voisin sen toteuttaa tässä.

Mitä jäi epäselväksi/ vaikeuksia:
-

Mitä teen seuraavaksi:
Jatkan samaa, yritän keksiä tapoja leikata aikaa. Siistin koodia, siellä on jäänyt kommentoituina vanhoja koodinpätkiä. Myös yritän päättää mikä on älykkäin tapa tallentaa nappulat, tällä hetkellä Lauta luokassa on 3 erilaista tapaa. Pelkkästään nappulat, molemmille väreille oma ja matriisi jossa paljon tyhjää. Jokaisessa tuntuu olevan hyvät ja huonot puolet mutta vain yksi on lopulta hyödyllistä jättää.
