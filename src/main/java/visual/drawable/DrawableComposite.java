package visual.drawable;

import visual.scheme.IScheme;

import java.util.*;

public class DrawableComposite implements IDrawable, Iterable<IDrawable> {
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



    private static class DrawableIterator implements Iterator<IDrawable> {
        private final DrawableComposite owner;
        private final ArrayList<IDrawable> d;

        private int cursor = 0;
        private int count = 0;

        DrawableIterator(DrawableComposite drawableComposite) {
            this.owner = drawableComposite;
            this.d = new ArrayList<>();
            fill(drawableComposite);
            if (d.size() == 0) {
                throw new NoSuchElementException();
            }
        }

        private void fill(IDrawable drawable) {
            if (drawable instanceof DrawableComposite) {
                for (IDrawable iD :
                        ((DrawableComposite) drawable).drawables) {
                    fill(iD);
                }
            } else {
                d.add(drawable);
            }
        }

        private void count(IDrawable drawable) {
            if (drawable instanceof DrawableComposite) {
                for (IDrawable iD :
                        ((DrawableComposite) drawable).drawables) {
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
            this.count = 0;
            count(owner);
            if(this.d.size() != this.count) {
                throw new ConcurrentModificationException();
            }
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
