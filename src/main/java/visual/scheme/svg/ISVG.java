package visual.scheme.svg;

public interface ISVG {

    String svgStart = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<svg version = \"1.1\"\n" +
            "     baseProfile=\"full\"\n" +
            "     xmlns = \"http://www.w3.org/2000/svg\" \n" +
            "     height = \"400px\"  width = \"400px\">\n" +
            "     <rect x=\"0\" y=\"0\" width=\"400\" height=\"400\" \n" +
            "          fill=\"none\" stroke=\"black\" stroke-width=\"1px\" stroke-opacity=\"1\"/>\n";
    String svgEnd = "</svg>";
    void flush(String fileName);
}
