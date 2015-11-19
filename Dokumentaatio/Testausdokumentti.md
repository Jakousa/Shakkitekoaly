Mitä on testattu: Shakin sääntöjä, perus siirtoja ja rajatapauksia niille.

Testit ovat JUnit testejä. Itse tekoälyä on vaikea testata kuten myös käyttöliittymän bugeja ja näitä täytyy käsin kokeilla. 

Tekoälyn suorituskykyä voi tarkastella myös suorituksen aikana jolloin se kertoo jokaiselle tekoälyn tekemälle siirrolle siihen kuluneen ajan. Tätä on helppo tarkastella kun peluuttaa tekoälyä toistaan vastaan (jolloin näkee kuinka pelitilanteet vaikuttavat haun pituuteen) tai kasvattamalla tekoälyn haun syvyyttä jolloin ajan pitäisi kasvaa oletetulla O(b^d) tavalla.

Ohjelmaa voi myös testata pistämällä helpomman tekoälyn (syvyys n) vaikeampaa tekoälyä vastaan (syvyys m jossa m > n) jolloin vaikeamman pitäisi aina (en oikeasti tiedä) voittaa.
