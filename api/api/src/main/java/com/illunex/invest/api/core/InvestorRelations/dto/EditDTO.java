package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditDTO {
    Long irIdx;
    List<HistoryDTO> history;
    List<MemberDTO> member;
    List<ShareholderDTO> shareholder;
}
