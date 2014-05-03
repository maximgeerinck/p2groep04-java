/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.GuestRequestRepository;
import model.PresentationRepository;
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
    private PresentationRepository presentationRepository;
    
    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String showGuestRequest(int id) {
        if( guestRequestRepository.findAllByPresentation(presentationRepository.findById(id)).size() == presentationRepository.findById(id).getLocation().getCapacity())
            return "completeMessage";
        else
            return "guestRequestForm";
    }
}
