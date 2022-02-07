package com.seo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelDrivenTesting {



    @Test(dataProvider ="empData" )
    public void postNewEmployeesTest(String index,String strname,String strsalary,String strage) {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        System.out.println("index is "+index);
        System.out.println("strname is "+strname);
        requestParams.put("name", strname);
        System.out.println("salary is"+strsalary );
        requestParams.put("salary", strsalary);
        System.out.println("age is "+strage);
        requestParams.put("age", strage);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request("POST", "/create");
        System.out.println("response is " + response.getBody().asString());
        String strresponse = response.getBody().asString();
        System.out.println(strresponse.contains(strname));
        Assert.assertEquals(true, strresponse.contains(strname));
        Assert.assertEquals(true, strresponse.contains(strsalary));
        Assert.assertEquals(true, strresponse.contains(strage));

    }


    @DataProvider(name ="empData")
    public Object[][] getEmpData() throws IOException, InvalidFormatException, IOException, InvalidFormatException {
        //String empData[][]={{"sudhaxyz","1000","20"},{"raman","2000","25"},{"sitank","5000","30"}};
        List<String[][]> empDataList = new ArrayList<String[][]>();
        String strFilePath = "D:\\RESTAPITesting\\EmployeeData.xlsx";
        File file = new File(strFilePath);
        XSSFWorkbook workBook = new XSSFWorkbook(file);
        XSSFSheet sheet = workBook.getSheetAt(0);
        System.out.println("number of rows is " + sheet.getPhysicalNumberOfRows());
        int rows = sheet.getLastRowNum();
        System.out.println("rowc ount is " + rows);
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("cellcount ios " + columns);

        Object[][] empData = new Object[rows][columns];
        for(int r=1;r<rows;r++){
            Row row = sheet.getRow(r);
            for(int c=0;c<columns;c++){
                Cell cell = row.getCell(c);
                if (cell != null) {
                    if (cell.getCellType() == CellType.STRING) {
                        //need to write code here
                        empData[r][c] = "" + cell.getStringCellValue();
                    }
                    if (cell.getCellType() == CellType.NUMERIC) {
                        int icellStringdata = (int) (cell.getNumericCellValue());
                        empData[r][c] = "" + String.valueOf(icellStringdata);
                    }
                }

                System.out.println("cell data is for "+r+" and "+c+" is " + empData[r][c]);

            }


        }
        return empData;


    }

}
