package org.vaadin.example.HTMLtoRTFaddon;

import com.vaadin.flow.component.internal.PendingJavaScriptInvocation;
import com.vaadin.flow.component.internal.UIInternals;
import com.vaadin.flow.internal.StateNode;
import org.apache.commons.lang3.StringUtils;

public class Util {
    public static PendingJavaScriptInvocation getJavaScriptReturn(StateNode node, String expression) {
        UIInternals.JavaScriptInvocation invocation = new UIInternals.JavaScriptInvocation("return " + expression);
        PendingJavaScriptInvocation pending = new PendingJavaScriptInvocation(node, invocation);
        node.runWhenAttached((ui) -> {
            ui.getInternals().getStateTree().beforeClientResponse(node, (context) -> {
                if (!pending.isCanceled()) {
                    context.getUI().getInternals().addJavaScriptInvocation(pending);
                }
            });
        });
        return pending;
    }

    public static PendingJavaScriptInvocation getJavaScriptInvoke(StateNode node, String expression) {
        UIInternals.JavaScriptInvocation invocation = new UIInternals.JavaScriptInvocation(expression);
        PendingJavaScriptInvocation pending = new PendingJavaScriptInvocation(node, invocation);
        node.runWhenAttached((ui) -> {
            ui.getInternals().getStateTree().beforeClientResponse(node, (context) -> {
                if (!pending.isCanceled()) {
                    context.getUI().getInternals().addJavaScriptInvocation(pending);
                }
            });
        });
        return pending;
    }

    public static String encodeRu(String s) {
        String[] letters = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "а", "б", "в", "г", "д", "е", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я", " "};
        String[] var = {"\\u1040?", "\\u1041?", "\\u1042?", "\\u1043?", "\\u1044?", "\\u1045?", "\\u1046?", "\\u1047?", "\\u1048?", "\\u1049?", "\\u1050?", "\\u1051?", "\\u1052?", "\\u1053?", "\\u1054?", "\\u1055?", "\\u1056?", "\\u1057?", "\\u1058?", "\\u1059?", "\\u1060?", "\\u1061?", "\\u1062?", "\\u1063?", "\\u1064?", "\\u1065?", "\\u1066?", "\\u1067?", "\\u1068?", "\\u1069?", "\\u1070?", "\\u1071?", "\\u1072?", "\\u1073?", "\\u1074?", "\\u1075?", "\\u1076?", "\\u1077?", "\\u1078?", "\\u1079?", "\\u1080?", "\\u1081?", "\\u1082?", "\\u1083?", "\\u1084?", "\\u1085?", "\\u1086?", "\\u1087?", "\\u1088?", "\\u1089?", "\\u1090?", "\\u1091?", "\\u1092?", "\\u1093?", "\\u1094?", "\\u1095?", "\\u1096?", "\\u1097?", "\\u1098?", "\\u1099?", "\\u1100?", "\\u1101?", "\\u1102?", "\\u1103?", "  "};
        for (int i = 0; i < letters.length; i++) {
            s = StringUtils.replace(s, letters[i], var[i]);
        }
        return s;
    }
}
