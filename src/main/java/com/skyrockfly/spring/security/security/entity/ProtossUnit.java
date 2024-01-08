package com.skyrockfly.spring.security.security.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class ProtossUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(nullable = false, name = "type")
    private String type;

    @Column(nullable = false, name="user_id")
    private int userId;

    @ElementCollection
    @CollectionTable(name = "upgrades",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "upgrade_type")
    @Column(name = "upgrade_level")
    private Map<String, @Min(value = 0) @Max(value = 3) Integer> upgrades;


}
