package DecoratorPatternFileSystem;

public abstract class WriterDecorator implements Writer {

    private final Writer writer;

    public WriterDecorator(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void write(String text) {
        writer.write(text);
    }
}
