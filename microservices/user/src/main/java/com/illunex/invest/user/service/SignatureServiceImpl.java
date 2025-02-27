package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.SignatureDTO;
import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import com.illunex.invest.api.core.user.request.SignatureRequest;
import com.illunex.invest.user.persistence.entity.Signature;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.SignatureRepository;
import com.illunex.invest.user.service.mapper.SignatureMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignatureServiceImpl implements SignatureService {
    private final SignatureRepository signatureRepository;

    private SignatureMapper mapper = Mappers.getMapper(SignatureMapper.class);

    @Override
    public List<SignatureDTO> signatureList(Long userId) {
        return mapper.entityToDto(signatureRepository.findByUserId(userId));
    }

    @Override
    public List<SignatureDTO> signatureList(Long userId, SignatureStatus status) {
        return mapper.entityToDto(signatureRepository.findByUserIdAndStatus(userId, status));
    }

    @Override
    @Transactional
    public SignatureDTO addSignature(SignatureRequest request) {
        return mapper.entityToDto(signatureRepository.save(Signature.builder()
                .imgUrl(request.getImgUrl())
                .status(SignatureStatus.Inactive)
                .updateDate(LocalDateTime.now())
                .user(User.builder()
                        .id(request.getUserId())
                        .build())
                .build()));
    }

    @Override
    @Transactional
    public String toggleSignature(Long id) {
        Signature signature = signatureRepository.findById(id).get().toggleStatus();
        signatureRepository.save(signature);
        return signature.getStatus().toString();
    }

    @Override
    @Transactional
    public void deleteSignature(Long id) {
        signatureRepository.deleteById(id);
    }
}
