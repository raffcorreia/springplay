package com.example.springplay;

import com.lowagie.text.DocumentException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

public class ThymeleafTest {

    @BeforeAll
    static void setupAll() {

    }

    @Test
    public void parseThymeleafTemplate_test() throws DocumentException, IOException {

        String result = parseThymeleafTemplate();
        generatePdfFromHtml(result);
    }

    private String parseThymeleafTemplate() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("to", "Hello Thymeleaf!!!");

        return templateEngine.process("thymeleaf_template", context);
    }

    public void generatePdfFromHtml(String html) throws IOException, DocumentException {
        Path path = Path.of(System.getProperty("user.dir"), "target/", "/thymeleaf.pdf"); // Patch.of take care of the repeated or missing file separator.

        OutputStream outputStream = new FileOutputStream(path.toString());

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();

        renderer.createPDF(outputStream);

        outputStream.close();
    }

//    @Test
    public void givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
        int stringSize = 10 + (int)(Math.random()*10);

        for(int i = 0; i < 100; i++) {
            String generatedString = RandomStringUtils.randomAlphabetic(stringSize);
            String generatedValue = String.format("%.2f", Math.random()*1000);
            System.out.printf("<tr><td>%d</td><td>%d %s</td><td>%s</td></tr>\n", i, i, generatedString, generatedValue);
        }
    }
}
