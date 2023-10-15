package org.example.controller;

import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
public class ResumeController {
    private FileOutputStream outputStream;
    private XSSFWorkbook workbook;
    private final ResumeView view;

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
        } catch (IOException e) {
            System.err.println(Command.CREATE_ERR.getCommand());
            e.printStackTrace();
        }
    }

    public void createResumeSheet() {
        Sheet sheet = workbook.createSheet(Command.RESUME_SHEET_NAME.getCommand());
        Command[] titles = {Command.PERSONINFO_TITLE, Command.EDUCATION_TITLE, Command.CAREER_TITLE};
        List<List<String>>[] datas = new List[]{
                List.of(PersonInfo.toList(view.inputPersonInfo())),
                Education.toList(view.inputEducationList()),
                Career.toList(view.inputCareerList())
        };

        for (int i = 0; i < 3; i++) {
            writeHeader(sheet, titles[i].getCommand().split(","));
            writeCells(sheet, datas[i], i);
        }
    }

    public void createSelfIntroductionSheet() {
        Sheet sheet = workbook.createSheet(Command.SELF_INFO_SHEET_NAME.getCommand());
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(view.inputSelfInformation());
    }

    public void getWrapCellStyle() {
        XSSFCellStyle basicStyle = getBasicStyle();
        setResumeSheetStyle(workbook.getSheetAt(0), basicStyle);
        setSelfInfoSheetStyle(workbook.getSheetAt(1), basicStyle);
    }

    public void saveWorkbookToFile() {
        try {
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
            System.out.println(Command.FINISH.getCommand());
        } catch (IOException e) {
            System.err.println(Command.SAVE_ERR.getCommand());
            e.printStackTrace();
        }
    }

    private void writeCells(Sheet sheet, List<List<String>> datas, int idx) {
        for (List<String> data : datas) {
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            for (int i = 0; i < data.size(); i++) {
                if (idx == 0) {
                    writePhoto(sheet, data.get(0), row);
                    continue;
                }
                row.createCell(i).setCellValue(data.get(i));
            }
        }
    }

    private void setSelfInfoSheetStyle(Sheet sheet, XSSFCellStyle basicStyle) {
        basicStyle.setVerticalAlignment(VerticalAlignment.TOP);
        basicStyle.setAlignment(HorizontalAlignment.GENERAL);
        basicStyle.setWrapText(true);
        sheet.setDefaultColumnStyle(0, basicStyle);
        sheet.setColumnWidth(0, 35000);
        sheet.getRow(0).setHeight((short) 10000);
    }

    private void setResumeSheetStyle(Sheet sheet, XSSFCellStyle basicStyle) {
        for (int i = 0; i < 6; i++) {
            sheet.setDefaultColumnStyle(i, basicStyle);
        }
        sheet.setDefaultColumnWidth(20);
        sheet.setColumnWidth(0, 7500);
    }

    private XSSFCellStyle getBasicStyle() {
        XSSFCellStyle basicStyle = workbook.createCellStyle();
        basicStyle.setAlignment(HorizontalAlignment.CENTER);
        basicStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        basicStyle.setFont(font);
        return basicStyle;
    }

    public void writePhoto(Sheet sheet, String path, Row row) {
        try {
            InputStream is = new FileInputStream(getClass().getClassLoader().getResource(path).getFile());
            byte[] bytes = IOUtils.toByteArray(is);
            int pictureIdx = workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            is.close();
            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            //이미지에 대한 크기와 위치 설정하는 앵커
            XSSFClientAnchor anchor = setAnchor(row);
            //이미지 삽입
            drawing.createPicture(anchor, pictureIdx);
            is.close();
        } catch (IOException e) {
            System.err.println(Command.IMG_ERR.getCommand());
            e.printStackTrace();
        }
    }

    private XSSFClientAnchor setAnchor(Row row) {
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

    public void writeHeader(Sheet sheet, String[] titles) {
        Row header = sheet.createRow(sheet.getLastRowNum() + 1);
        for (int i = 0; i < titles.length; i++) {
            header.createCell(i).setCellValue(titles[i]);
        }
    }
}
