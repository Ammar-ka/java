package de.uni_bremen.pi2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DoodlePPTest
{
    /**
     * Testet das Verteilen von 50 Studierenden auf 5 Tutorien der Kapazität 10.
     */
    @Test
    public void test5TutorialsOf10()
    {
        final boolean[][] studentAvailabilities = {
                {false, true, true, true, true},
                {true, true, true, false, true},
                {false, true, true, true, true},
                {true, true, true, false, true},
                {true, true, true, true, true},
                {false, true, true, false, true},
                {false, false, false, false, true},
                {false, true, false, true, false},
                {true, true, true, true, false},
                {false, false, false, false, true},
                {false, false, false, true, true},
                {true, true, false, false, true},
                {true, true, true, true, true},
                {false, true, true, true, false},
                {false, true, true, false, true},
                {true, true, false, true, false},
                {true, true, true, true, true},
                {false, true, false, false, true},
                {false, false, true, true, true},
                {false, true, true, true, false},
                {true, false, true, true, true},
                {true, false, true, false, true},
                {true, false, true, true, true},
                {true, false, false, true, false},
                {true, true, true, false, false},
                {false, true, true, false, true},
                {false, true, true, false, false},
                {true, true, true, true, true},
                {true, false, true, true, true},
                {false, true, false, true, false},
                {true, false, true, true, false},
                {true, false, true, true, true},
                {false, true, false, true, false},
                {false, false, true, true, true},
                {false, true, false, true, true},
                {false, true, true, false, true},
                {false, true, true, true, true},
                {true, true, true, true, true},
                {true, true, false, true, true},
                {true, true, true, true, true},
                {true, false, false, true, true},
                {true, true, false, true, false},
                {false, true, true, true, false},
                {true, false, true, true, true},
                {true, true, true, false, true},
                {false, true, false, true, false},
                {false, true, false, true, true},
                {false, true, true, false, false},
                {true, true, false, true, false},
                {true, true, false, false, true},
            };

        final int[] tutorialCapacities = {10, 10, 10, 10, 10};
        final int[] tutorialCapacitiesLeft = tutorialCapacities.clone();

        final int[] tutorialOfStudents = DoodlePP.distribute(clone(studentAvailabilities), tutorialCapacitiesLeft);

        checkDistribution(studentAvailabilities, tutorialCapacities, tutorialCapacitiesLeft, tutorialOfStudents);
    }

    /**
     * Testet das Verteilen von 70 Studierenden auf 7 Tutorien der Kapazität 10.
     */
    @Test
    public void test7TutorialsOf10()
    {
        final boolean[][] studentAvailabilities = {
                {true, true, true, true, true, true, false},
                {true, true, true, false, false, true, true},
                {false, true, false, false, false, false, false},
                {false, true, false, false, true, true, false},
                {false, false, false, false, true, true, true},
                {false, true, false, false, false, false, false},
                {true, true, false, true, false, false, false},
                {true, true, true, false, true, false, false},
                {false, false, false, false, false, true, false},
                {true, true, false, false, false, false, false},
                {true, false, false, false, false, true, true},
                {false, true, false, false, true, true, true},
                {false, true, false, true, false, false, true},
                {true, false, false, true, true, false, true},
                {false, false, true, false, false, false, false},
                {true, true, true, true, true, true, true},
                {true, false, false, false, true, true, true},
                {false, false, true, false, false, false, false},
                {false, true, false, true, true, false, false},
                {false, false, true, false, true, false, false},
                {false, false, false, false, false, true, true},
                {true, true, true, true, true, true, false},
                {true, false, false, false, false, false, false},
                {false, false, false, true, false, true, true},
                {true, false, true, true, false, false, false},
                {false, false, false, true, true, true, false},
                {true, true, false, true, false, true, false},
                {true, false, true, true, false, true, true},
                {true, false, false, false, true, false, true},
                {true, true, true, false, true, false, false},
                {true, true, true, false, false, false, true},
                {true, false, false, false, true, false, false},
                {true, true, true, false, true, false, false},
                {true, false, false, true, false, true, true},
                {true, true, false, false, true, false, true},
                {false, false, false, true, false, false, true},
                {false, false, true, false, false, false, true},
                {true, false, true, false, false, true, true},
                {false, false, true, false, false, true, false},
                {true, false, false, false, false, true, false},
                {true, true, true, true, false, true, false},
                {false, false, true, true, false, false, false},
                {true, true, true, false, true, false, true},
                {true, true, true, false, true, true, true},
                {true, false, false, true, false, false, true},
                {false, false, false, true, false, false, true},
                {true, false, false, false, true, false, false},
                {false, false, true, false, false, true, false},
                {false, true, false, false, false, false, false},
                {true, true, true, false, false, true, false},
                {true, true, false, true, false, true, true},
                {false, true, false, false, false, true, true},
                {true, false, false, false, true, true, true},
                {false, false, false, true, true, false, false},
                {true, false, true, false, false, true, false},
                {false, true, false, false, true, false, true},
                {false, false, false, true, false, false, false},
                {false, false, true, false, true, false, false},
                {true, false, true, true, true, false, true},
                {false, false, false, false, false, true, false},
                {true, true, true, false, false, true, false},
                {true, true, true, true, true, true, false},
                {true, false, true, false, true, true, true},
                {true, true, true, true, false, true, true},
                {false, true, true, true, true, false, false},
                {false, true, true, false, true, true, true},
                {false, true, false, false, true, false, true},
                {true, false, false, false, false, true, true},
                {true, false, true, true, false, true, true},
                {true, false, false, true, false, true, false},
            };

        final int[] tutorialCapacities = {10, 10, 10, 10, 10, 10, 10};
        final int[] tutorialCapacitiesLeft = tutorialCapacities.clone();

        final int[] tutorialOfStudents = DoodlePP.distribute(clone(studentAvailabilities), tutorialCapacitiesLeft);

        checkDistribution(studentAvailabilities, tutorialCapacities, tutorialCapacitiesLeft, tutorialOfStudents);
    }


    /**
     * Testet das Verteilen von 100 Studierenden auf 10 Tutorien der Kapazität 10.
     * Dieser Test wird aktuell ignoriert.
     */
    @Disabled @Test
    public void test10TutorialsOf10()
    {
        final boolean[][] studentAvailabilities = {
                {true, true, true, true, false, true, false, false, false, false},
                {true, false, false, true, true, true, true, true, true, true},
                {false, true, false, true, false, true, false, false, true, true},
                {true, true, false, true, true, false, false, true, true, true},
                {false, true, true, false, false, true, true, false, true, true},
                {true, true, true, true, false, true, true, true, true, true},
                {true, false, true, true, false, true, true, true, true, false},
                {true, false, true, false, true, true, false, true, true, true},
                {true, true, true, true, true, true, true, false, false, false},
                {true, true, true, true, true, true, false, false, true, true},
                {true, true, true, false, true, true, true, true, true, true},
                {true, true, false, true, true, true, true, false, true, true},
                {true, true, true, false, true, false, true, false, true, true},
                {false, true, false, false, true, true, false, true, true, true},
                {true, true, true, false, true, true, true, true, true, true},
                {false, true, true, true, true, true, false, true, true, true},
                {true, true, true, false, true, false, false, true, false, false},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, false, true, false, true, false, false, true, true},
                {true, false, true, true, true, false, true, false, true, true},
                {false, true, false, true, true, true, true, false, true, true},
                {true, true, true, true, true, true, false, true, true, true},
                {true, false, false, false, true, false, true, false, false, false},
                {true, false, false, true, true, true, false, false, true, true},
                {true, true, false, true, true, false, false, true, true, true},
                {true, false, true, true, true, true, true, true, true, true},
                {false, true, false, true, false, true, false, false, true, false},
                {true, true, true, true, false, true, true, false, false, false},
                {false, false, true, true, true, true, true, false, true, true},
                {false, true, true, false, true, true, false, true, true, true},
                {true, true, false, false, true, true, true, true, true, false},
                {true, true, true, false, true, true, true, true, true, true},
                {true, true, true, true, false, true, false, true, true, true},
                {true, true, false, false, true, true, false, false, true, true},
                {true, false, true, false, true, true, true, true, true, true},
                {true, true, true, true, false, false, true, true, true, true},
                {true, true, true, true, true, true, false, true, true, true},
                {true, true, false, false, true, false, false, true, true, true},
                {false, false, true, false, true, true, true, false, false, true},
                {true, true, false, true, true, true, true, true, true, true},
                {true, false, true, true, false, false, true, false, false, true},
                {false, true, false, false, true, true, false, true, false, true},
                {true, true, true, true, true, true, false, true, true, true},
                {false, true, true, true, true, false, true, false, true, true},
                {true, true, true, false, false, false, false, false, false, false},
                {true, true, true, false, false, true, false, false, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {false, false, true, false, false, false, false, false, true, false},
                {true, true, true, false, true, true, true, true, true, false},
                {true, true, true, true, false, false, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {false, false, true, false, false, false, true, true, true, false},
                {true, true, true, false, false, false, true, true, true, false},
                {false, true, false, false, false, true, true, true, true, false},
                {true, true, false, true, true, false, false, false, false, true},
                {true, true, true, false, false, true, true, true, true, true},
                {true, true, true, false, false, true, true, false, true, false},
                {false, false, true, true, false, true, true, false, false, true},
                {true, true, true, true, true, true, true, true, true, false},
                {true, false, false, false, true, true, true, false, true, false},
                {true, false, true, false, true, true, false, false, true, true},
                {true, true, true, true, false, false, true, false, false, true},
                {true, true, true, true, true, true, true, false, false, true},
                {true, false, false, false, false, true, false, false, false, true},
                {true, true, false, false, true, true, false, true, false, true},
                {true, false, true, true, true, true, true, true, false, false},
                {true, true, true, false, false, true, false, true, true, true},
                {true, true, false, true, true, false, true, true, true, true},
                {true, true, false, true, true, true, true, true, true, false},
                {false, true, true, true, false, false, false, true, false, true},
                {true, true, false, false, false, true, false, true, true, true},
                {false, false, true, true, true, false, false, true, true, true},
                {false, true, false, true, false, true, false, true, true, false},
                {true, true, false, true, false, true, true, false, false, true},
                {true, true, false, true, true, false, true, true, true, true},
                {true, true, true, false, true, false, false, false, true, false},
                {true, false, false, false, true, false, true, true, true, false},
                {true, true, true, true, false, true, true, true, true, false},
                {true, true, true, false, true, true, true, false, false, true},
                {true, true, false, true, true, false, true, false, false, true},
                {true, false, true, false, true, false, true, true, true, true},
                {true, true, false, true, true, false, false, true, true, true},
                {true, true, true, true, true, true, false, true, true, true},
                {true, true, true, true, false, true, false, true, true, false},
                {true, true, false, true, true, true, true, false, true, false},
                {true, false, true, false, false, false, true, true, true, true},
                {true, true, false, true, true, true, true, true, true, true},
                {false, false, true, true, true, true, true, true, true, true},
                {true, false, false, true, false, true, false, false, false, true},
                {true, true, false, true, true, true, false, true, true, true},
                {false, true, true, true, false, true, true, true, true, false},
                {true, true, true, false, true, false, false, false, true, false},
                {true, true, true, false, true, false, false, false, false, true},
                {false, true, true, false, true, true, false, true, true, true},
                {true, true, true, true, false, true, false, true, true, false},
                {false, false, true, true, true, true, false, true, true, true},
                {false, false, true, true, true, true, false, true, true, false},
                {false, true, true, true, false, true, true, true, true, false},
                {true, true, false, true, false, true, true, true, true, true},
                {true, true, true, true, true, true, false, false, false, false},
            };

        final int[] tutorialCapacities = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        final int[] tutorialCapacitiesLeft = tutorialCapacities.clone();

        final int[] tutorialOfStudents = DoodlePP.distribute(clone(studentAvailabilities), tutorialCapacitiesLeft);

        checkDistribution(studentAvailabilities, tutorialCapacities, tutorialCapacitiesLeft, tutorialOfStudents);
    }

    /**
     * Erzeugt eine Kopie eines zweidimensionalen boolean-Arrays. Die Motivation für diese Methode ist,
     * dass es falsch wäre, dieselbe Instanz der Studierendenverfügbarkeiten an die zu testende Methode
     * zu übergeben, mit der später auch die Korrektheit des Ergebnisses geprüft wird, da die Methode
     * die Daten ändern könnte.
     * @param a Das Array, von dem eine tiefe Kopie erzeugt wird.
     * @return Die Kopie.
     */
    private boolean[][] clone(final boolean[][] a)
    {
        return Arrays.stream(a).map(boolean[]::clone).toArray(boolean[][]::new);
    }

    /**
     * Überprüft die Korrektheit einer Zuordnung.
     * @param studentAvailabilities Die Studierendenverfügbarkeiten, wie in der zu testenden Methode
     *         definiert.
     * @param tutorialCapacities Die ursprünglichen Kapazitäten der Tutorien.
     * @param tutorialCapacitiesLeft Die nach der Verteilung verbliebenen Kapazitäten der Tutorien.
     * @param tutorialOfStudents Zuordnung von Studierenden zu Tutorien.
     */
    private void checkDistribution(final boolean[][] studentAvailabilities, final int[] tutorialCapacities,
                                   final int[] tutorialCapacitiesLeft, final int[] tutorialOfStudents)
    {
        fail("Hier muss etwas implementiert werden!");
    }
}
