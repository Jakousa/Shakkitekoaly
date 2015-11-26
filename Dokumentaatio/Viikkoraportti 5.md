Viikkoraportti kirjoitettu jaksottaisen edistymisen jälkeen/aikana.

Poistettiin deque ja korvattiin kahdella listalla joita kopioidaan.

Lisättiin listat musta ja valkoinen ja niille toiminnot metodeihin, valmistaudutaan poistamaan vanhat "lauta" viittaukset joissa vain halutaan toinen väri. (Tämän pitäisi vähentää aikavaativuutta). 
Kokeillaan aluksi vaihtoehtoa jossa tallennetaan nappulat matriisiin niin voidaan löytää nappuloille reitti tarkastelemalla vain sijainteja.

Keksin suorituskykytestin jota en ole vielä 17:09 torstaina toteuttanut. Aion pistää nappulat listaan niin että jokainen listan seuraava siirto on edellistä parempi ja toisinpäin saman. Alpha-beta karsinnan pitäisi leikata ensimmäinen heti ja tapauksessa jossa se on toisinpäin sen pitäisi käydä läpi loppuun asti.

Paljon metodien uudelleen kirjoittamista hieman tehokkaampiin versioihin. Luin https://chessprogramming.wikispaces.com/Alpha-Beta sivulta ja sivun linkeistä hyviä keinoja tehokkuuden parantelemiseen: Jos saisin järjestettyä oksat niin että mahdollisesti paras käydään ensin, esimerkiksi tilanne jossa syödään, niin alpha-beta karsisi enemmän pois.
