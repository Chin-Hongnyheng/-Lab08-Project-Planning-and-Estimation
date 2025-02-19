package com.nyheng;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

public class Controller {

    @FXML
    private WebView result;

    @FXML
    private TextArea text;
    private WebEngine webEngine;

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

    private void updatePreview(String markdown) {
        String htmlOutput = convertMarkdownToHtml(markdown);
        webEngine.loadContent(htmlOutput);
    }

    private String convertMarkdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }
}
