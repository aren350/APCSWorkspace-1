import java.util.List;
import java.util.Stack;

public class BrowserModel
{
    private BrowserView view;
    private Stack<Integer> backStk, forwardStk;
    private int topLine;

    // TODO complete constructor


    // TODO complete methods


    // The following are for test purposes only
    protected Stack<Integer> getBackStk()
    {
        return backStk;
    }

    protected Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }
    
    protected int getTopLine()
    {
        return topLine;
    }
}
