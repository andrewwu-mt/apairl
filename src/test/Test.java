package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Test {

	public static void  main(String[] args){
		try {
					 
			Workbook wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet("Order");
			sheet.setColumnWidth(2, 5000);

			sheet.addMergedRegion(new CellRangeAddress(1,5,0,0));
			sheet.addMergedRegion(new CellRangeAddress(1,5,1,1));
			sheet.addMergedRegion(new CellRangeAddress(1,5,2,2));
			
			Row hRow = sheet.createRow(0);
			hRow.createCell(0).setCellValue("款號");
			hRow.createCell(1).setCellValue("描述");
			hRow.createCell(2).setCellValue("圖片");
			hRow.createCell(3).setCellValue("上碼數");
			hRow.createCell(4).setCellValue("上數量");
			hRow.createCell(5).setCellValue("下碼數");
			hRow.createCell(6).setCellValue("下數量");
			hRow.createCell(7).setCellValue("備註");
			
			Row cRow = sheet.createRow(1);
			XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
			style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			style.setAlignment(CellStyle.ALIGN_CENTER);
			
			cRow.createCell(0).setCellValue("1801");
			cRow.getCell(0).setCellStyle(style);
			cRow.createCell(1).setCellValue("白色");
			cRow.getCell(1).setCellStyle(style);
			
			//FileInputStream obtains input bytes from the image file
			InputStream inputStream = new FileInputStream("C:/Users/Andrew Wu/Desktop/chloe_white.png");
			//Get the contents of an InputStream as a byte[].
			byte[] bytes = IOUtils.toByteArray(inputStream);
			//Adds a picture to the workbook
			int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
			//close the input stream
			inputStream.close();
			 
			//Returns an object that handles instantiating concrete classes
			CreationHelper helper = wb.getCreationHelper();
			 
			//Creates the top-level drawing patriarch.
			Drawing drawing = sheet.createDrawingPatriarch();
			 
			//Create an anchor that is attached to the worksheet
			ClientAnchor anchor = helper.createClientAnchor();
			//set top-left corner for the image
			anchor.setAnchorType(2);
			anchor.setCol1(2);
			anchor.setRow1(1);
			 
			//Creates a picture
			Picture pict = drawing.createPicture(anchor, pictureIdx);
			//Reset the image to the original size
			pict.resize(0.64);
			
			cRow = sheet.getRow(1);
			if(cRow == null) cRow = sheet.createRow(1);
			cRow.createCell(3).setCellValue("XS");
			cRow.createCell(5).setCellValue("XS");

			cRow = sheet.getRow(2);
			if(cRow == null) cRow = sheet.createRow(2);
			cRow.createCell(3).setCellValue("S");
			cRow.createCell(5).setCellValue("S");

			cRow = sheet.getRow(3);
			if(cRow == null) cRow = sheet.createRow(3);
			cRow.createCell(3).setCellValue("M");
			cRow.createCell(5).setCellValue("M");

			cRow = sheet.getRow(4);
			if(cRow == null) cRow = sheet.createRow(4);
			cRow.createCell(3).setCellValue("L");
			cRow.createCell(5).setCellValue("L");

			cRow = sheet.getRow(5);
			if(cRow == null) cRow = sheet.createRow(5);
			cRow.createCell(3).setCellValue("XL");
			cRow.createCell(5).setCellValue("XL");
			
			//Write the Excel file
			FileOutputStream fileOut = null;
			fileOut = new FileOutputStream("C:/Users/Andrew Wu/Desktop/order.xlsx");
			wb.write(fileOut);
			fileOut.close();
		 
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
