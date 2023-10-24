package br.com.xpto.controller;

import br.com.xpto.dto.MunicipalityDTO;
import br.com.xpto.service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/xpto/municipios")
public class MunicipalityController {

    @Autowired
    private MunicipalityService municipalityService;


    /*
     * Retorna todos as informações da base de dados
     */
    @PostMapping("/load-file")
    public ResponseEntity readFileMunicipioCSV(@RequestParam("file") MultipartFile file) {
        try {
            List<MunicipalityDTO> municipalityDTOS = municipalityService.readFileMunicipioCSV(file);
            return new ResponseEntity<>(municipalityDTOS, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity listAllMunicipalities(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Page<MunicipalityDTO> municipalityDTOPage = municipalityService.listAllMunicipalities(page, size);

        return new ResponseEntity<>(municipalityDTOPage,HttpStatus.OK);
    }


}
