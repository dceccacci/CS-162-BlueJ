import java.util.ArrayList;
import java.util.Iterator;
/**
 * Acts as a basic calculator. Involves additions and subtraction.
 *
 * @author (Devon Ceccacci)
 * @version (1.0)
 */
public class CalcEngine
{
    private ArrayList<String> inputChain;
    private int displayValue;
    private boolean valueInMemory;  //if prev calculation in memory. 


    /**
     * Constructor for objects of class CalcEngine
     */
    public CalcEngine()
    {
        inputChain = new ArrayList<String>();
        displayValue = 0;
        valueInMemory = false;
    }
    
    /**
     * Check to see if there is a calculation still in memory.
     * @return valueInMemory
     */
    public boolean getValueInMemory()
    {
        return valueInMemory;
    }
    
    /**
     * Adds an input to the inputChain list.
     */
    private void addInput(String input)
    {
        inputChain.add(input);
        try {
            displayValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return;
        }
    }
    
    @Override
    /**
     * return inputChain as String
     */
    public String toString()
    {
        String tempString = String.join(" ", inputChain);
        return tempString;
    }
    
    /**
     * return displayValue
     */
    public int getDisplayValue()
    {
        return displayValue;
    }
    
    /**
     * Turns an int number into a string
     */
    private String numToString(int num)
    {
        return String.valueOf(num);
    }
    
    /**
     * --A number button was pressed.--
     * Takes the number, converts to a string,
     * then adds to ArrayList
     * @param number Will be in single digit
     */
    public void numberPressed(int num)
    {
        //System.out.println(toString()+"before num"); //TEST
        if(valueInMemory)
        {
            reset();
        }
        addInput(numToString(num));
        //System.out.println(toString()+"after num"); //TEST
    }
    
    /**
     * --The plus "+" or minus "-" button was pressed--
     * @param Operation  An Elementary arithmetic operation
     */
    public void arithmeticPressed(String operation)
    {
        //System.out.println(toString()+"before ari");    //FOR TEST
        if(inputChain.isEmpty())
        {
            return;
        }
        else{
            removeLastArithmetic();
        }
        addInput(operation);
        //System.out.println(toString()+"after ari");     //FOR TEST
    }
    
    /**
     * remove the last element if + or -
     */
    private void removeLastArithmetic()
    {
        if(inputChain.get(inputChain.size()-1).equals("+") ||
           inputChain.get(inputChain.size()-1).equals("-"))
        {
            removeIndex(inputChain.size()-1);
        }
    }
    
    /**
     * Remove element from list by index number
     * @param int   elements index number
     */
    private void removeIndex(int index)
    {
        inputChain.remove(index);
    }
    
    /**
     * --The equals "=" button was pressed--
     */
    public int calculate()
    {
        //System.out.println(toString() + "Before Calc"); //TEST
        //if the chain is empty
        if(inputChain.isEmpty())
        {
            return 0;
        }
        // if the last entry in chain is a + or -
        removeLastArithmetic();
        //start a temp total. Set it to the first entry
        int tempTotal = Integer.parseInt(inputChain.get(0));
        //go through each element in array
        for(int i=0; i < inputChain.size(); i++)
        {
            switch(inputChain.get(i)) {
                case "+":   //if you are adding
                    tempTotal = tempTotal + Integer.parseInt(inputChain.get(i+1));
                    break;
                case "-":   //if you are subtracting
                    tempTotal = tempTotal - Integer.parseInt(inputChain.get(i+1));
                    break; 
                }
        }
        displayValue = tempTotal;
        valueInMemory = true;
        inputChain.clear();
        numberPressed(tempTotal);
        //System.out.println(toString() + "After Calc");  //TEST
        //System.out.println("CALC DONE"); // FOR TEST
        return tempTotal;
    }
    
    /**
     * --The clear "C" button was pressed--
     * resets inputChain to empty and displayValue to 0
     */
    public void reset()
    {
        inputChain.clear();
        displayValue = 0;
        valueInMemory = false;
    }


}
