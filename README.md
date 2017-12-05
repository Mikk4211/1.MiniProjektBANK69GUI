# 1.MiniProjektBANK69GUI - Bank of 69 miniprojekt
Authors: Mathias Bruun(TejsFrank), Mads Nielsen(TheCaptain420), Johan Stenboeg(JohanStenboeg), Benjamin Ejrup(Wexr), Mikkel Sørensen(Mikk4211).

                  ** ** ** DISCLAIMER: GUI FUNGERER IKKE OPTIMAL PÅ MAC ENHEDER ** ** **

Vi har i dette projekt for første gang arbejdet med GUI(Graphical User Interface) rigtigt. Vi har her udarbejdet en GUI i java, i IntelliJ IDEA. GUI er lavet i en integreret version af Scenebuilder i IntelliJ, og vi har en databse, som er lavet i MySQL, som vi forbinder til IntelliJ ved hjælp af en connector. 

Når du først åbner programmet, bliver du mødt af et vindue, hvor der er et antal tabs. Antallet varierer, om du er logget ind som BR(Bankrådgiver) eller C(Customer). Selve login funktionen er endnu ikke implementeret, men er en udvidelse, vi ville implementere. 
De 4 tabs, som BR er Liste over Kunder, Opret Ny Kunde, Opret ny Konto - den sidste tab er Kontooversigt, som både C og BR har mulighed for at gå ind på. 

På *Liste over Kunder* kan du se diverse data, såsom indestående beløb, rentesats samt tilladt overtræk for en given konto for den respektive kunde. Her skulle det være muligt, for en BR at skifte mellem de forskellige kunder og se data for kunden. Der er 3 knapper i dette vindue, *lønkonto, opsparingskonto* og en universel knap *opret DB+table*. De to første knapper, skulle skifte mellem hvilken konto for kunden du kan se data over. Den sidste knap laver en tabel i vores MySQL databse, hvor dataene bliver opbevaret. 

På *Opret ny kunde* kan man som BR oprette en ny kunde, ved at indtaste data, som du får indsendt af en kunde. Herunder er der placeret textfields, hvor man kan indtaste fornavn, efternavn, CPR-Nummer og adresse. Herefter trykker du på *Opret kunde* for at sende dataene til databasen, hvorefter de bliver tilføjet til tabellen i MySQL.

På *Opret ny konto* kan du vælge mellem de kunder, du har ansvar for som BR. Efter du har valgt en kunde, kan du indtaste data i to textfields. Her skal der indtastes konto navn samt korttypen, kontoen skal være registreret under (mastercard, visa m.fl.). Herefter trykkes der på *opret konto* og dataene bliver sendt til databasen i MySQL, og de bliver indsat i tabellen.

Den sidste tab, *Kontooversigt*, skal det være muligt for kunden at se alle deres konti (I vores eksempel er der kun lønkonto og opsparingskonto). Her kan kunden se deres indestående beløb, rentesats samt tilladt overtræk. 
Der er to knapper i denne tab, lønkonto og opsparingskonto, som bare skal tage dig over til den respektive kontooversigt. 
