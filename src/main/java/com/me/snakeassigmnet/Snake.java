package com.me.snakeassigmnet;

import java.util.LinkedList;
import java.util.List;

public class Snake extends Segment{

    public interface SnakeSegmentListener {
        public void onNewSegment(Segment segment);
    }

    private Direction direction = Direction.RIGHT;

    private final World world;

    private final LinkedList<Segment> body = new LinkedList<>();

    private final List<SnakeSegmentListener> listeners = new LinkedList<>();

    public Snake(int x, int y, World world) {
        super(x, y);
        body.addFirst(new Segment(x,y));
        this.world = world;
    }

    public int getHeadX() {
        return body.getFirst().getX();
    }

    public int getLastX(){
        return body.getLast().getX();
    }

    public int getLastY(){
        return body.getLast().getY();
    }


    public int getHeadY() {
        return body.getFirst().getY();
    }

    public void move() {
        int newX = getX() + direction.getDX();
        int newY = getY() + direction.getDY();
        Segment newHead = new Segment(getHeadX() + direction.getDX(), getHeadY() + direction.getDY());

        body.addFirst(newHead);

        if (!(newHead.getX() == world.getFood().getX() && newHead.getY() == world.getFood().getY())) {
            body.removeLast();
        }
    }

    public void grow() {
        Segment cell = new Segment(getLastX() - direction.getDX(), getLastY()- direction.getDY());
        body.add(cell);
    }

    public void addListener(SnakeSegmentListener listener) {
        listeners.add(listener);
    }

    public void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    public boolean isAt(int x, int y) {
        for (Segment segment : body) {
            if (segment.getX() == x && segment.getY() == y) {
                return true;
            }
        }

        return false;
    }

    public boolean collidesWithItself() {
        Segment head = body.getFirst();
        for (Segment segment : body) {
            if (segment != head && segment.getX() == head.getX() && segment.getY() == head.getY()) {
                return true;
            }
        }
        return false;
    }

    public Direction getDirection() {
        return direction;
    }

}
