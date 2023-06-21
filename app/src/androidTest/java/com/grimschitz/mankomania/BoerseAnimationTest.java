package com.grimschitz.mankomania;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.grimschitz.mankomania.Boerse.BoerseAnimation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(AndroidJUnit4.class)
public class BoerseAnimationTest {

    @Rule
    public ActivityScenarioRule<BoerseAnimation> activityScenarioRule = new ActivityScenarioRule<>(BoerseAnimation.class);


    @Test
    public void testRotatePointer() {
        // Aktivitätsszenario erstellen
        ActivityScenario<BoerseAnimation> activityScenario = activityScenarioRule.getScenario();

        // UI-bezogene Operationen auf dem Hauptthread durchführen
        activityScenario.onActivity(activity -> {
            // Testlogik hier ausführen
            BoerseAnimation boerseAnimation = new BoerseAnimation();
            int rand = 0;
            activity.rotatePointer(rand);

            // Überprüfen, ob der Winkel des Bildes korrekt berechnet wurde
            float expectedRotation = rand * 113;
            float actualRotation = activity.pointerImageView.getRotation();
            assertEquals(expectedRotation, actualRotation, 0.01); // Toleranz von 0.01

        });
    }


}
