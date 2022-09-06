package ru.rusyaevmax.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Paragraph {
    private final String textLink;
    private final String content;
    private List<Paragraph> choices = new LinkedList<>();

    public Paragraph(String textLink, String content) {
        this.textLink = textLink;
        this.content = content;
    }

    public String getTextLink() {
        return textLink;
    }

    public String getContent() {
        return content;
    }

    public List<Paragraph> getChoices() {
        return choices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        if (!Objects.equals(textLink, paragraph.textLink)) return false;
        if (!Objects.equals(content, paragraph.content)) return false;
        return Objects.equals(choices, paragraph.choices);
    }

    @Override
    public int hashCode() {
        int result = textLink != null ? textLink.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (choices != null ? choices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "textLink='" + textLink + '\'' +
                ", content='" + content + '\'' +
                ", choices=" + choices +
                '}';
    }
}
