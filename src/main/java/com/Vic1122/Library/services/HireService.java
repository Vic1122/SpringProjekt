package com.Vic1122.Library.services;

import com.Vic1122.Library.domain.Hire;
import com.Vic1122.Library.repository.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class HireService {

    @Autowired
    HireRepository hireRepository;

    public List<Hire> getHiresByBookId(Integer id){
        return hireRepository.findByHiredBook_Id(id);
    }

}
