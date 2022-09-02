package com.posttestmysql.testmysql.entity.dto.custom;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BarangUpdateCustomDTO {
    private String nama_Barang;
    private Double harga;
    private Integer stok;
}
