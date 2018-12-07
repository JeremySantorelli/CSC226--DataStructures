/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerem
 */
public class IntegerArrayUtilityTest {
    
    public IntegerArrayUtilityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findTwoSmallest method, of class IntegerArrayUtility.
     */
    @Test
    public void testFindTwoSmallest() {
        System.out.println("findTwoSmallest");
        int[] a = null;
        Pair expResult = null;
        Pair result = IntegerArrayUtility.findTwoSmallest(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfMatchingInts method, of class IntegerArrayUtility.
     */
    @Test
    public void testGetListOfMatchingInts() {
        System.out.println("getListOfMatchingInts");
        int[] a = null;
        int[] b = null;
        List<Integer> expResult = null;
        List<Integer> result = IntegerArrayUtility.getListOfMatchingInts(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfMatchingIntsEC method, of class IntegerArrayUtility.
     */
    @Test
    public void testGetListOfMatchingIntsEC() {
        System.out.println("getListOfMatchingIntsEC");
        int[] a = null;
        int[] b = null;
        List<Integer> expResult = null;
        List<Integer> result = IntegerArrayUtility.getListOfMatchingIntsEC(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIdentical method, of class IntegerArrayUtility.
     */
    @Test
    public void testCheckIdentical() {
        System.out.println("checkIdentical");
        int[] a = null;
        int[] b = null;
        boolean expResult = false;
        boolean result = IntegerArrayUtility.checkIdentical(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFirstAddendPair method, of class IntegerArrayUtility.
     */
    @Test
    public void testFindFirstAddendPair() {
        System.out.println("findFirstAddendPair");
        int[] a = null;
        int sum = 0;
        Pair expResult = null;
        Pair result = IntegerArrayUtility.findFirstAddendPair(a, sum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllAddendPairsEC method, of class IntegerArrayUtility.
     */
    @Test
    public void testFindAllAddendPairsEC() {
        System.out.println("findAllAddendPairsEC");
        int[] a = null;
        int sum = 0;
        List<Pair> expResult = null;
        List<Pair> result = IntegerArrayUtility.findAllAddendPairsEC(a, sum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllAddendPairsAnotherEC method, of class IntegerArrayUtility.
     */
    @Test
    public void testFindAllAddendPairsAnotherEC() {
        System.out.println("findAllAddendPairsAnotherEC");
        int[] a = null;
        int sum = 0;
        List<Pair> expResult = null;
        List<Pair> result = IntegerArrayUtility.findAllAddendPairsAnotherEC(a, sum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of placeArrayPartAtEndFrom method, of class IntegerArrayUtility.
     */
    @Test
    public void testPlaceArrayPartAtEndFrom() {
        System.out.println("placeArrayPartAtEndFrom");
        int[] a = null;
        int k = 0;
        int[] expResult = null;
        int[] result = IntegerArrayUtility.placeArrayPartAtEndFrom(a, k);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstNumberOfSmallestChange method, of class IntegerArrayUtility.
     */
    @Test
    public void testGetFirstNumberOfSmallestChange() {
        System.out.println("getFirstNumberOfSmallestChange");
        int[] a = null;
        int expResult = 0;
        int result = IntegerArrayUtility.getFirstNumberOfSmallestChange(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
