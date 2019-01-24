package me.client;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.google.gwt.core.client.EntryPoint;
import com.intendia.rxgwt2.elemento.RxElemento;
import elemental2.dom.*;
import io.reactivex.Observable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.EventType.mousemove;


/**
 * Hello world!
 *
 */
public class App implements EntryPoint {
    @Override
    public void onModuleLoad() {
        HTMLElement el = Elements.span().style("font-weight: bold;").get();
        HtmlContentBuilder<HTMLHeadingElement> h1 = Elements.h(1);
        HtmlContentBuilder<HTMLHeadingElement> h3 = Elements.h(3);
        HtmlContentBuilder<HTMLParagraphElement> p = Elements.p();

        h1.css("text-center text-white bg-primary pt-1 pb-1")
            .textContent("FIRST WEB WITH GWT");

        h3.css("text-center pt-5 pb-5")
            .textContent("Move mouse to see position");

        p.css("text-center")
            .textContent("Mouse position: ");
        p.add(el);

        Elements.body().addAll(h1,h3,p);

        RxElemento.fromEvent(document, mousemove)
                .subscribe(ev -> {
                    h3.css("d-none");
                    p.css("mt-5",true);
                    el.textContent = ev.clientX + ", " + ev.clientY;

                });
    }

}
