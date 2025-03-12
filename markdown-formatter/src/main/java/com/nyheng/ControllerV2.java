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
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.util.data.MutableDataSet;
import java.util.Arrays;

public class ControllerV2 {

    @FXML
    private WebView result;

    @FXML
    private TextArea text;
    private WebEngine webEngine;

    @FXML
    private Button Mdfield;

    @FXML
    private Button PDFfield;

    @FXML
    private Button Exitfield;

    public void initialize() {
        webEngine = result.getEngine();
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updatePreview(newValue);
            }
        });
    }

    private String convertMarkdownToHtml(String markdown) {
        MutableDataSet options = new MutableDataSet();
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }

    private void updatePreview(String markdown) {
        String htmlOutput = convertMarkdownToHtml(markdown);
        webEngine.loadContent(htmlOutput);
    }

    public void MdOnAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("README.md");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Markdown Files", "*.md"));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (FileWriter fw = new FileWriter(file)) {
                String markdownContent = text.getText();
                fw.write(markdownContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void PdfOnAction() {
        String htmlOutput = (String) webEngine.executeScript("document.documentElement.outerHTML");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (OutputStream os = new FileOutputStream(file)) {
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
