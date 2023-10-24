package br.com.xpto.service;

import br.com.xpto.dto.StateDTO;
import br.com.xpto.entity.State;
import br.com.xpto.repository.StateRepository;
import br.com.xpto.util.FileCSV;
import br.com.xpto.util.mapper.StateMapper;
import com.univocity.parsers.common.record.Record;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<StateDTO> readFileStateCSV(MultipartFile file) throws Exception {
        List<Record> records = FileCSV.read(file);
        List<StateDTO> statesDTO = toRecordFromStateDTO(records);
        return createStates(statesDTO);
    }

    public Page<StateDTO> listAllCities(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);

        Page<State> statePage = stateRepository.findAll(pageable);

        Page<StateDTO> stateDTOPage = StateMapper.toPageEntityFromPageDTO(statePage);

        return stateDTOPage;
    }

    public List<StateDTO> createStates(List<StateDTO> statesDTO) {
        List<State> states = statesDTO.stream().map(dto -> modelMapper.map(dto, State.class))
                .collect(Collectors.toList());

        List<State> statesCreated = stateRepository.saveAll(states);

        return statesCreated
                .stream()
                .map(state -> modelMapper.map(state, StateDTO.class))
                .collect(Collectors.toList());
    }

    private List<StateDTO> toRecordFromStateDTO(List<Record> records) {
        List<StateDTO> stateDTOS = new ArrayList<>();
        records.forEach(record -> {
            StateDTO estado = new StateDTO();
            estado.setUf(record.getLong("COD"));
            estado.setName(record.getString("NAME"));
            estado.setSigla(record.getString("SIGLA"));
            stateDTOS.add(estado);

        });
        return stateDTOS;
    }
}
