/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.GuestRequest;
import entity.Presentation;
import entity.Student;
import java.util.List;
import model.repositories.GuestRequestRepository;
import model.repositories.PresentationRepository2;
import model.repositories.UserRepository;
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
    
    private PresentationRepository2 presentationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String addGuestRequest(int id) {
        
        Presentation presentation = presentationRepository.findById(id);
        List<GuestRequest> guestRequests = presentation.getGuestRequests();
        String username = System.getProperty("user.name");
        if(presentation == null)
            throw new IllegalArgumentException();
        
        if(presentation.getLocation().getCapacity() == guestRequests.size()){
            return "completeMessage";
        }
        else{
            if(guestRequests.contains(guestRequestRepository.findbyUsernameAndPresentationId(username,id)))
                return "doubleReservationMessage";
            else{
                GuestRequest request = new GuestRequest();
                request.setStudent((Student)userRepository.findOneByUsername(username));
                request.setPresentation(presentation);
                request.setApproved(true);
                guestRequests.add(request);
                guestRequestRepository.save(request);
                return "listGuestRequests";
            }
        } 
            
    }
    
    
}
