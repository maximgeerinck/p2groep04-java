/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Planning;
import entity.Presentation;
import model.repositories.PlanningRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maxim
 */
@Controller
public class PlanningController 
{
    
    @Autowired
    private PlanningRepository planningRepository;
    
    @RequestMapping(value = {"/planning/view"}, method = RequestMethod.GET)
    public String showPlanning() 
    {
        return "view.planning.viewPlanning";
    }
    
    @RequestMapping(value = "/planning/get", method = RequestMethod.GET)
    public @ResponseBody String getPlanningJson() throws JSONException
    {
        
        //get planning        
        Planning planning = planningRepository.findOne(1L);        
         
        JSONArray pArray = new JSONArray();
        JSONObject planningJSON = new JSONObject();
        
        
        planningJSON.put("id", planning.getId());
        planningJSON.put("starttime", planning.getStartTime());
        planningJSON.put("endtime", planning.getEndTime());
        
        for(Presentation p : planning.getPresentations()) 
        {
            JSONObject presentationJSON = new JSONObject();
            presentationJSON.put("id", p.getId());
            presentationJSON.put("date", p.getDate());
            presentationJSON.put("copromotor", p.getCoPromotor());
            presentationJSON.put("location", p.getLocation());
            presentationJSON.put("promotor", p.getPromotor());
            presentationJSON.put("presentator", p.getPresentator());   
            presentationJSON.put("subject", "Nog in te vullen");
            
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
