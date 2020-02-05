package com.illunex.invest.InvestorRelations.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video_data")
public class VideoDataEntity {
    @Id
    Long idx;
    Long evaluationInfoIdx;
    String videoUrl;
}
