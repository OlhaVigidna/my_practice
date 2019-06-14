package com.example.demo.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by okten225 on 6/12/19.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String path;
    String documentName;
    int size;
    Tag tag;
    String type;
    @Temporal(TemporalType.DATE)
    Date creatingTime;
    Date activeUntil;

}
