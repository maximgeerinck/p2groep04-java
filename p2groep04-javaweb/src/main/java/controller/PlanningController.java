/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Planning;
import entity.Presentation;
import model.PlanningRepository;
import model.PlanningViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Maxim
 */
@Controller
public class PlanningController 
{
    
    @Autowired
    private PlanningRepository planningRepository;
    
    @RequestMapping( value = "/planning/test", method = RequestMethod.GET)
    public String index(Model model) 
    {
        return "planning/viewPlanning";
    }
    
    @RequestMapping(value = {"/planning/view/*"}, method = RequestMethod.GET)
    public String showPlanning(int id) 
    {
        return "planning/viewPlanning";
    }
    
    @RequestMapping(value = "/planning/get", method = RequestMethod.GET)
    public @ResponseBody PlanningViewModel getPlanningJson()
    {
        
        //get planning        
        Planning planning = planningRepository.findOne(1L);
        
        PlanningViewModel vm = new PlanningViewModel();
        vm.setId(planning.getId());
        vm.setPresentations((Presentation[]) planning.getPresentations().toArray());
        
        return vm;
    }
}
