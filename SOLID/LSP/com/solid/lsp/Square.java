package LSP.com.solid.lsp;

public class Square implements Shape {
    private int side;

    Square(int side) {
        this.setSide(side);
    }

    public void setWidth(int width) {this.setSide(width);
    }

    public int getWidth(){return this.side;}

    public void setHeight(int height) {
        this.setSide(height);
    }

    public int getHeight(){return this.side;}

    public void setSide(int side) {
        this.side = side;
    }

    public int getArea() {
        return side*side;
    }
}
