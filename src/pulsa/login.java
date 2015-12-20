/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pulsa;

import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class login {
    public void ceklogin(String user, String pass)
    {
    
            if (user.equals("ami") && pass.equals("aminahfauziah"))
            {
                
                FrmMenu mu = new FrmMenu();
                mu.setVisible(true);
                Frmlogin fl = new Frmlogin();
                fl.setVisible(false);
               
            }
            else{
                System.out.println("enter the valid username and password");
              }
}
}
