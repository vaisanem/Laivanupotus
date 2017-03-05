**Aihe:** Toteutus perinteisestä laivanupotus-pelistä. 
Yksinpelattava. Kaikki originaalit toiminnot on tarkoitus toteuttaa vähintään, poislukien vuoro vaihtuu aina riippumatta osuuko pelaaja ammuksellaan. Laivan uppoamisesta ei myöskään saa ilmoitusta. Kaksijakoinen näkymä, missä oikealla on oman laivueen tilanne, ja vasemmalla näkymä jo ammutuista sijainneista ja osumista.  
  
**Käyttäjät:** Pelaaja  
  
**Toiminnot:** Laivueen asettaminen pelilaudalle, ohjuksen laukaisu tiettyyn koordinaattiin  

##Rakennekuvaus
Kukin laiva on 2-5 mittayksikköä pitkä, partikkeli on yhden mittayksikön kokoinen. Pelaajalla on täsmälleen 5 laivaa, lisäksi ammuttuja laukauksia jokaiselta pelikierrokselta, kuitenkin aluksi 0. Toteutetussa peliversiossa on yksi pelaaja ja yksi AI, jotka ovat Game-luokan oliomuuttujina. ControlPanelin avulla toteutetaan pelitoiminnot, Display esittää ne pelaajalle, Game-luokan nekin.  
##Luokkakaavio
![Luokkakaavio](/dokumentaatio/Laivanupotusluokkakaavio.png)  
##Sekvenssikaavio
![Sekvenssikaavio, laivan lisäys](/dokumentaatio/Player-adding-a-ship.png)  
##Sekvenssikaavio
![Sekvenssikaavio, ohjuksen lisäys](/dokumentaatio/Player-adding-a-shot.png)
