Ohjelman yleisrakenne:
Ohjelmassa shakki on toteutettu listalla nappuloita ja niitä vastaavilla luokilla on säännöt nappulan toiminnasta. Luokka Lauta joka pitää sisällään listaa pystyy siirtämään shakin nappuloita.
Tekoäly tekee arvion metodien mukaan ja pyytää luokalta Lauta listaa nappuloista ja pyytää sitä siirtämään nappuloita.

Saavutetut aika- ja tilavaativuudet.
Aikavaativuuksista: Tekoäly käy jokaisen nappulan läpi (32 alkupelissä) ja tarkistaa ensin onko se oma nappula, sitten koittaa siirtää sitä jokaiseen paikkaan laudalla (64 ruutua). Ja tämä toistuu syvyydellä 2 kaksi kertaa niin että jokaisen nappulan jokaiselle siirrolle kysytään vastustajan nappuloista samaa. Eli aikavaativuus pitäisi olla O(b^d) jossa b = 32*64 ja d on syvyys. Jos koska Alpha-beta karsii puun oksia syvyydessä niin aikavaativuus pienenee O(b^(3d/4)).

Tilavaativuuksista: Tekoäly luo jokaiselle (max 32) nappulalle mahdollista siirtoa vastaavan tilanteen (32 nappulaa) ja katsoo näistä parhaimman. 32 * 32 (Jokaiselle nappulalle tilanne jossa nappulat ovat eri paikoissa) ja tätä jatketaan syvyyden verran, pahimmillaan siis O(m^d) missä m tarkoittaa toteutetussa ohjelmassa nappuloiden määrää ja d syvyyttä.

Työn mahdolliset puutteet ja parannusehdotukset.
Tallennetaan omat ja vastustajan nappulat omiin listoihin (ei tarvitse aina tarkistaa onko nappula oma, saadaan aikavaativuuden b pienennettyä) Voitaisiin myös käydä läpi nappuloilta vain ne paikat jotka kulkevat niitä suoria pitkin joille nappulat voivat mennä. Tämä myös pienentää b:n suuruutta.

Ei ulkoisia lähteitä.
