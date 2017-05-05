package com.gloic.freebird.persistence.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author gloic
 */
@Entity
@Data
public class UnknownMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean ignored;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Link link;
}
