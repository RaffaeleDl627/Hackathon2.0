Ho iniziato creando una classe Piattaforma che ha come responsabilità di pubblicare la classifica finale.

La piattaforma è composta dai suoi iscritti, ma potrebbe esistere anche senza di essi. 
Le classi "Organizzatore", "Giudice" e "Utenti", 
sono generalizzazioni della classe "iscrittoAllaPiattaforma" poiché ognuno di essi è iscritto a quest'ultima. 


Ho deciso di rendere la classe organizzatore aggregato 
con rombo pieno poiché senza un organizzatore, l'evento non potrebbe esistere. 

Come la classe utenti è aggregato della classe Team che, per l'appunto, è composto da almeno 1 utente.

La classe voto è una classe associativa, che ha senso di esistere solo se 
esiste la classe giudice e la classe file da giudicare.
Esattamente come la classe Registrazione/iscrizione che ha senso di esistere
solo se esiste l'evento in quel determinato lasso di tempo.

Nel pakage gui, ho inserito un'interfaccia grafica in cui, in tempo di esecuzione
viene mostrata una finestra con all'interno una jcombobox che presenta 5 eventi hackathon con attributi diversi 
(implementati con un'arraylist<hackathons>).

Nel package controller, c'è una classe rinominata Ctrl 
Mantiene una lista di oggetti 'Hackathon'
Fornisce metodi per accedere e gestire questi dati
'getHackathons()': Restituisce l'intera lista degli hackathon
'getDettagliHackathon(int index)':
        - Prende un indice come parametro;
        - Recupera l'hackathon corrispondente;
        - Formatta i dettagli (titolo, sede, numero massimo iscritti, dimensione team, durata);
        - Restituisce una stringa formattata con tutte le informazioni;
        - Controlla che l'indice richiesto sia valido (tra 0 e la dimensione della lista)
        - Se l'indice non è valido, restituisce "Nessun hackathon selezionato"

Questa classe agisce come intermediario tra l'interfaccia utente (gui) e i dati dell'hackathon
