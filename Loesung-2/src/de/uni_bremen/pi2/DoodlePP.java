package de.uni_bremen.pi2;

import java.util.Arrays;

public class DoodlePP
{
    static int[] result;
    /**
     *  Aufgaben 2-4 sind ganz unten in der Klasse DoodlePPTest !!!
     *
     * Die Methode berechnet für eine Menge von Studierenden eine Zuordnung zu einer Menge von Tutorien.
     * Jede Studierende kann nur genau einem Tutorium zugewiesen werden. Studierende geben an, welche
     * Tutorien für sie überhaupt in Frage kommen und können nur diesen Tutorien zugewiesen werden.
     * Studierende werden anhand ihres Indexes im ersten Parameter der Methode identifiziert und Tutorien
     * anhand ihres Indexes im zweiten Parameter identifiziert, d.h. beides sind eigentlich nur Zahlen.
     * @param studentAvailabilities Das zweidimensionale Array enthält für jede Studierende (1. Dimension),
     *         an welchen Tutorien sie teilnehmen könnte (2. Dimension). Die Reihenfolge der zweiten
     *         Dimension entspricht der Reihenfolge im nächsten Parameter.
     * @param tutorialCapacities Enthält für jedes Tutorium, wie viele Plätze es gibt. Die Methode
     *         aktualisiert die Einträge, so dass auch nach dem Aufruf noch vermerkt, wie viele Plätze
     *         dann noch pro Tutorium verfügbar sind.
     * @return Ein Array, in dem für jede Studierende steht, welchem Tutorium sie zugeordnet wurde. Gab
     *         es keine Lösung, wird null zurückgegeben.
     */
    public static int[] distribute(final boolean[][] studentAvailabilities, final int[] tutorialCapacities){

        int i = studentAvailabilities.length;
        result = new int[i];
        //steht bei einem Studenen -1 heißt dies er ist noch keinem Tutorium zugewiesen
        for ( int x: result )
        {
            x=-1;
        }

        int j=0;
        // Studienten durchlaufen
        for ( int a = 0;a < i; a++ )
        {
            if (j >= tutorialCapacities.length)
            {
                j = 0;
            }
            //toturiumswünsche durchlaufen
            for ( ;j <studentAvailabilities[a].length;j++) {

                //ist diesem Tutorium gewollt
                if (studentAvailabilities[a][j]){
                    //ist freie Plätze noch!
                    if (tutorialCapacities[j]>0)
                    {
                        result[a] = j;
                        tutorialCapacities[j]--;
                        j=0;
                        break;
                    }
                    else {
                        //alle Tutorien duchgelaufen und keiner passt!
                        if (j==tutorialCapacities.length-1) {
                        result[a] = -1;
                        // keine vorherige Studierende
                        if(a ==0) return null;
                            tutorialCapacities[result[a]]++; // wird ein Student wieder ausgetragen muss die Tutoriumskapazität wieder erhöht werden
                        result[a-1]=-1;
                        // Dem vorherigen Studenten wird "kein Tutorium" zugeordnet
                        }
                    }
                }
            }
        }

        return result;
    }


}
/**
 * Aufgabe 2:
 *  Dieser Test hat direkt bei uns funktioniert, wir gehen allerdings davon aus, dass es ein Problem geben
 *  könnte, da die Kapazität des Arrays vollkommen ausgelastet wird.
 *
 *  Aufgabe 3:
 *  Das Worst-Case Szenario wäre, dass jeder beginnend mit dem letzten Studenten, für alle Studenten
 *  backtracking nötig ist um eine korrekte Verteilung zu finden. Die Komplextiät in diesem Fall wäre N*(N-1)*N(
 *
 *  Aufgabe 4: z.b. für n =15
 *  liegt daran das backword vergrößert das Array nur ein mal
 *  aber forward vergrößert das Array 4 mals also mehr Aufwand
 */