package visual.drawable;

import visual.scheme.IScheme;

import java.util.*;

public class DrawableCompositeOld implements IDrawable, Iterable<IDrawable> {
    private final ArrayList<IDrawable> drawables = new ArrayList<>();

    public DrawableCompositeOld(IDrawable... drawables) {
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



    private static class DrawableIterator implements Iterator<IDrawable> {
        private final DrawableCompositeOld owner;
        private final ArrayList<IDrawable> d;

        private int cursor = 0;
        private int count = 0;

        DrawableIterator(DrawableCompositeOld drawableCompositeOld) {
            this.owner = drawableCompositeOld;
            this.d = new ArrayList<>();
            fill(drawableCompositeOld);
            if (d.size() == 0) {
                throw new NoSuchElementException();
            }
        }

        private void fill(IDrawable drawable) {
            if (drawable instanceof DrawableCompositeOld) {
                for (IDrawable iD :
                        ((DrawableCompositeOld) drawable).drawables) {
                    fill(iD);
                }
            } else {
                d.add(drawable);
            }
        }

        private void count(IDrawable drawable) {
            if (drawable instanceof DrawableCompositeOld) {
                for (IDrawable iD :
                        ((DrawableCompositeOld) drawable).drawables) {
                    count(iD);
                }
            } else {
                this.count++;
            }
        }


        @Override
        public boolean hasNext() {
            return cursor < d.size();
        }

        @Override
        public IDrawable next() {
            count(owner);
            if(this.d.size() != this.count) {
                throw new ConcurrentModificationException();
            }
            this.count = 0;
            return d.get(cursor++);
        }

        public void reset() {
            cursor = 0;
        }
    }

    @Override
    public Iterator<IDrawable> iterator() {
        return new DrawableIterator(this);
    }
}
