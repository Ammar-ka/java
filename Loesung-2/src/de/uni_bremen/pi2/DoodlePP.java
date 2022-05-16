package de.uni_bremen.pi2;

import java.util.Arrays;

public class DoodlePP
{
    /**
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
    public static int[] distribute(final boolean[][] studentAvailabilities, final int[] tutorialCapacities)
    {
        return null;
    }

    public static void main(String[] args) {

    }
}