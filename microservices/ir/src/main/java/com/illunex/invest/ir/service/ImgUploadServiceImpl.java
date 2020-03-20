package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.communication.dto.MultiFileDeleteDTO;
import com.illunex.invest.api.core.ir.dto.ImgDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.api.core.ir.dto.MemberDTO;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.entity.MemberEntity;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import com.illunex.invest.ir.persistence.repository.MemberRepository;
import com.illunex.invest.ir.service.mapper.MemberMapper;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ImgUploadServiceImpl{
    private Log log = LogFactory.getLog(ImgUploadServiceImpl.class);

    @Autowired
    IRRepository irRepository;
    @Autowired
    MemberRepository memberRepository;

    public void imgTemp(ImgDTO imgDTO) {
        MemberEntity memberEntity = MemberEntity.builder()
                .ir(irRepository.findById(imgDTO.getIrIdx()).get())
                .imgUrl(imgDTO.getImgUrl())
                .imgStatus("temp")
                .build();
        memberRepository.save(memberEntity);
    }

    public MultiFileDeleteDTO imgDelete(Long irIdx) {
        List<MemberEntity> memberEntities = memberRepository.findAllByIrIdxAndImgStatus(irIdx, "temp");

        if (memberEntities.size() == 0) {
            return MultiFileDeleteDTO.builder().bucket("unavailable").build();
        } else {
            String[] keys = new String[memberEntities.size()];

            for (int i=0; i<memberEntities.size(); i++) {
                String imgUrl = memberEntities.get(i).getImgUrl();
                int idx = imgUrl.indexOf("/ir/member");
                String key = imgUrl.substring(idx+1);
                keys[i] = key;
            }

            memberRepository.deleteAll(memberEntities);

            MultiFileDeleteDTO multiFileDeleteDTO = MultiFileDeleteDTO.builder()
                    .bucket("invest-startup")
                    .keys(keys)
                    .build();
            return multiFileDeleteDTO;
        }

    }

}
