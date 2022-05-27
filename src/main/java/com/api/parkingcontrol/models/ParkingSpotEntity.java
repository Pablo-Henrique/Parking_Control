package com.api.parkingcontrol.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 8713569715332608930L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "PARKING_SPOT_NUMBER", nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "RESPONSIBLE_NAME", nullable = false, length = 130)
    private String responsibleName;

    @Column(name = "APARTMENT", nullable = false, length = 30)
    private String apartment;

    @Column(name = "BLOCK", nullable = false, length = 30)
    private String block;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "parkingSpot")
    @JsonProperty(value = "carEntity")
    private CarEntity carEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParkingSpotEntity that = (ParkingSpotEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
