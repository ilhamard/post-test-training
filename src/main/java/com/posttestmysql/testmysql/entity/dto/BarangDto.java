package com.posttestmysql.testmysql.entity.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangDto {

    private Integer id_Barang;
    private String nama_Barang;
    private double harga;
    private Integer stok;
}
