package visual.scheme.svg;

import java.io.FileWriter;
import java.io.IOException;

public abstract class SVG implements ISVG {

    private static final String SVG_START = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<svg version = \"1.1\"\n" +
            "     baseProfile=\"full\"\n" +
            "     xmlns = \"http://www.w3.org/2000/svg\" \n" +
            "     height = \"400px\"  width = \"400px\">\n" +
            "     <rect x=\"0\" y=\"0\" width=\"400\" height=\"400\" \n" +
            "          fill=\"none\" stroke=\"black\" stroke-width=\"1px\" stroke-opacity=\"1\"/>\n";
    private static final String SVG_END = "</svg>";

    protected String svgString = SVG_START;

    protected final int radius = 6;

    public void flush(String filename) {
        try(FileWriter writer = new FileWriter(filename + ".svg", false)) {
            writer.write(svgString);
            writer.write(SVG_END);
            writer.flush();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
