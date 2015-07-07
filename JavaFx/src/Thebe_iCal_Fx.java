import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Thebe_iCal_Fx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
        
    Button button = new Button ("save");
    Label notification = new Label ();
    TextField subject = new TextField("");
    TextField location = new TextField("");
    TextArea description = new TextArea ("");
    //Event subject line
    String sSubject = "";
  	//Event location
  	String sLocation = "";
  	//Event description which will be placed in the body
  	String sDescription = "";
  	//Beginning month event starts
  	String startMonth = "";
  	//Beginning day event starts
  	String startDay = "";
  	//Beginning year event starts
  	String startYear = "";
  	//Beginning time event starts
  	String startTime = "";
  	//End month event ends
  	String endMonth = "";
  	//End day event ends
  	String endDay = "";
  	//End year event ends
  	String endYear = "";
  	//End time event ends
  	String endTime = "";
  	//Current time and date
  	String currentTime = "";
  	//Event class
  	String sClass = "";
  	//User's choice
  	int iChoice;
  	
    
    @Override public void start(final Stage stage) {
        stage.setTitle("Thebe_iCal");
        Scene scene = new Scene(new Group(), 450, 250);
        
        //comboBox for start of month
        final ComboBox<String> sMonthsComboBox = new ComboBox<String>();
        sMonthsComboBox.getItems().addAll(
        		"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
        );
        
        //comboBox for start of day
        final ComboBox<String> sDaysComboBox = new ComboBox<String>();
        sDaysComboBox.getItems().addAll(
        		"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        );
        
        //comboBox for start of year
        final ComboBox<String> sYearsComboBox = new ComboBox<String>();
        sYearsComboBox.getItems().addAll(
        		"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"
        );
        
        //comboBox for start of time
        final ComboBox<String> sTimeComboBox = new ComboBox<String>();
        sTimeComboBox.getItems().addAll(
        		"0000", "0100", "0200", "0300", "0400", "0500", "0600", "0700", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", "2000", "2100", "2200", "2300", "2400"
        );
    
        //comboBox for end of month
        final ComboBox<String> eMonthsComboBox = new ComboBox<String>();
        eMonthsComboBox.getItems().addAll(
        		"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
        );
        
      //comboBox for end of day
        final ComboBox<String> eDaysComboBox = new ComboBox<String>();
        eDaysComboBox.getItems().addAll(
        		"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        );
        
      //comboBox for end of year
        final ComboBox<String> eYearsComboBox = new ComboBox<String>();
        eYearsComboBox.getItems().addAll(
        		"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"
        );
        
      //comboBox for end of time
        final ComboBox<String> eTimeComboBox = new ComboBox<String>();
        eTimeComboBox.getItems().addAll(
        		"0000", "0100", "0200", "0300", "0400", "0500", "0600", "0700", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", "2000", "2100", "2200", "2300", "2400"
        );
        
        final ComboBox<String> eventClassComboBox = new ComboBox<String>();
        eventClassComboBox.getItems().addAll(
        		"Public", "Private", "Confidential"
        );
        
    	sSubject = subject.getText();
    	sLocation = location.getText();
    	sDescription = description.getText();
    	startYear = sYearsComboBox.getSelectionModel().toString();
    	startMonth = sMonthsComboBox.getSelectionModel().toString();
    	startDay = sDaysComboBox.getSelectionModel().toString();
    	startTime = sTimeComboBox.getSelectionModel().toString();
    	endYear = eYearsComboBox.getSelectionModel().toString();
    	endMonth = eMonthsComboBox.getSelectionModel().toString();
    	endDay = eDaysComboBox.getSelectionModel().toString();
    	endTime = eTimeComboBox.getSelectionModel().toString();
    	sClass = eventClassComboBox.getSelectionModel().toString();
        
        GridPane grid = new GridPane();      
        grid.setVgap(4);
        grid.setHgap(4);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(new Label("Subject: "), 0, 0);
        grid.add(subject,  0,1);
        grid.add(new Label("Start Month: "), 0, 2);
        grid.add(sMonthsComboBox,  0,3);
        grid.add(new Label("Start Day: "), 0,4);
        grid.add(sDaysComboBox, 0,5);
        grid.add(new Label("Start Year: "), 0,6);
        grid.add(sYearsComboBox, 0,7);
        grid.add(new Label("Start Time: "), 0,8);
        grid.add(sTimeComboBox, 0,9);
        
        grid.add(new Label("End Month: "), 1,2);
        grid.add(eMonthsComboBox,  1,3);
        grid.add(new Label("End Day: "), 1,4);
        grid.add(eDaysComboBox, 1,5);
        grid.add(new Label("End Year: "), 1,6);
        grid.add(eYearsComboBox, 1,7);
        grid.add(new Label("End Time: "), 1,8);
        grid.add(eTimeComboBox, 1,9);
        grid.add(new Label("Event Class: "), 2,0);
        grid.add(eventClassComboBox, 2,1);
        
        grid.add(new Label("Description:"), 0, 10);
        grid.add(description, 0, 11);
        
        grid.add(button, 0, 12);
        grid.add (notification, 1, 3, 3, 1);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
        
        button.setOnAction(new EventHandler <ActionEvent >() {
         	  @Override
         	  public void handle(ActionEvent actionEvent) {
         		 FileChooser fileChooser = new FileChooser();
      	     File direct = new File(System.getProperty("user.home"));
      	     fileChooser.setInitialDirectory(direct);
             File file = fileChooser.showSaveDialog(stage);
               if (file != null) {
              	 
              	 try {
              		// Check to see if file exists
              		// If not, create it
              		file.createNewFile();
              		file.canRead();
              		
              		// Use PrintWriter to write to the file
              	    PrintWriter fout = new PrintWriter(file);
              	    fout.println("BEGIN:VCALENDAR\n"
            				+ "PRODID:-//Microsoft Corporation//Outlook 14.0 MIMEDIR//EN\n"
            				+ "VERSION:2.0\n"
            				+ "METHOD:PUBLISH\n"
            				+ "X-MS-OLK-FORCEINSPECTOROPEN:TRUE\n"
            				+ "BEGIN:VTIMEZONE\n"
            				+ "TZID:Hawaiian Standard Time\n"
            				+ "BEGIN:STANDARD\n"
            				+ "DTSTART:16010101T000000\n"
            				+ "TZOFFSETFROM:-1000\n"
            				+ "TZOFFSETTO:-1000\n"
            				+ "END:STANDARD\n"
            				+ "END:VTIMEZONE\n"
            				+ "BEGIN:VEVENT\n"
            				+ "CLASS:" + sClass + "\n"
            				+ "CREATED:20150627T031544Z\n"
            				+ "DESCRIPTION:" + sDescription + "\\n\n"
            				+ "DTEND;TZID=\"Hawaiian Standard Time\":" + eYearsComboBox + eMonthsComboBox + sDaysComboBox + "T" + eTimeComboBox + "00\n"
            				+ "DTSTAMP:20150627T031544Z\n"
            				+ "DTSTART;TZID=\"Hawaiian Standard Time\":" + sYearsComboBox + sMonthsComboBox + eDaysComboBox + "T" + sTimeComboBox + "00\n"
            				+ "LAST-MODIFIED:20150627T031544Z\n"
            				+ "LOCATION:" + sLocation + "\n"
            				+ "PRIORITY:5\n"
            				+ "SEQUENCE:0\n"
            				+ "SUMMARY;LANGUAGE=en-us:" + sSubject + "\n"
            				+ "TRANSP:OPAQUE\n"
            				+ "UID:040000008200E00074C5B7101A82E00800000000407663BC33B0D001000000000000000\n"
            				+ "\t010000000109752F585EB3B448B59159DFD3CF4D2\n"
            				//+ "X-ALT-DESC;FMTTYPE=text/html:<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2//E\n"
            				//+ "\tN\">\\n<HTML>\\n<HEAD>\\n<META NAME=\"Generator\" CONTENT=\"MS Exchange Server ve\n"
            				//+ "\trsion 14.02.5004.000\">\\n<TITLE></TITLE>\\n</HEAD>\\n<BODY>\\n<!-- Converted f\n"
            				//+ "\trom text/rtf format -->\\n\\n<P DIR=LTR><SPAN LANG=\"en-us\"><FONT FACE=\"Calib\n"
            				//+ "\tri\">This is an example of sample text in the body of an appointment.</FONT\n"
            				//+ "\t></SPAN><SPAN LANG=\"en-us\"> </SPAN></P>\\n\\n</BODY>\\n</HTML>\n"
            				//+ "X-MICROSOFT-CDO-BUSYSTATUS:BUSY\n"
            				//+ "X-MICROSOFT-CDO-IMPORTANCE:1\n"
            				//+ "X-MICROSOFT-DISALLOW-COUNTER:FALSE\n"
            				//+ "X-MS-OLK-AUTOFILLLOCATION:FALSE\n"
            				//+ "X-MS-OLK-CONFTYPE:0\n"
            				//+ "BEGIN:VALARM\n"
            				//+ "TRIGGER:-PT15M\n"
            				//+ "ACTION:DISPLAY\n"
            				//+ "DESCRIPTION:Reminder\n"
            				//+ "END:VALARM\n"
            				+ "END:VEVENT\n"
            				+ "END:VCALENDAR");     		
   
              	    		fout.close();
                   }
              	 catch (IOException ex) {
                  	 System.out.println("File error..");
                   }
               }        		  
         	  }
           });        
        
        
        
       
    }    
}