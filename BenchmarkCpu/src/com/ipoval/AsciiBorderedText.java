package com.ipoval;

/**
 * Decorates text with ASCII border.
 * +-------------------------------------------+
 * | Intel(R) Core(TM) i7-4850HQ CPU @ 2.30GHz |
 * +-------------------------------------------+
 */
public class AsciiBorderedText {
    public static final String BORDER = "-";
    String text = "";
    String borderedText = "";
    int textLength = 0;

    AsciiBorderedText(String text) {
        this.text = text.trim();
        addWhitespacePadding();
        this.textLength = text.length();
    }

    public String getBorderedText() {
        if (this.textLength == 0) { return ""; }

        // append "+-----------------+\n"
        borderedText += "+";
        for (int i = 0; i <= this.textLength; i++) {
            this.borderedText += BORDER;
        }
        borderedText += "+\n";

        // append "|"
        borderedText += "|";

        // append text
        borderedText += this.text;

        // append " |\n"
        borderedText += "|\n";

        // append "+-----------------+\n"
        borderedText += "+";
        for (int i = 0; i <= this.textLength; i++) {
            this.borderedText += BORDER;
        }
        borderedText += "+\n";

        return borderedText;
    }

    private void addWhitespacePadding() {
        this.text = " " + this.text + " ";
    }
}
