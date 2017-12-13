# 1.MiniProjektBANK69GUI - Bank of 69 miniprojekt
Authors: Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).

                        ** ** ** DISCLAIMER: GUI FUNGERER IKKE OPTIMALT PÅ MAC ENHEDER ** ** **
                             Før du bruger vores program skal du gørende følgende:
                             Opret en connection i MySQL:
                             Username: admin
                             Password: 1234
                             Opret en database i MySQL:
                             bank2017db
                            

Vi har i dette projekt for første gang arbejdet med GUI(Graphical User Interface) rigtigt. Vi har her udarbejdet en GUI i java, i IntelliJ IDEA. GUI er lavet i en integreret version af Scenebuilder i IntelliJ, og vi har en databse, som er lavet i MySQL, som vi forbinder til IntelliJ ved hjælp af en connector. 

Når du først åbner programmet, bliver du mødt af et vindue, hvor der er et antal tabs. Antallet varierer, om du er logget ind som BR(Bankrådgiver) eller C(Customer). Selve login funktionen er endnu ikke implementeret, men er en udvidelse, der let ville kunne implementeres. Der er samlet 4 tabs, 2 som ***[BR]bankrådgiver*** har adgang til og 2 som ***[C]Kunde/bruger*** har adgang til.  

![](https://image.prntscr.com/image/vH-rxoE_RM_nx_i4PqurLg.png)  

På ***[BR]Liste over Kunder*** kan du se diverse data, såsom indestående beløb, rentesats samt tilladt overtræk for en given konto for den respektive kunde. Her skulle det være muligt, for en BR at skifte mellem de forskellige kunder og se data for kunden. Der er 3 knapper i dette vindue, *lønkonto, opsparingskonto* og en universel knap *opret DB+table*. De to første knapper, skulle skifte mellem hvilken konto for kunden du kan se data over. Den sidste knap laver en tabel i vores MySQL databse, hvor dataene bliver opbevaret. 

![](https://image.prntscr.com/image/4jUAv1yeRZu1Juw34RnRXQ.png)

Viser hvilken tab man er i

![](https://image.prntscr.com/image/SQNWEmkNRpWEBi8zrSWn1Q.png)

Viser knappen for oprettelse af tabel i databasen

På ***[BR]Opret ny kunde*** kan man som BR oprette en ny kunde, ved at indtaste data, som du får indsendt af en kunde. Herunder er der placeret textfields, hvor man kan indtaste fornavn, efternavn, CPR-Nummer og adresse. Herefter trykker du på *Opret kunde* for at sende dataene til databasen, hvorefter de bliver tilføjet til tabellen i MySQL. 
Under *Opret ny kunde* er det også muligt for en BR at oprette konti for kunden. Her er der 3 textfields til hver konto, hvor BR skal indtaste data for den respektive konto. Her skal der indtastet beløb, rentesats i procent samt det tilladte overtræk. Dette gælder for begge kontotyper. 

![](https://image.prntscr.com/image/GxmUmNqwSSmdeomN68I22w.png)

På ***[C]Kontooversigt*** skal det være muligt for kunden at se alle deres konti (I vores eksempel er der kun lønkonto og opsparingskonto). Her kan kunden se deres indestående beløb, rentesats samt tilladt overtræk. 
Der er to knapper i denne tab, lønkonto og opsparingskonto, som bare skal tage dig over til den respektive kontooversigt. 

![](https://image.prntscr.com/image/2o2bt6MQTIOufraiiZ_yOA.png)

Den sidste tab, ***[C]Overfør***, skal kunden kunne overføre penge til andre konti. Vi har valgt at lave en mindre GUI, men samtidigt lagt overførselsfunktionen i en ny tab. I overførselstabben skal kunden indtaste hvilken konto, de ønsker at overføre penge fra, hvor stort beløbet de ønsker at overføre skal være samt det p_id de ønsker at overføre til. **Dette ville i et større system være registrerings nummer eller kontonr., i vores system er det p_id, da det er det ID vi har brugt i vores database.**

![](https://image.prntscr.com/image/wlVgFKb8TYarbj6mKxVceA.png)

