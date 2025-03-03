package com.nyheng;

import com.itextpdf.html2pdf.HtmlConverter;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
// import com.itextpdf.text.Document;
// import com.itextpdf.text.DocumentException;
// import com.itextpdf.text.pdf.PdfWriter;
// import com.itextpdf.text.Paragraph;

public class ControllerV2 {

    @FXML
    private WebView result;

    @FXML
    private TextArea text;
    private WebEngine webEngine;

    @FXML
    private Button TxTfield;

    @FXML
    private Button PDFfield;

    @FXML
    private Button Exitfield;

    public void initialize() {
        webEngine = result.getEngine();
        // Listen for changes in the TextArea and update WebView automatically
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updatePreview(newValue);
            }
        });
    }

    private String convertMarkdownToHtml(String markdown) {
        // setting
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        // processing
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }

    private void updatePreview(String markdown) {
        String htmlOutput = convertMarkdownToHtml(markdown);
        webEngine.loadContent(htmlOutput);
    }

    public void TxTOnAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (FileWriter fw = new FileWriter(file)) {
                String outputHtml = (String) webEngine.executeScript("document.documentElement.outerHTML");
                fw.write(outputHtml);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void PdfOnAction() {
        // Get the HTML content from the WebView (formatted content)
        String htmlOutput = (String) webEngine.executeScript("document.documentElement.outerHTML");

        // Open the file chooser to select where to save the .pdf file
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (OutputStream os = new FileOutputStream(file)) {
                // Convert HTML to PDF with styles (iText will render the bold, headings, etc.)
                HtmlConverter.convertToPdf(htmlOutput, os);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ExitOnAction(ActionEvent e) {
        Stage stage = (Stage) Exitfield.getScene().getWindow();
        stage.close();
    }
}