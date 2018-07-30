package helpers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Support to read data from Excel and Json
 * Created by XuyenTran on 7/27/18.
 */
public class ReadDataFile {

    protected static Workbook wb;

    public String readJsonFile(String filePath, Object type, Object key) {
        String rootPath = System.getProperty("user.dir");
        String value = null;
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {

            Object obj = parser.parse(new FileReader(rootPath + filePath));
            jsonObject = (JSONObject) obj;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map abc = ((Map) jsonObject.get(type));
        String temp;

        Iterator<Map.Entry> itr1 = abc.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            temp = pair.getKey().toString();
            if (temp.equals(key)) {
                value = pair.getValue().toString();
            }
        }
        return value;
    }


    public ArrayList<List> readExcelFile(String fileName, String sheetName) {
        String rootPath = System.getProperty("user.dir");
        String path = "/src/test/resources/data/";
        try {
            wb = WorkbookFactory.create(new File(rootPath + path + fileName));

        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        Sheet sheet1 = wb.getSheet(sheetName);
        if (sheet1 == null) {
            throw new InvalidParameterException("Cannot find the sheet Name : " + sheetName + " in the Excel file");
        }

        List<Object> rowData;
        ArrayList<List> allData = new ArrayList<>(sheet1.getLastRowNum() + 1);
        Object value;
        for (Row row : sheet1) {
            rowData = new ArrayList<>(10);
            for (Cell cell : row) {
                value = getCellValueAsObject(cell);
                rowData.add(value);
            }
            allData.add(rowData);
        }
        return allData;
    }

    public static Object getCellValueAsObject(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            switch (cell.getCellType()) {

                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.toString();
                    if (cellValue.equals("null")) {
                        cellValue = null;
                    }
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {

                        SimpleDateFormat dateFormat = new SimpleDateFormat(
                                "yyyy-MM-dd");
                        cellValue = dateFormat.format(cell.getDateCellValue());
                    } else {
                        Double value = cell.getNumericCellValue();
                        Long longValue = value.longValue();
                        cellValue = longValue;
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    cellValue = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    cellValue = null;
                    break;
                default:

            }
        }
        return cellValue;
    }

}
