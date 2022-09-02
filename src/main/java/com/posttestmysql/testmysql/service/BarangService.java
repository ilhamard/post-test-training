package com.posttestmysql.testmysql.service;

import com.posttestmysql.testmysql.entity.Barang;
import com.posttestmysql.testmysql.entity.dto.BarangDto;
import com.posttestmysql.testmysql.entity.dto.custom.BarangOnlyIdCustomDTO;
import com.posttestmysql.testmysql.entity.dto.custom.BarangUpdateCustomDTO;
import com.posttestmysql.testmysql.entity.mapping.BarangMapping;
import com.posttestmysql.testmysql.repository.BarangRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangService {

    @Autowired
    BarangRepos barangRepos;

    //Create
    public BarangOnlyIdCustomDTO createBarang(BarangDto data){
        Barang barang = BarangMapping.INSTANCE.toEntity(data);
        return BarangMapping.INSTANCE.toCustomWithIdDTO(barangRepos.save(barang));
    }

    //Read

    public List<BarangOnlyIdCustomDTO> selectBarang(){
        return BarangMapping.INSTANCE.toCustomWithIdDTOList(barangRepos.findAll());
    }

    //update

    public BarangOnlyIdCustomDTO updateBarangById(BarangUpdateCustomDTO data, Integer id){
        Barang entity = BarangMapping.INSTANCE.toUpdateCustomEntity(data);
        Barang reference = barangRepos.findById(id).get();
        reference.setNama_Barang(data.getNama_Barang()!=null?data.getNama_Barang():reference.getNama_Barang());
        reference.setHarga(data.getHarga()!=null?data.getHarga():reference.getHarga());
        reference.setStok(data.getStok()!=null?data.getStok():reference.getStok());
        return BarangMapping.INSTANCE.toCustomWithIdDTO(barangRepos.save(reference));
    }
    // delete
    public boolean deleteBarangById(Integer id){
        Barang reference = barangRepos.findById(id).orElse(null);
        if(reference != null){
            barangRepos.delete(reference);
            return true;
        }else {
            return false;
        }
    }
}
