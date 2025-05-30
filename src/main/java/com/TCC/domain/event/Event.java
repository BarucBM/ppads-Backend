package com.TCC.domain.event;



import com.TCC.domain.company.Company;
import com.TCC.domain.user.UserEvent;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Boolean freeEntry;

    private BigDecimal ticketUnitPrice;

    private BigDecimal ticketTax;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    private Company company;

    @JsonBackReference
    @OneToMany(mappedBy = "event")
    private List<UserEvent> usersEvents;

//    @OneToMany(mappedBy = "event")
//    private List<Notification> notifications;
}
