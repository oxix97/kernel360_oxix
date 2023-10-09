package org.example.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;
import org.example.model.Career;
import org.example.model.Command;
import org.example.model.Education;
import org.example.model.PersonInfo;
import org.example.view.ResumeView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ResumeController {
    private FileOutputStream outputStream;
    private XSSFWorkbook workbook;
    private ResumeView view;
    private int idx = 0;

    public void run() {
        createResume();
        createResumeSheet();
        createSelfIntroductionSheet();
        getWrapCellStyle();
        saveWorkbookToFile();
    }

    public void createResume() {
        try {
            outputStream = new FileOutputStream("resume.xlsx");
            workbook = new XSSFWorkbook();
            view = new ResumeView();
        } catch (IOException e) {
            System.err.println(Command.CREATE_ERR.getCommand());
            e.printStackTrace();
        }
    }

    public void createResumeSheet() {
        Sheet sheet = workbook.createSheet("이력서");
        createPersonInfo(view.inputPersonInfo(), sheet);
        createEducations(view.inputEducationList(), sheet);
        createCareers(view.inputCareerList(), sheet);
    }

    public void createSelfIntroductionSheet() {
        Sheet sheet = workbook.createSheet("자기소개서");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(view.inputSelfInformation());
    }

    public void getWrapCellStyle() {
        Sheet[] sheet = {workbook.getSheetAt(0), workbook.getSheetAt(1)};
        sheet[0].setColumnWidth(0, 7500);
        sheet[0].setDefaultColumnWidth(20);
        XSSFCellStyle basicStyle = defaultStyle();
        for (int i = 0; i < 6; i++) {
            sheet[0].setDefaultColumnStyle(i, basicStyle);
        }
        basicStyle.setVerticalAlignment(VerticalAlignment.TOP);
        basicStyle.setAlignment(HorizontalAlignment.GENERAL);
        basicStyle.setWrapText(true);
        sheet[1].setDefaultColumnStyle(0, basicStyle);
        sheet[1].setColumnWidth(0, 35000);
        sheet[1].getRow(0).setHeight((short) 10000);
    }

    private XSSFCellStyle defaultStyle() {
        XSSFCellStyle basicStyle = workbook.createCellStyle();
        basicStyle.setAlignment(HorizontalAlignment.CENTER);
        basicStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        basicStyle.setFont(font);
        return basicStyle;
    }

    public void saveWorkbookToFile() {
        try {
            workbook.write(outputStream);
            workbook.close();
            System.out.println(Command.FINISH.getCommand());
        } catch (IOException e) {
            System.err.println(Command.SAVE_ERR.getCommand());
            e.printStackTrace();
        }
    }

    public void createCareers(List<Career> careers, Sheet sheet) {
        createHeader(sheet, Command.CAREER_TITLE.getCommand().split(","));
        writeCareers(sheet, careers);
    }

    public void createEducations(List<Education> educations, Sheet sheet) {
        createHeader(sheet, Command.EDUCATION_TITLE.getCommand().split(","));
        writeEducations(sheet, educations);
    }

    public void createPersonInfo(PersonInfo personInfo, Sheet sheet) {
        createHeader(sheet, Command.PERSONINFO_TITLE.getCommand().split(","));
        writePersonInfo(sheet, personInfo);
    }

    public void writeCareers(Sheet sheet, List<Career> careers) {
        for (Career c : careers) {
            Row row = sheet.createRow(idx++);
            row.createCell(0).setCellValue(c.getWorkPeriod());
            row.createCell(1).setCellValue(c.getCompanyName());
            row.createCell(2).setCellValue(c.getJobTitle());
            row.createCell(3).setCellValue(c.getEmploymentYears());
        }
    }

    public void writeEducations(Sheet sheet, List<Education> educations) {
        for (Education edu : educations) {
            Row row = sheet.createRow(idx++);
            row.createCell(0).setCellValue(edu.getGraduationYear());
            row.createCell(1).setCellValue(edu.getSchoolName());
            row.createCell(2).setCellValue(edu.getMajor());
            row.createCell(3).setCellValue(edu.getGraduationStatus());
        }
    }

    public void writePersonInfo(Sheet sheet, PersonInfo personInfo) {
        Row row = sheet.createRow(idx++);
        writePhoto(sheet, personInfo.getPhoto(), row);
        row.createCell(1).setCellValue(personInfo.getName());
        row.createCell(2).setCellValue(personInfo.getEmail());
        row.createCell(3).setCellValue(personInfo.getAddress());
        row.createCell(4).setCellValue(personInfo.getPhone_number());
        row.createCell(5).setCellValue(personInfo.getBirth());
    }

    public void writePhoto(Sheet sheet, String path, Row row) {
        try {
            InputStream is = new FileInputStream(getClass().getClassLoader().getResource(path).getFile());
            byte[] bytes = IOUtils.toByteArray(is);
            int pictureIdx = workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            is.close();
            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            //이미지에 대한 크기와 위치 설정하는 앵커
            XSSFClientAnchor anchor = setPhotoSize(row);
            //이미지 삽입
            drawing.createPicture(anchor, pictureIdx);
        } catch (IOException e) {
            System.err.println(Command.IMG_ERR.getCommand());
            e.printStackTrace();
        }
    }

    public XSSFClientAnchor setPhotoSize(Row row) {
        XSSFCreationHelper helper = workbook.getCreationHelper();
        XSSFClientAnchor anchor = helper.createClientAnchor();
        row.setHeight((short) 5500);
        anchor.setRow1(1);
        anchor.setCol1(0);
        anchor.setRow2(2);
        anchor.setCol2(1);
        anchor.setDx1(10);
        anchor.setDx2(2000);
        anchor.setDy1(10);
        anchor.setDy2(2000);

        return anchor;
    }

    public void createHeader(Sheet sheet, String[] titles) {
        Row header = sheet.createRow(idx++);
        for (int i = 0; i < titles.length; i++) {
            header.createCell(i).setCellValue(titles[i]);
        }
    }
}
