package DecoratorPatternFileSystem;

import java.io.IOException;

public class UpperCaseDecorator extends WriterDecorator{


    public UpperCaseDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String text) {
        text = text.toUpperCase();
        super.write(text);
    }
}
