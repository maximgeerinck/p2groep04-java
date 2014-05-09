package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Presentation implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "editable")
    private transient boolean editable;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "presentation_attendees",
            joinColumns = {@JoinColumn(name = "presentation_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Student> attendees = new HashSet<>();
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @OneToMany(mappedBy = "presentation", targetEntity = GuestRequest.class, fetch = FetchType.EAGER)
    private Set<GuestRequest> guestRequests;
    
    @OneToOne
    @JoinColumn(name = "timeframe_id", referencedColumnName = "id")
    private TimeFrame timeFrame;
    
    @ManyToOne
    @JoinColumn(name = "planning_id", referencedColumnName = "id")
    private Planning planning;

    @OneToOne(optional = false)
    @JoinColumn(name = "presentator_id", referencedColumnName = "id")
    private Student presentator;

    @OneToOne
    @JoinColumn(name = "promotor_id", referencedColumnName = "id")
    private Promotor promotor;
    
    @OneToOne
    @JoinColumn(name = "copromotor_id", referencedColumnName = "id")
    private Promotor coPromotor;
    
    //@ManyToMany(mappedBy = "researchDomains")
    //private List<Presentation> presentations;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public boolean isEditable() {
        return this.editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Student> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<Student> attendees) {
        this.attendees = attendees;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Set<GuestRequest> getGuestRequests() {
        return guestRequests;
    }

    public void setGuestRequests(Set<GuestRequest> guestRequests) {
        this.guestRequests = guestRequests;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Student getPresentator() {
        return presentator;
    }

    public void setPresentator(Student presentator) {
        this.presentator = presentator;
    }

    public Presentation() {
    }

    /**
     *
     * @param location
     */
    public Presentation(Location location) {
        setLocation(location);
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public Promotor getCoPromotor() {
        return coPromotor;
    }

    public void setCoPromotor(Promotor coPromotor) {
        this.coPromotor = coPromotor;
    }    
    
    /**
     *
     * @param timeFrame
     * @param location
     */
    public Presentation(TimeFrame timeFrame, Location location) {
        setTimeFrame(timeFrame);
        setLocation(location);
    }
    public void notifyStakeHolders(Planning planning){
       
         List<Presentation> presentations = new ArrayList<>();
         List<User> users = new ArrayList<>();
         
         presentations.addAll(planning.getPresentations());
         
         for(Presentation p: presentations)
         {
            
            users.add(p.getPresentator());
            users.addAll(p.getAttendees()); 
            
         }
         
         for(User u: users)
         {
            // u.sendMail();
         }
         
             
     }

}