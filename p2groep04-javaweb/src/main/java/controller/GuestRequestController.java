/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Presentation;
import model.repositories.GuestRequestRepository;
import model.repositories.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Logan
 */
public class GuestRequestController {
    
    @Autowired
    private GuestRequestRepository guestRequestRepository;
    
    @Autowired
    private PresentationRepository presentationRepository;
    
    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String ListGuestRequests(int id) {
        
        Presentation presentation = presentationRepository.findById(id);
        if(presentation == null)
            throw new IllegalArgumentException();
         
        return "guestRequestForm";
    }
}
