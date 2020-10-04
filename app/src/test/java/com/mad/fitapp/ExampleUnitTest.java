package com.mad.fitapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    private GoalOverview goaloverview;

    //IT19139036 A.S.V JAYADEVA
    @Before
    public void setUp(){

        goaloverview = new GoalOverview();
    }

    @Test
    public void check_step_progress_Correct() {
        int result = goaloverview.calculateStepProgress(200,150);
        assertEquals(50,result);
    }

    @Test
    public void check_heart_points_progress_Correct(){
        int result = goaloverview.calculateHeartPointsProgress(15,10);
        assertEquals(5,result);
    }

    //IT19118864 L.C.R.Karunathunge
    @Test
    public void checkStepProgressCorrect() {
        int result = goaloverview.calculateStepProgress(150,125);
        assertEquals(25,result);
    }

    @Test
    public void checkHeartPointsProgressCorrect(){
        int result = goaloverview.calculateHeartPointsProgress(75,45);
        assertEquals(30,result);
    }


}