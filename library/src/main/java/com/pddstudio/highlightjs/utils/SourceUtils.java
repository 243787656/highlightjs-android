package com.pddstudio.highlightjs.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * This Class was created by Patrick J
 * on 09.06.16. For more Details and Licensing
 * have a look at the README.md
 */

public class SourceUtils {

    private static final String SYNTAX_TEMPLATE_HEADER = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, target-densityDpi=device-dpi\">\n" +
            "    <style type=\"text/css\">\n" +
            "       html, body {\n" +
            "           width:100%;\n" +
            "           height: 100%;\n" +
            "           margin: 0px;\n" +
            "           padding: 0px;\n" +
            "       }\n" +
            "   </style>";

    private static final String SYNTAX_TEMPLATE_HEADER_2 = "    <script src=\"./highlight.pack.js\"></script>\n" +
            "    <script>hljs.initHighlightingOnLoad();</script>\n" +
            "</head>\n" +
            "<body style=\"margin: 0; padding: 0\">\n";

    private static final String SYNTAX_TEMPLATE_FOOTER = "</body>\n</html>\n";

    public static String generateContent(String source, @NonNull String style, @Nullable String language) {
        return SYNTAX_TEMPLATE_HEADER
                + getSourceForStyle(style)
                + SYNTAX_TEMPLATE_HEADER_2
                + getSourceForLanguage(source, language)
                + SYNTAX_TEMPLATE_FOOTER;
    }

    private static String getSourceForStyle(String style) {
        return String.format("<link rel=\"stylesheet\" href=\"./styles/%s.css\">\n", style);
    }

    private static String getSourceForLanguage(String source, String language) {
        if(language != null) return String.format("<pre><code class=\"%s\">%s</code></pre>\n", language, source);
        else return String.format("<pre><code>%s</code></pre>\n", source);
    }

}
