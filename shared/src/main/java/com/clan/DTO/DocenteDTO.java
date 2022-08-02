package com.clan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTO {
    private String cFTeacher;
    private String nameTeacher;
    private String surnameTeacher;
    private String passwordTeacher;
    private Integer idIstitute;
    private Integer idMateria;
}
