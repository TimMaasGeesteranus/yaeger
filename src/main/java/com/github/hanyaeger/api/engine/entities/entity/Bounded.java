package com.github.hanyaeger.api.engine.entities.entity;

import com.github.hanyaeger.api.engine.scenes.DimensionsProvider;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;

/**
 * Implementing this interface exposes the {@link Bounded#getNonTransformedBounds()} method, which returns the bounds, aka
 * Bounding Box, of this Entity.
 */
public interface Bounded extends DimensionsProvider, GameNode {

    /**
     * Return the {@link Bounds} (aka Bounding Box) of the {@link YaegerEntity}. Note that these
     * {@link Bounds} are always a Axis aligned rectangle.
     *
     * @return the {@link Bounds}
     */
    default Bounds getBoundingBox() {
        if (getNode().isPresent()) {
            return getNode().get().getBoundsInParent();
        } else {
            return new BoundingBox(0, 0, 0, 0);
        }
    }

    /**
     * Return the {@link Bounds} (Bounding Box) before all transformations have been applied.
     *
     * @return the {@link Bounds}
     */
    default Bounds getNonTransformedBounds() {
        if (getNode().isPresent()) {
            return getNode().get().getBoundsInLocal();
        } else {
            return new BoundingBox(0, 0, 0, 0);
        }
    }

    /**
     * Return the {@link Bounds} (Bounding Box) within the {@link com.github.hanyaeger.api.engine.scenes.YaegerScene} after
     * all transformations have been applied. This method differs from {@link Bounded#getBoundingBox} in the fact
     * that this methods threats the {@link javafx.scene.Node} as if it was part of the {@link javafx.scene.Scene}. In the case
     * of a {@link CompositeEntity} the {@link javafx.scene.Node} will be part of a {@link javafx.scene.Group}, meaning we get
     * the {@link Bounds} within that {@link javafx.scene.Group} and not the {@link javafx.scene.Scene}.
     *
     * @return the {@link Bounds}
     */
    default Bounds getBoundsInScene() {
        if (getNode().isPresent()) {
            return getNode().get().localToScene(getNode().get().getBoundsInLocal(), true);
        } else {
            return new BoundingBox(0, 0, 0, 0);
        }
    }

    @Override
    default double getWidth() {
        return getBoundingBox().getWidth();
    }

    @Override
    default double getHeight() {
        return getBoundingBox().getHeight();
    }
}
