package br.com.xpto.util.mapper;

import br.com.xpto.dto.StateDTO;
import br.com.xpto.entity.State;
import org.springframework.data.domain.Page;

public class StateMapper {

    public static Page<StateDTO> toPageEntityFromPageDTO(Page<State> statePage){
        Page<StateDTO> stateDTOPage = statePage.map(state ->{
            StateDTO stateDTO = new StateDTO();
            stateDTO.setName(state.getName());
            stateDTO.setUf(state.getUf());
            stateDTO.setSigla(state.getSigla());
            return stateDTO;
        });
        return stateDTOPage;
    }
}
