package visual.drawable;

import visual.scheme.IScheme;

import java.util.ArrayList;
import java.util.Arrays;

public class DrawableComposite implements IDrawable{
    private final ArrayList<IDrawable> drawables = new ArrayList<>();

    public DrawableComposite(IDrawable ...drawables) {
        this.drawables.addAll(Arrays.asList(drawables));
    }

    public void add(IDrawable drawable, IDrawable ...drawables) {
        this.drawables.add(drawable);
        this.drawables.addAll(Arrays.asList(drawables));
    }

    public void clear() {
        this.drawables.clear();
    }

    @Override
    public void draw(IScheme scheme) {
        drawables.forEach(drawable -> drawable.draw(scheme));
    }
}
