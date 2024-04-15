package homework;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.List;
import java.util.zip.*;

@DisplayName("Парсинг Zip-архива")
public class ZipFileParsingTests {
    private final ClassLoader cl = ZipFileParsingTests.class.getClassLoader();

    @Test
    @DisplayName("Zip-архив не пустой")
    void zipFileIsNotEmpty() throws Exception {
        try (InputStream inputStream = cl.getResourceAsStream("homework/pdf_xls_csv.zip")) {
            assert inputStream != null;
        }
    }

    @Test
    @DisplayName("Проверка .xlsx файла")
    void xlsFileTest() throws Exception {
        try (InputStream resource = cl.getResourceAsStream("homework/pdf_xls_csv.zip")) {
            assert resource != null;
            try (ZipInputStream zis = new ZipInputStream(resource)) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().contains("person.xlsx")) {
                        XLS content = new XLS(zis);
                        String actualValue = content.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue();
                        Assertions.assertEquals("Директор", actualValue);
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Проверка .csv файла")
    void csvFileTest() throws Exception {
        try (InputStream resource = cl.getResourceAsStream("homework/pdf_xls_csv.zip")) {
            assert resource != null;
            try (ZipInputStream zis = new ZipInputStream(resource)) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().contains("airplane.csv")) {
                        CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                        List<String[]> csvData = csvReader.readAll();
                        Assertions.assertArrayEquals(new String[]{"Boeing 777;Passenger;Boeing;9700"}, csvData.get(2));
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Проверка .pdf файла")
    void pdfFileTest() throws Exception {
        try (InputStream resource = cl.getResourceAsStream("homework/pdf_xls_csv.zip")) {
            assert resource != null;
            try (ZipInputStream zis = new ZipInputStream(resource)) {
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.getName().contains("LERUA_MERLEN.pdf")) {
                        PDF pdf = new PDF(zis);
                        Assertions.assertEquals("alexeis", pdf.author);

                    }
                }
            }
        }
    }
}










