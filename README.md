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
