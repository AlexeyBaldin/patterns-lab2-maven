package visual.scheme.svg;

import java.io.FileWriter;
import java.io.IOException;

public abstract class SVG implements ISVG {

    protected String svgString = svgStart;

    protected final int radius = 10;

    public void flush(String filename) {
        try(FileWriter writer = new FileWriter(filename + ".svg", false)) {
            writer.write(svgString);
            writer.write(svgEnd);
            writer.flush();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
