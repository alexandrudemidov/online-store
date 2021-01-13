# online-store
Pentru realizarea proiectului propus, echipa noastră a dezvoltat o aplicație Java folosind Spring Boot + Gradle și H2 pentru baza de date in-memory.
Scopul proiectului a fost integrarea modelor de proiectare studiate în cadrul aplicației. Astfel, am reușit să dezvoltăm o aplicație ce permite:
•	Înregistrarea tranzacțiilor aferente magazinului online
•	Înregistrarea tranzacțiilor prin intermediul unui vendor
•	Filtrarea tranzacțiilor după dată
•	Vizualizarea tuturor tranzacțiilor
•	Generarea unui raport financiar în funcție de intrările înregistrate


Fig. 1 Structura aplicației Java
După cum se poate observa în fig. 1 aplicația este împărțită pe mai multe nivele:
•	Controller – Contribuie la comunicarea cu clientul
•	Model – Se regăsește modelul de date
•	Repository – Interacțiunea cu baza de date
•	Service – Logica de prelucrare al aplicației
 
Fig. 2 – Transaction Controller
În fig. 2 este exemplificat modul în care clientul poate accesa aplicația dezvoltată de către echipa noastre. Se pot observa 3 tipuri de operații propuse către client:
•	Înregistrarea unei tranzacții printr-un POST request
•	Vizualizarea tuturor tranzacțiilor înregistrate printr-un GET request
•	Filtrarea tranzacțiilor în funcție de date

În cadrul proiectului se regăsesc următoarele modele de proiectare:
•	Singleton
•	Proxy
•	Template
Singleton
Problema pe care am rezolvat-o prin intermediul acestui model de proiectare a fost inițializarea a unei singure referințe la magazinul online pe care îl gestionăm pe toata durata execuției aplicației, astfel asigurând persistența necesară. Se salvează o singură intrare în baza de date, care după își modifică valoarea venitului încasat în funcție de context. 


Proxy
	Problema pe care am rezolvat-o prin intermediul acestui model de proiectare a fost încasarea tranzacțiilor efectuate de către un vendor partener cu magazinul online. Luând în calcul piața actuală, în cazul parteneriatelor respective se încasează un comision, astfel în momentul în care tranzacția este înregistrată pe site-ul vendorului permite calcul sumei pe care urmează să o încaseze magazinul online pe care îl gestionăm. Practic există o barieră între tranzacția clientului și magazinul.
Template
	Problema pe care am rezolvat-o prin intermediul acestui model de proiectare a fost definirea unor pași exacți ce trebuie urmați în momentul în care se generează un raport financiar. Fiind un lucru cu caracter regulator este nevoie de urmarea acestui „algoritm” cu strictețe, evitând omiterea anumitor pași. Din acest punct de vedere, modelul de proiectarea discutat mai sus a fost cel mai potrivit pentru magazinul online.

Interacțiunea cu baza de date se face la nivel in-memory, operațiile ce se pot regăsi în cadrul aplicației sunt:
•	Crearea de tabele (Echipa noastră a folosit adnotări din JPA pentru a simplifica procesul)
•	Interogarea tabelelor pentru a obține date
•	Adăugarea de înregistrări noi
•	Modificarea înregistrărilor deja existente
