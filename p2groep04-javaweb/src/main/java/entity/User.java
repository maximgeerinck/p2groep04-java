package entity;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;


/*import javax.mail.internet.InternetAddress; 
 import javax.mail.internet.MimeMessage;
 import javax.mail.*;*/
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Maxim
 */
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @Column(name = "email")
    protected String email;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "username")
    protected String username;

    @Column(name = "password")
    protected String password;

    @Column(name = "salt")
    protected String salt;

    @Column(name = "last_login")
    protected java.sql.Timestamp lastLogin;

    @Column(name = "last_ip")
    protected String lastIp;

    @Column(name = "created_on")
    protected java.sql.Timestamp createdOn;

    @Column(name = "updated_on")
    protected java.sql.Timestamp updatedOn;

    @Column(name = "enabled")
    protected int enabled;

    @OneToMany
    @JoinColumn(name = "bpcoordinator_id", referencedColumnName = "id")
    protected List<Planning> plannings;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public java.sql.Timestamp getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(java.sql.Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastIp() {
        return this.lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public java.sql.Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(java.sql.Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public java.sql.Timestamp getUpdatedOn() {
        return this.updatedOn;
    }

    public void setUpdatedOn(java.sql.Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<Planning> getPlannings() {
        return this.plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    public User() {
    }

    @PrePersist()
    public void onCreate() {

    }

    @Override()
    public String toString() {
        return this.lastName + " " + this.firstName;
    }

    /*public void sendMail() {

     Properties props = new Properties();  
     props.put("mail.smtp.host", "smtp.gmail.com");  
     props.put("mail.smtp.auth", "true");  
     props.put("mail.debug", "true");  
     props.put("mail.smtp.port", 25);  
     props.put("mail.smtp.socketFactory.port", 25);  
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.transport.protocol", "smtp");
     Session mailSession = null;
        
     mailSession = Session.getInstance(props);
        
     try {

     Transport transport = mailSession.getTransport();

     MimeMessage message = new MimeMessage(mailSession);

     message.setSubject("Changes planning bachelorproef");
     message.setFrom(new InternetAddress("p2groep04@gmail.com"));
     String to = this.email;
     message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
     String body = "The planning for the bachelorproef has been changed, please check the planning for more information.";
     message.setContent(body,"text/html");
     transport.connect();

     transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
            
     transport.close();
            
     } catch (Exception exception) {
     exception.printStackTrace();
     }
        
        
     }*/
}
