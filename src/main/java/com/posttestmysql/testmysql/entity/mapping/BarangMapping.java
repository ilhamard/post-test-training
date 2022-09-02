package com.posttestmysql.testmysql.entity.mapping;


import com.posttestmysql.testmysql.entity.Barang;
import com.posttestmysql.testmysql.entity.dto.BarangDto;
import com.posttestmysql.testmysql.entity.dto.custom.BarangOnlyIdCustomDTO;
import com.posttestmysql.testmysql.entity.dto.custom.BarangUpdateCustomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BarangMapping {

    BarangMapping INSTANCE = Mappers.getMapper(BarangMapping.class);
    Barang toEntity(BarangDto barangDto);
    Barang toUpdateCustomEntity(BarangUpdateCustomDTO data);
    BarangOnlyIdCustomDTO toCustomWithIdDTO(Barang barang);
    List<BarangOnlyIdCustomDTO> toCustomWithIdDTOList(List<Barang> barang);
}
