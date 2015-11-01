Aihe: Shakkitekoäly

Ohjelman tarkoituksena on tarkastella tekoälyä shakissa, koska mahdollisia tilanteita on noin 10^43, ei ongelmaa ratkaista käymällä läpi jokaista vaihtoehtoa vaan tarkastellaan Alpha-Beta karsintaa erilaisilla syvyyksillä (ja mahdollisesti Minmax-algoritmia).

Tekoäly ottaa syötteekseem sen hetkisen pelitilanteen ja antaa tuloksena parhaan löytämänsä siirron. Aikavaativuutena odotettavissa on O(b^d) jossa b on haarautumisaste ja d läpikäytävä syvyys. Keskiarvon pitäisi olla lähellä O(b^(3d/4))

Lähteet: https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning
