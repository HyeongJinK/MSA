package com.illunex.invest.communication.persistence.file.repository;

import com.illunex.invest.communication.persistence.file.entity.FileStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStoreRepository extends JpaRepository<FileStore, Long> {
    FileStore findByBucketAndPath(String bucket, String path);
}
