/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Student")
public class Student extends User
{ 
    @OneToOne
    @JoinColumn(name = "presentation_id", referencedColumnName = "id")
    private Presentation presentation;
    
    @OneToMany(mappedBy = "student", targetEntity = Suggestion.class)
    private List<Suggestion> suggestions;
    
    @OneToOne
    @JoinColumn(name = "suggestion_id", referencedColumnName = "id")
    private Suggestion approvedSuggestion;
    
    @OneToMany(mappedBy = "student", targetEntity = GuestRequest.class)
    private List<GuestRequest> guestRequests;
    
    @ManyToMany(mappedBy="students", cascade=CascadeType.PERSIST)
    private List<Promotor> promotors;
    
    @ManyToMany
    private List<Presentation> presentationsAttending;

    public List<Promotor> getPromotors() {
        return this.promotors;
    }

    public void setPromotors(List<Promotor> promotors) {
        this.promotors = promotors;
    }

    public List<GuestRequest> getGuestRequests() {
        return guestRequests;
    }

    public void setGuestRequests(List<GuestRequest> guestRequests) {
        this.guestRequests = guestRequests;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public Suggestion getApprovedSuggestion() {
        return approvedSuggestion;
    }

    public void setApprovedSuggestion(Suggestion approvedSuggestion) {
        this.approvedSuggestion = approvedSuggestion;
    }    

    public Student() {
    }
}
