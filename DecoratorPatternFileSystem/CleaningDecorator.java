package DecoratorPatternFileSystem;

public class CleaningDecorator extends WriterDecorator{


    public CleaningDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String text){
       text = text.replaceAll("[^a-zA-Z]+", " ");
       super.write(text);
    }
}
