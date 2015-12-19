Ohjelman yleisrakenne:
Ohjelmassa shakki on toteutettu listalla nappuloita ja niitä vastaavilla luokilla on säännöt nappulan toiminnasta. Luokka Lauta joka pitää sisällään listaa pystyy siirtämään shakin nappuloita.
Tekoäly tekee arvion minmax algoritmilla käyttäen alpha-beta karsintaa ja pyytää luokalta Lauta listaa nappuloista ja pyytää sitä siirtämään nappuloita.

Saavutetut aika- ja tilavaativuudet.
Aikavaativuuksista: Tekoäly käy jokaisen nappulan läpi (32 alkupelissä) ja tarkistaa ensin onko se oma nappula, sitten koittaa siirtää sitä jokaiseen paikkaan omien sääntöjensä mukaan (max 7+7+7+6=27 ruutua kuningattaren ollessa keskikentällä). Ja tämä toistuu syvyydellä 2 kaksi kertaa niin että jokaisen nappulan jokaiselle siirrolle kysytään vastustajan nappuloista samaa. Eli aikavaativuus pitäisi olla O(b^d) jossa b = mahdollisten siirtojen määrä ja d on syvyys. Jos koska Alpha-beta karsii puun oksia syvyydessä niin aikavaativuus pienenee O(b^(3d/4)).

Tilavaativuuksista: Tekoäly luo jokaiselle (max 32) nappulalle mahdollista siirtoa vastaavan tilanteen (32 nappulaa) ja katsoo näistä parhaimman. 32 * 32 (Jokaiselle nappulalle tilanne jossa nappulat ovat eri paikoissa) ja tätä jatketaan syvyyden verran, pahimmillaan siis O(m^d) missä m tarkoittaa toteutetussa ohjelmassa nappuloiden määrää ja d syvyyttä.

Työn mahdolliset puutteet ja parannusehdotukset.
Voitaisiin tallentaa koko siirtojen puu, ja karsia ne joita vastustaja ei valinnut. Sitten rakennettaisiin tulevat siirrot sen puun lehdille. Tällöin tilavaativuus kasvaisi mutta voitaisiin leikata pelinaikaisia laskuja huomattavasti.

Lähteitä:
https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning
