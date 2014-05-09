/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Student")
public class Student extends User
{ 
    @OneToOne
    @JoinColumn(name = "presentation_id", referencedColumnName = "id")
    private Presentation presentation;
    
    @OneToMany(mappedBy = "student", targetEntity = Suggestion.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Suggestion> suggestions = new HashSet<>();
    
    @OneToMany(mappedBy = "student", targetEntity = GuestRequest.class, fetch = FetchType.EAGER)
    private Set<GuestRequest> guestRequests;
    
    @ManyToMany(mappedBy="students", cascade=CascadeType.ALL)
    private Set<Promotor> promotors;
    
    @ManyToMany(mappedBy = "attendees")
    private Set<Presentation> presentationsAttending;    

    public Set<Promotor> getPromotors() {
        return this.promotors;
    }

    public void setPromotors(Set<Promotor> promotors) {
        this.promotors = promotors;
    }

    public Set<GuestRequest> getGuestRequests() {
        return guestRequests;
    }

    public void setGuestRequests(Set<GuestRequest> guestRequests) {
        this.guestRequests = guestRequests;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Set<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Set<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }
    
    
    public Suggestion getActiveSuggestion() 
    {
        for(Suggestion s : suggestions) {
            if(s.isActive()) {
                return s;
            }
        }
        return null;
    }
    
    public Student() {
    }
}