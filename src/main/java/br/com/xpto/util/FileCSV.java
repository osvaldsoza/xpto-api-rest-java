package br.com.xpto.util;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public class FileCSV {

    public static List<Record> read(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setHeaderExtractionEnabled(true);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<Record> records = csvParser.parseAllRecords(inputStream);
        return records;
    }
}
