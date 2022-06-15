package org.vaadin.example.HTMLtoRTFaddon;

import com.helger.commons.io.stream.StringInputStream;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.dom.Element;
import org.apache.commons.lang3.StringUtils;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.vaadin.example.HTMLtoRTFaddon.Util.getJavaScriptReturn;


@NpmPackage(value = "html-to-rtf",version = "2.0.0")
@JsModule("html-to-rtf/app/browser/bundle.js")
public class HtmlRtfClientSideConverter{

    public CompletableFuture<String> getRTFfromHtmlFuture(String html, Element element) {
        Element parentElem = element;
        while (parentElem.getParent() != null) {
            parentElem = parentElem.getParent();
        }
        String expression =
                "htmlToRtf('" + html + "')";
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
        getJavaScriptReturn(element.getNode(), expression).then(String.class,  s -> stringCompletableFuture.complete(Util.encodeRu(StringUtils.replace(s, "undefined", ""))));
        return stringCompletableFuture;
    }
}
