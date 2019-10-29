/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uema.wifivouchers.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lccf
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Voucher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dt_registration;
    private Date dt_expiration;
    //@ManyToOne
    private Long user_id;
    //@ManyToOne
    private Long events_id;
    //@ManyToOne
    private Long user_registrant_id;
    
}
