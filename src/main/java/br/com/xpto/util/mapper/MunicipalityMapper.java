package br.com.xpto.util.mapper;

import br.com.xpto.dto.MunicipalityDTO;
import br.com.xpto.entity.Municipality;
import org.springframework.data.domain.Page;

public class MunicipalityMapper {


    public static Page<MunicipalityDTO> toPageEntityFromPageDTO(Page<Municipality> municipalityPage){
        Page<MunicipalityDTO> municipalityDTOPage = municipalityPage.map(municipality ->  {
                MunicipalityDTO municipalityDTO = new MunicipalityDTO();
                municipalityDTO.setUf(municipality.getUf());
                municipalityDTO.setName(municipality.getName());
                municipalityDTO.setCode(municipality.getCodigo());
                return municipalityDTO;
        });

        return municipalityDTOPage;
    }
}
