package com.example.SpringDataSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "`order`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private int id;
    @Column(name = "ORD_PRICE")
    private double price;
    @Column(name = "ORD_TITLE")
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_PU_ID", referencedColumnName = "PU_ID")
    private PortalUser portalUser;

}
