public class Tree
{
    private Triangle leaves;
    private Square trunk;
    
    public Tree()
    {
        leaves = new Triangle();
        trunk = new Square();
        setup();
    }
    
    public void setup(){
        leaves.moveHorizontal(40);
        leaves.moveVertical(-100);
        leaves.changeSize(150,100);
        leaves.changeColor("green");
        leaves.makeVisible();
        
        trunk.moveHorizontal(-75);
        trunk.moveVertical(70);
        trunk.changeSize(35);
        trunk.changeColor("brown");
        trunk.makeVisible();
        
    }
}