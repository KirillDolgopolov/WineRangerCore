package com.wineranger.wineranger.repository;

import com.wineranger.wineranger.entity.auxuliars.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Long> {
}
