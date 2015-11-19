Ohjelman yleisrakenne:
Ohjelmassa shakki on toteutettu listalla nappuloita ja niitä vastaavilla luokilla on säännöt nappulan toiminnasta. Luokka Lauta joka pitää sisällään listaa pystyy siirtämään shakin nappuloita.
Tekoäly tekee arvion metodien mukaan ja pyytää luokalta Lauta listaa nappuloista ja pyytää sitä siirtämään nappuloita.

Saavutetut aika- ja tilavaativuudet.
Aikavaativuuksista: Tekoäly käy jokaisen nappulan läpi (32 alkupelissä) ja tarkistaa ensin onko se oma nappula, sitten koittaa siirtää sitä jokaiseen paikkaan laudalla (64 ruutua). Ja tämä toistuu syvyydellä 2 kaksi kertaa niin että jokaisen nappulan jokaiselle siirrolle kysytään vastustajan nappuloista samaa. Eli aikavaativuus pitäisi olla O(b^d) jossa b = 32*64 ja d on syvyys. Jos Alpha-beta on oikeasti toimiva niin aikavaativuus on pienempi.

Työn mahdolliset puutteet ja parannusehdotukset.
Tallennetaan omat ja vastustajan nappulat omiin listoihin (ei tarvitse aina tarkistaa onko nappula oma, saadaan aikavaativuuden b pienennettyä) Voitaisiin myös käydä läpi nappuloilta vain ne paikat jotka kulkevat niitä suoria pitkin joille nappulat voivat mennä. Myös pienentää b:tä paljon.

Ei ulkoisia lähteitä.
