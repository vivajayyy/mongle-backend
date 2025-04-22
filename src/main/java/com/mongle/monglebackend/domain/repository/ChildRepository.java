package com.mongle.monglebackend.domain.repository;

import com.mongle.monglebackend.domain.entity.Child;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findByUserId(Long userId);

}
