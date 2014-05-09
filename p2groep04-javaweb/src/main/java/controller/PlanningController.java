/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Planning;
import entity.Presentation;
import entity.ResearchDomain;
import java.util.List;
import model.repositories.PlanningRepository;
import model.repositories.PresentationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maxim
 */
@Controller
public class PlanningController {

    @Autowired
    private PlanningRepository planningRepository;

    @Autowired
    private PresentationRepository presentationRepository;
     
    @RequestMapping(value = {"/planning/view"}, method = RequestMethod.GET)
    public String showPlanning() {
        return "view.planning.viewPlanning";
    }

    @RequestMapping(value = "/planning/get", method = RequestMethod.GET)
    public @ResponseBody
    String getPlanningJson() throws JSONException {

        //get planning        
        Planning planning = planningRepository.findOneById(1L);

        JSONArray pArray = new JSONArray();
        JSONArray rArray = new JSONArray();
        JSONObject planningJSON = new JSONObject();

        planningJSON.put("id", planning.getId());
        planningJSON.put("starttime", planning.getStartTime());
        planningJSON.put("endtime", planning.getEndTime());

        //List<Presentation> presentations = (List<Presentation>)presentationRepository.findByPlanning(planning);
        
        for (Presentation p : planning.getPresentations()) {

            JSONObject presentationJSON = new JSONObject();
            presentationJSON.put("id", p.getId());
            presentationJSON.put("date", p.getDate());
            presentationJSON.put("copromotor", p.getCoPromotor());
            presentationJSON.put("location", p.getLocation());
            presentationJSON.put("promotor", p.getPromotor());
            presentationJSON.put("presentator", p.getPresentator());
            
            for(ResearchDomain r : p.getPresentator().getActiveSuggestion().getResearchDomains())
            {
                JSONObject rJSON = new JSONObject();
                rJSON.put("id", r.getId());
                rJSON.put("name", r.getName());
                rArray.put(rJSON);
            }            
            presentationJSON.put("researchDomains", rArray);
            
            presentationJSON.put("subject", p.getPresentator().getActiveSuggestion().getSubject());
            presentationJSON.put("capacity", p.getLocation().getCapacity());
            presentationJSON.put("subscribers", p.getGuestRequests().size());

            // timeframe array
            JSONObject timeframeJSON = new JSONObject();
            timeframeJSON.put("starttime", p.getTimeFrame().getStartTime());
            timeframeJSON.put("endtime", p.getTimeFrame().getEndTime());
            presentationJSON.put("timeframe", timeframeJSON);

            pArray.put(presentationJSON);
          
        }
        
        planningJSON.put("presentations", pArray);
        return planningJSON.toString();
    }
}
