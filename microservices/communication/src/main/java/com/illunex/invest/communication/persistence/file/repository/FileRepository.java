package com.illunex.invest.communication.persistence.file.repository;

import com.illunex.invest.communication.persistence.file.entry.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
