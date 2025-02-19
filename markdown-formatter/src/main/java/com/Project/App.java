// filepath: /d:/MarkdownProject/markdown-formatter/src/main/java/com/nyheng/App.java
package com.nyheng;
//
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import java.util.Scanner;

public class App {
    public static String convertMarkdownToHtml(String markdown) {
        // setting
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        // process
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write your Document: ");
        StringBuilder markdown = new StringBuilder();
        String line = input.nextLine();
        // Add text on each line that entered by user until the end
        markdown.append(line).append("\n");
        while (true) {
            line = input.nextLine();
            if (line.isEmpty()) {
                break; // Break if the user presses Enter without any text (new line).
            }
            markdown.append(line).append("\n");
        }
        // convert the full markdown text
        String html = convertMarkdownToHtml(markdown.toString());
        System.out.println(html);
        input.close();
    }
}
