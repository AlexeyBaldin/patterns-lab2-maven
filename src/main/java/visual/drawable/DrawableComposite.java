package visual.drawable;

import visual.scheme.IScheme;

import java.util.ArrayList;
import java.util.Arrays;

public class DrawableComposite implements IDrawable{
    private final ArrayList<IDrawable> drawables = new ArrayList<>();

    public DrawableComposite(IDrawable ...drawables) {
        this.drawables.addAll(Arrays.asList(drawables));
    }

    @Override
    public void draw(IScheme scheme) {
        drawables.forEach(drawable -> drawable.draw(scheme));
    }
}
