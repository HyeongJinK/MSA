package com.illunex.invest.investorRelations.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VideoData {
    @Id
    Long idx;
    Long evaluationInfoIdx;
    String videoUrl;
}
