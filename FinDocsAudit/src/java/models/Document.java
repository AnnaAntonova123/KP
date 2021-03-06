package models;
// Generated 24.02.2017 15:13:28 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Document generated by hbm2java
 */
public class Document  implements java.io.Serializable {


     private Integer id;
     private Initiator initiator;
     private Performer performer;
     private Status status;
     private Type type;
     private String inputNumber;
     private Date regDate;
     private String name;
     private Date deadline;
     private String file;
     private String description;

    public Document() {
    }

	
    public Document(Initiator initiator, Performer performer, Status status, Type type, String inputNumber, Date regDate, String name, Date deadline) {
        this.initiator = initiator;
        this.performer = performer;
        this.status = status;
        this.type = type;
        this.inputNumber = inputNumber;
        this.regDate = regDate;
        this.name = name;
        this.deadline = deadline;
    }
    public Document(Initiator initiator, Performer performer, Status status, Type type, String inputNumber, Date regDate, String name, Date deadline, String file, String description) {
       this.initiator = initiator;
       this.performer = performer;
       this.status = status;
       this.type = type;
       this.inputNumber = inputNumber;
       this.regDate = regDate;
       this.name = name;
       this.deadline = deadline;
       this.file = file;
       this.description = description;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Initiator getInitiator() {
        return this.initiator;
    }
    
    public void setInitiator(Initiator initiator) {
        this.initiator = initiator;
    }
    public Performer getPerformer() {
        return this.performer;
    }
    
    public void setPerformer(Performer performer) {
        this.performer = performer;
    }
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    public Type getType() {
        return this.type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    public String getInputNumber() {
        return this.inputNumber;
    }
    
    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }
    public Date getRegDate() {
        return this.regDate;
    }
    
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Date getDeadline() {
        return this.deadline;
    }
    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public String getFile() {
        return this.file;
    }
    
    public void setFile(String file) {
        this.file = file;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


