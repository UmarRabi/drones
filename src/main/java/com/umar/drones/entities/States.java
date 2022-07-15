/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author the Rabbi
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="states")
@Proxy(lazy = false)
public class States extends BaseEntity {
    
    @Column(nullable=false, unique=true)
    private String name;
    
        
    @Column(nullable=false, unique=true)
    private String code;
    
}
