## Beschreibung  
- Ein einfacher terminal-basierter Rechner, der in der Lage ist, mehrere Operationen in einer einzigen Eingabe zu verarbeiten.  
- GUI wurde in Version 2.0 hinzugefügt.  

## Funktionen in Version 1.0  
- Grundlegende arithmetische Operationen: Addition, Subtraktion, Multiplikation, Division  
- Unterstützt zusammengesetzte Ausdrücke mit korrekter Operatorpriorität (keine Klammern in 1.0, aber "-7+3" funktioniert)  
- Eingabevalidierung und grundlegende Fehlerbehandlung  
- GUI (erst ab Version 2.0)  
- Unterstützung für Klammern (erst ab Version 2.0)  

## Technologien & Konzepte  
- Geschrieben in Java  
- Terminal-basiert (kein GUI in 1.0)  
- GUI mit JavaFX (ab 2.0)  
- Implementierte Algorithmen:  
    - Tokenisierung (String zu Liste von Strings)  
    - Shunting Yard Algorithmus (Infix zu Postfix)  
    - Reverse Polish Notation (Postfix-Auswertung)  
- Verwendete Sprachfeatures:  
    - switch-Anweisungen  
    - reguläre Ausdrücke  
    - Datenstrukturen:  
        - Stacks  
        - Listen  

# Was ich gelernt habe  
- Wie man mathematische Ausdrücke programmatisch analysiert und auswertet  
- Verständnis für Operatorpriorität und Ausdrucks-Parsing  
- Grundkenntnisse der Java-Standardbibliotheken  
- Grundlagen der GUI-Programmierung mit JavaFX  

## Mögliche zukünftige Verbesserungen  
- GUI weiter verbessern (bereits begonnen in 2.0)  
- Unterstützung für Klammern vollständig implementieren (in 2.0)  
- Erweiterte Fehlerbehandlung und Eingabevalidierung  
- Unterstützung weiterer mathematischer Operationen  

## Projektmotivation  
- Vorbereitung auf das Informatikstudium: Ich habe tiefere Kenntnisse grundlegender Datenstrukturen, Stacks und Java-Bibliotheken erworben.  
- Ich habe ChatGPT genutzt, um spezifische Konzepte zu verstehen, wie switch-Anweisungen oder den Shunting Yard Algorithmus.  


### Starting prompt:
mvn clean javafx:run
