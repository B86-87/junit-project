package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;

public class Day02_Assertions {

    @Test
    public void assertions(){
       /*
       * Assertion is done to check if expected equals to action
       * green checkmark-> PASS
       * yellow x -> fail
       *
       * Assert.assertFalse(false);//PASS
       * Assert.assertFalse(true);//Fail
       *
       * Assert.assertTrue(true);//Pass
       * Assert.assertTrue(false);//Fail
       *
       * */

//        Assert.assertEquals(4,5);
//        If test case fails, then test execution stops
        Assert.assertEquals(5,5);
        Assert.assertEquals("apple","apple");
        Assert.assertEquals(false,false);

//        Assert.assertTrue("Apple".equals("apple"));
        if ("Apple".equals("apple")){
//            VERIFICATION: if the statement fails, test case will continue to execute
        }

        Assert.assertFalse("Apple".equals("apple"));//PASS

        Assert.assertTrue("apple".equals("apple"));//Pass
    }
}
