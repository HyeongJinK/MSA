package com.illunex.invest.communication.persistence.file.entry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "file_store")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileStore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String bucket;
    String path;
    int maxSize;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FileExtension> fileExtensions = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "fileStore")
    List<File> files = new ArrayList<>();
}
