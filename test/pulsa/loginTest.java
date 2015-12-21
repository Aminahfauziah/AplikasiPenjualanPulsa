    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pulsa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer
 */
public class loginTest {
    
    public loginTest() {
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
     * Test of ceklogin method, of class login.
     */
    @Test
    public void testCeklogin() {
        System.out.println("ceklogin");
        String user = "ami";
        String pass = "aminahfauziah";
        login instance = new login();
        instance.ceklogin(user, pass);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
