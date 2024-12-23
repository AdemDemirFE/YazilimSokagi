package com.yazilimsokagi.YazilimSokagiBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private String username;
    private String password;
    private String active;
    private String roles;

}
