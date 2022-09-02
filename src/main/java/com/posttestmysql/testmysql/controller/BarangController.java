package com.posttestmysql.testmysql.controller;

import com.posttestmysql.testmysql.common.Response;
import com.posttestmysql.testmysql.entity.Barang;
import com.posttestmysql.testmysql.entity.dto.BarangDto;
import com.posttestmysql.testmysql.entity.dto.custom.BarangOnlyIdCustomDTO;
import com.posttestmysql.testmysql.entity.dto.custom.BarangUpdateCustomDTO;
import com.posttestmysql.testmysql.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "barang")
public class BarangController {

    @Autowired
    BarangService barangService;

    @PostMapping
    public Response createBarang(@RequestBody BarangDto data){
        return new Response(barangService.createBarang(data), "Barang created !", HttpStatus.OK);
    }

    @GetMapping
    public Response selectBarang(){
        return new Response(barangService.selectBarang(),"shwo all barang !", HttpStatus.OK);
    }

   @PutMapping("/{id}")
    public Response updateBarang(@RequestBody BarangUpdateCustomDTO data, @PathVariable Integer id){
        return new Response(barangService.updateBarangById(data, id),"barang updated", HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
    public Response deleteBarangById(@PathVariable Integer id){
        if (barangService.deleteBarangById(id)){
            return new Response(null, "Barang Deleted",HttpStatus.OK);
        }else{
            return new Response(null, "Barang Fail to delete", HttpStatus.OK);
        }
   }
}
