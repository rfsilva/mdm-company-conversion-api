package br.com.rodrigo.mdm.company.dto;


import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CompanyDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long identity;
    private Long verifDigit;
    private Type type;
    private Status status;

}
