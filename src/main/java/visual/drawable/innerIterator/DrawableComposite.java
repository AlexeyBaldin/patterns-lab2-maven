package visual.drawable.innerIterator;

import visual.drawable.IDrawable;
import visual.scheme.IScheme;

import java.util.ArrayList;
import java.util.Arrays;

public class DrawableComposite implements IDrawable {
    private final ArrayList<IDrawable> drawables = new ArrayList<>();

    public DrawableComposite(IDrawable... drawables) {
        this.drawables.addAll(Arrays.asList(drawables));
    }

    public void add(IDrawable drawable, IDrawable... drawables) {
        this.drawables.add(drawable);
        this.drawables.addAll(Arrays.asList(drawables));
    }

    @Override
    public void draw(IScheme scheme) {
        drawables.forEach(drawable -> drawable.draw(scheme));
    }

    @Override
    public void iterate(IIterator iterator) {
        this.drawables.forEach(drawable -> drawable.iterate(iterator));
    }
    public void clear() {
        drawables.forEach(drawable -> {
            if(drawable instanceof DrawableComposite) {
                ((DrawableComposite) drawable).clear();
                ((DrawableComposite) drawable).drawables.clear();
            }
        });
        drawables.clear();
    }

}
