package visual.drawable;

import visual.drawable.innerIterator.IIterable;
import visual.drawable.innerIterator.IIterator;
import visual.scheme.IScheme;

public interface IDrawable extends IIterable {
    void draw(IScheme scheme);

    @Override
    default void iterate(IIterator iterator) {
        iterator.iterate(this);
    }
}
