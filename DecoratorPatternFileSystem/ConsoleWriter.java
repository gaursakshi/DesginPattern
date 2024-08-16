package DecoratorPatternFileSystem;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String text) {
        System.out.println("writing to console");
        System.out.println(text);
    }
}
