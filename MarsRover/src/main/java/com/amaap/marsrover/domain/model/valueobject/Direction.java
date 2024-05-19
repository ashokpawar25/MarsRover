package com.amaap.marsrover.domain.model.valueobject;

public enum Direction {
    N, E, S, W;

    private Direction left;
    private Direction right;

    static {
        N.left = W;
        N.right = E;
        E.left = N;
        E.right = S;
        S.left = E;
        S.right = W;
        W.left = S;
        W.right = N;
    }

    public Direction getLeft() {
        return left;
    }

    public Direction getRight() {
        return right;
    }
}
