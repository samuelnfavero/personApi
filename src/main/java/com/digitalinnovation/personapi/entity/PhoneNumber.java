package com.digitalinnovation.personapi.entity;

import com.digitalinnovation.personapi.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
