/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Presentation;

/**
 *
 * @author Maxim
 */
public class PlanningViewModel 
{
    private int id;
    
    private Presentation[] presentations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Presentation[] getPresentations() {
        return presentations;
    }

    public void setPresentations(Presentation[] presentations) {
        this.presentations = presentations;
    }
    
    
}
