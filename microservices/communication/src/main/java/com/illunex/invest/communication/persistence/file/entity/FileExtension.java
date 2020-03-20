package com.illunex.invest.communication.persistence.file.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "file_extension")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String extension;
}
