package qaclickacademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {
	
	//Identify the column named testcases by scanning the entire first row
	// Once the coulmn is identified then scan entire testcase column for the purchase test case row
	//pull all the data of the purchase row and feed into the test

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


	}
	
	public ArrayList<String> getData(String testcasename) throws IOException
	{
		
		ArrayList<String> a = new ArrayList<String>();
		
		FileInputStream file = new  FileInputStream("D://Selenium/DataDriven/demo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);  //Access the file
		
		int sheets= workbook.getNumberOfSheets(); // no of sheets present in the workbook
		for(int i=0;i<sheets;i++)
		{
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) //gets the sheet name and compares with testdata
			{
				XSSFSheet sheet =workbook.getSheetAt(i); //returns the sheets
				//Identify the column named testcases by scanning the entire first row
				
				Iterator<Row> rows =sheet.iterator(); // to iterate all the rows in the sheet
				Row firstrow =rows.next();
				
				Iterator<Cell> cell =firstrow.cellIterator(); // to iterate through each cell in first row, row is collection of cells
				int k=0;
				int column = 0;
				while(cell.hasNext()) //hasnext checks for next cell is present and will not move
				{
					Cell value=cell.next(); //grabbing the complete cell
					if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						column=k;
					}
					k++;
				}
				System.out.println(column);
				
				//Once the coulmn is identified then scan entire testcase column for the purchase test case row
				while(rows.hasNext())
				{
					Row r =rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						//pull all the data of the purchase row and feed into the test
						Iterator<Cell>cv=r.cellIterator(); // iterate all the cells of the purchase row
						while(cv.hasNext())
						{
							Cell c=cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								a.add(cv.next().getStringCellValue()); //adding data to the arraylist
							}
							else
							{
								
								a.add(NumberToTextConverter.toText(c.getNumericCellValue())); // it converts int to string
							}
							 
						}
					}
				}
				
			}
		}
		return a;
		
	}

}
