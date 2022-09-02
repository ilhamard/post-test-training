package com.posttestmysql.testmysql.repository;

import com.posttestmysql.testmysql.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepos extends JpaRepository<Barang, Integer> {
}
