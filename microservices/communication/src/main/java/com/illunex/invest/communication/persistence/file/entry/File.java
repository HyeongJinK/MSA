package com.illunex.invest.communication.persistence.file.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "file")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fileName;
    String originalFilename;
    String filePath;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "fileStoreId")
    FileStore fileStore;
}
