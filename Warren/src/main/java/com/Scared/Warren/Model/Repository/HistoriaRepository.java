package com.Scared.Warren.Model.Repository;

import com.Scared.Warren.Model.Historias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaRepository extends JpaRepository<Historias, Long> {
}