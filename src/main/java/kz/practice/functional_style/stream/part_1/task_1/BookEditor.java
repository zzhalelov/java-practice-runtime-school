package kz.practice.functional_style.stream.part_1.task_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookEditor {
    private HeaderDecorator headerDecorator;
    private final List<LineProcessor> lineProcessors = new ArrayList<>();

    public static void main(String[] args) {
        BookEditor bookEditor = new BookEditor();

        //bookEditor.setHeaderDecorator(new ToUpperCaseHeaderDecorator());
        //перепишем верхнюю строку с использоыванием lambda
        bookEditor.setHeaderDecorator(header -> header.toUpperCase() + "\n");

        //bookEditor.addLineProcessor(new CapitalizeFirstLetterProcessor());
        // перепишем верхнюю строку также с использоыванием lambda
        bookEditor.addLineProcessor(line -> line.substring(0, 1).toUpperCase() + line.substring(1));
        //перенос строки
        bookEditor.addLineProcessor(line -> line + "\n");

        List<String> content = Arrays.asList(
                "Приключения Java-программиста",
                "История началась рано утром, ",
                "когда программист вышел из дома, ",
                "решив выпить утренний кофе."
        );

        List<String> resultContent = bookEditor.processText(content);
        System.out.println(resultContent);
    }

    public List<String> processText(List<String> sourceText) {
        List<String> resultText = new ArrayList<>();

        String sourceHeader = sourceText.get(0);
        String decoratedHeader = headerDecorator.decorate(sourceHeader);
        resultText.add(decoratedHeader);

        for (int i = 1; i < sourceText.size(); i++) {
            String currentLine = sourceText.get(i);
            for (LineProcessor processor : lineProcessors) {
                currentLine = processor.processLine(currentLine);
            }
            resultText.add(currentLine);
        }

        return resultText;
    }

    public void setHeaderDecorator(HeaderDecorator headerDecorator) {
        this.headerDecorator = headerDecorator;
    }

    public void addLineProcessor(LineProcessor lineProcessor) {
        this.lineProcessors.add(lineProcessor);
    }
}