package org.b2m.lostandfound;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class ParserKrk {


    String wholePDF;
    public ParserKrk(String pathToPDF) throws  IOException {
        //Loading an existing document
        File file = new File(pathToPDF);
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        wholePDF = pdfTextStripper.getText(document);
    }



    public String[][] getAllRecords() {
        int i = 0, j= 0, indexOfEnd = 0 ;
        String tempBeginn;

        List<String> recordList = new ArrayList<String>();
        do {
            i = wholePDF.indexOf("\n",j);
            i++;
            j = wholePDF.indexOf("\n",i);
            tempBeginn	= wholePDF.substring(i, wholePDF.indexOf(" ", i));
            if(tempBeginn.matches("[0-9]+\\.")){
                tempBeginn = wholePDF.substring(i,j-1);
                System.out.println(tempBeginn);
                recordList.add(tempBeginn);
            }
        } while (wholePDF.indexOf("\n",j+1) != -1);
        String[][] stringTable = new String[recordList.size()][3];

        for(i=0;i<recordList.size();i++){
            String subString = recordList.get(i);
            subString = subString.substring(subString.indexOf(" ")+1);

            Pattern pattern = Pattern.compile("SA-03\\.5314\\.1\\.[0-9]+\\.[0-9]+");
            Matcher matcher = pattern.matcher(subString);
            if(matcher.find()) {
                indexOfEnd = matcher.end();
                stringTable[i][0] = subString.substring(0,indexOfEnd++);
            }
            pattern = Pattern.compile("[0-9]{2}-[0-9]{2}-[0-9]{4}");
            matcher = pattern.matcher(subString);
            if(matcher.find()) {
                subString.replaceAll("-", ".");
                stringTable[i][1] = subString.substring(indexOfEnd, matcher.start()-1);
                stringTable[i][2] = subString.substring(matcher.start(),matcher.end());
            }
            pattern = Pattern.compile("[0-9]{2}.[0-9]{2}.[0-9]{4}");
            matcher = pattern.matcher(subString);
            if(matcher.find()) {
                stringTable[i][1] = subString.substring(indexOfEnd, matcher.start()-1);
                stringTable[i][2] = subString.substring(matcher.start(),matcher.end());
            }
        }
        return stringTable;
    }


    @Override
    public String toString() {
        return wholePDF;
    }
}
