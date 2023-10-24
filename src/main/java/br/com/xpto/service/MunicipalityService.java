package br.com.xpto.service;

import br.com.xpto.dto.MunicipalityDTO;
import br.com.xpto.entity.Municipality;
import br.com.xpto.repository.MunicipalityRepository;
import br.com.xpto.util.FileCSV;
import br.com.xpto.util.mapper.MunicipalityMapper;
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
public class MunicipalityService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<MunicipalityDTO> readFileMunicipioCSV(MultipartFile file) throws Exception {
        List<Record> records = FileCSV.read(file);
        List<MunicipalityDTO> municipalitiesDTO = toRecordFromMunicipalityDTO(records);
        return createMunicipality(municipalitiesDTO);
    }

    public Page<MunicipalityDTO> listAllMunicipalities(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Municipality> municipalityPage = municipalityRepository.findAll(pageable);

        Page<MunicipalityDTO> municipalityDTOPage = MunicipalityMapper.toPageEntityFromPageDTO(municipalityPage);

        return municipalityDTOPage;
    }

    public List<MunicipalityDTO> createMunicipality(List<MunicipalityDTO> municipalitiesDTO) {
        List<Municipality> municipalities = municipalitiesDTO.stream().map(dto -> modelMapper.map(dto, Municipality.class))
                .collect(Collectors.toList());

        List<Municipality> municipalitiesCreated = municipalityRepository.saveAll(municipalities);

        return municipalitiesCreated
                .stream()
                .map(municipality -> modelMapper.map(municipality, MunicipalityDTO.class))
                .collect(Collectors.toList());
    }

    private List<MunicipalityDTO> toRecordFromMunicipalityDTO(List<Record> records) {
        List<MunicipalityDTO> municipalitiesDTO = new ArrayList<>();

        records.forEach(record -> {
            MunicipalityDTO municipalityDTO = new MunicipalityDTO();
            municipalityDTO.setCode(record.getLong("COD"));
            municipalityDTO.setName(record.getString("NAME"));
            municipalityDTO.setUf(record.getLong("UF"));
            municipalitiesDTO.add(municipalityDTO);
        });
        return municipalitiesDTO;
    }
}
