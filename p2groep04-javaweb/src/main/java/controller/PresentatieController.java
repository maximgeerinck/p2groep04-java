/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.GuestRequest;
import entity.Presentation;
import entity.Student;
import entity.TimeFrame;
import entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import model.repositories.GuestRequestRepository;
import model.repositories.PresentationRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maxim
 */
@Controller
public class PresentatieController 
{
    
    @Autowired
    private PresentationRepository presentationRepository;
    
    @Autowired
    private GuestRequestRepository guestRequestRepository;
    
    @RequestMapping(value = {"/presentatie/inschrijven"}, method = RequestMethod.POST)
    public @ResponseBody String register(@RequestBody Long id) throws JSONException 
    {
        System.out.println(id);
        
        JSONObject output = new JSONObject();
        output.put("success", false);
        
        Presentation p = presentationRepository.findOne(id);
        if(p == null) {
            output.put("message", "Kan de presentatie niet vinden.");
            return output.toString();
        }
                        
        //check for free spots
        if(p.getAttendees().size() == p.getLocation().getCapacity()) {
            output.put("message", "Er is geen plaats meer vrij");
            return output.toString();
        }
        
        //check if user is already attending presentation at this timeframe
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)auth.getPrincipal();
        
        if(!(user instanceof Student)) {
            output.put("message", "Enkel studenten kunnen zich inschrijven voor een presentatie");
            return output.toString();
        }
        
        Student student = (Student)user;
        HashMap<Date, List<TimeFrame>> timeframes = new HashMap<>();
        
        for(GuestRequest gr : student.getGuestRequests()) 
        {
            Presentation pr = gr.getPresentation();
            if(!timeframes.containsKey(pr.getDate())) {
                timeframes.put(pr.getDate(), new ArrayList<TimeFrame>());  
                timeframes.get(pr.getDate()).add(pr.getTimeFrame());
            }
            
            if(!timeframes.get(pr.getDate()).contains(pr.getTimeFrame())) {
                timeframes.get(pr.getDate()).add(pr.getTimeFrame());
            } else {
                output.put("message", "U heeft zich al ingeschreven voor een presentatie op hetzelfde tijdstip");
                return output.toString();
            }
        }
        
        GuestRequest n = new GuestRequest();
        n.setPresentation(p);
        n.setStudent(student);
        student.getGuestRequests().add(n);
        
        //p.getAttendees().add(student);        
        //presentationRepository.flush();
        
        guestRequestRepository.saveAndFlush(n);        
        
        output.put("success", true);
        return output.toString();
    }
}
