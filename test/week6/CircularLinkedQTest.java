package week6;

import week6_Queue.CircularLinkedQ;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Jeremy Santorelli
 */
public class CircularLinkedQTest {
    
    public CircularLinkedQTest() {
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
     * Test of enqueue method, of class CircularLinkedQ.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object element = null;
        CircularLinkedQ instance = new CircularLinkedQ();
        instance.enqueue(element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class CircularLinkedQ.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        CircularLinkedQ instance = new CircularLinkedQ();
        Object expResult = null;
        Object result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class CircularLinkedQ.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        CircularLinkedQ instance = new CircularLinkedQ();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CircularLinkedQ.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CircularLinkedQ instance = new CircularLinkedQ();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
