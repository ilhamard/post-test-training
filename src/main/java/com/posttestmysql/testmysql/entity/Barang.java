package com.posttestmysql.testmysql.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name ="barang")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_barang;

    @Column(length = 100)
    private String nama_Barang;

    @Column(length = 30)
    private double harga;

    private int stok;

}
