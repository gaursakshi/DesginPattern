package DecoratorPatternFileSystem;

public class TestMain {
    public static void main(String[] args) {
        Writer writer = new UpperCaseDecorator(new ConsoleWriter());
        writer.write("Hello World");

        writer=new CleaningDecorator( new UpperCaseDecorator(new ConsoleWriter()));
        writer.write("Hello %W%WWorld");
    }
}
