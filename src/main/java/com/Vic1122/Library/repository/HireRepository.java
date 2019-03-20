package com.Vic1122.Library.repository;

import com.Vic1122.Library.domain.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long> {

    List<Hire> findAll();

    @Override
    Optional<Hire> findById(Long aLong);

    List<Hire> findByHiredBook_Id(Integer id);
}
