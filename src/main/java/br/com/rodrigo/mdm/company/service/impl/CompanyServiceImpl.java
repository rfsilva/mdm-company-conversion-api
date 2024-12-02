package br.com.rodrigo.mdm.company.service.impl;

import br.com.rodrigo.mdm.company.dto.*;
import br.com.rodrigo.mdm.company.service.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Override
    public CompanyDTO convertToObject(Long id) {
        log.info("Obtendo dados do objeto através do ID {}", id);
        CompanyDTO contaCorrente = generateCompany(id);
        log.info("Dados obtidos: {}", contaCorrente.toString());
        return contaCorrente;
    }

    public Long convertToId(Long identity, Long verifDigit, Integer type) {
        Type companyType = Type.of(type);
        log.info("Obtendo ID do objeto através dos dados Identity: {}, VerifDigit: {}, Type: {}", identity, verifDigit, type);
        if (companyType == null) {
            return null;
        }
        if (identity < verifDigit) {
            Long companyId = identity + verifDigit;
            log.info("ID da empresa: {}", companyId);
            return companyId;
        }
        return null;
    }

    private CompanyDTO generateCompany(Long id) {
        if (id == 0) {
            return null;
        }
        return CompanyDTO.builder()
                .id(id)
                .status(Status.ACTIVE)
                .identity(2242L)
                .verifDigit(6224231L)
                .type(Type.PUBLIC)
                .build();
    }
}
