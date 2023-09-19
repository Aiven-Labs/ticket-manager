package org.sebi;

import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Ticket extends PanacheEntity {

    public String title;
    public String description;
    public String author;
    public Date timestamp;
    
}
