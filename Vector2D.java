package Unit;


public class Vector2D {
    protected int posX;
    protected int posY;

    public Vector2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    protected Double getDistance(Vector2D opponent){
        return Math.sqrt(Math.pow(posX - opponent.posX,2) + Math.pow(posY - opponent.posY,2));
    }

    protected boolean onTheLeft(Vector2D opponent){
        return (posX < opponent.posX)? false: true;
    }

    protected boolean onTheTop(Vector2D opponent){
        return (posY > opponent.posY)? false: true;
    }

}
