/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Samsung
 */
public class SignUpController {
    
    @Autowired
    private SignUpRepository signUpRepository;
}
