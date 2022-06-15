package org.vaadin.example.HTMLtoRTFaddon;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Route("")
public class AddonView extends Div {

    public AddonView() {
        Button button = new Button("click me", l -> {
            HtmlRtfClientSideConverter htmlRtfClientSideConverter = new HtmlRtfClientSideConverter();
            CompletableFuture<String> rtFfromHtml =
                    htmlRtfClientSideConverter.getRTFfromHtmlFuture(
                            ("<p><span style=\"font-family: impact, sans-serif;\"><span style=\"" +
                                    "text-decoration: underline; font-size: 24pt;\"><em><span style=\"font-family:" +
                                    " sans-serif;\">СЛАВА</span> <span style=\"font-family: sans" +
                                    "-serif; color: rgb(224, 62, 45); text-decoration: underline;\">REDSOFT</span></em></span></span></p>"),
                            this.getElement());
            rtFfromHtml.thenRun(() -> {
                try {
                    add(new Text(rtFfromHtml.get()));
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        });
        add(button);
    }
}
