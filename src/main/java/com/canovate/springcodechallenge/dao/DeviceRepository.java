package com.canovate.springcodechallenge.dao;

import com.canovate.springcodechallenge.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("select case when count(d)> 0 then true else false end from Device d where d.brand = :brand and d.model = :model and d.osVersion = :osVersion")
    boolean existsDeviceByBrandAndModelAndOsVersion(@Param("brand") String brand, @Param("model") String model, @Param("osVersion") String osVersion);
}
