package com.thanhdatpb.library.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private String name;

    @Getter
    @Setter
    @ManyToMany( mappedBy = "roles" )
    private Collection<Admin> admins;

}
