package br.com.rodrigo.mdm.company.service;

import br.com.rodrigo.mdm.company.dto.*;

public interface CompanyService {

    public CompanyDTO convertToObject(Long id);

    public Long convertToId(Long identity, Long verifDigit, Integer type);
}
