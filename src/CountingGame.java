import java.io.*;
import java.util.*;
 
/**
 * CountingGame is a program that will simulate a children's counting game used to select
 * someone.
 * 
 * @author Charles Hoot
  * @version 4.0
 */
   
public class CountingGame
{

    public static void main(String args[])
    {
        ListWithIteratorInterface<Integer> players;
        ListWithIteratorInterface<String> rhyme;
        
        Iterator<Integer> accessPlayer = null;
        Iterator<Integer> playerIter = null;
        Iterator<String> rhymeIter = null;
        int max;
        
        System.out.println("Please enter the number of players in the game");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        System.out.println("Constructing list of players");
        players = new ArrayListWithIterator<Integer>();
        
        for(int i=1; i<=max; i++)
        {
            players.add( i );
        }

        System.out.print("The players list is " );
        accessPlayer = players.getIterator();
        displayCollection(accessPlayer);
        System.out.println( );
        
        
        
        rhyme = getRhyme();
        
        playerIter = players.getIterator();
        

//        while ( players.getLength() > 1)
        {
        
            // Start the rhyme at the beginning each time
            rhymeIter = rhyme.getIterator();
            
            // Player iterator needs to be reset when it is used up.
            // Otherwise we should not reset it so we go over the rest of
            // the players in the list.
            boolean playerRemoved = false;
            while(!playerRemoved){
                //reset the player iterator if it has been exhausted
                if(!playerIter.hasNext())
                    playerIter = players.getIterator();
                playerRemoved = doRhymePart(playerIter, rhymeIter);
            }
            
            System.out.print("The players list is " );
            accessPlayer = players.getIterator();
            displayCollection(accessPlayer);
            System.out.println( );
                  
        }
        
        System.out.println("The winner is " + players.getEntry(1));
    }
    
     /**
     * Display all the items in a collection.  No returns will be used.  
     * The format will be { x1 x2 x3 x4 }
     *
     * @param  iterator   an iterator to the collection
     */
    public static <T> void displayCollection(Iterator<T> iterator)
    {
        // COMPLETE THIS METHOD
        
    }

    
    /**
     * doRhyme - do the rhyme with the players in the list starting at 
     * the iterators current location and remove the selected
     * player if the rhyme runs out before the players
     *
     * @param  playerIter   an iterator to the list of the players
     * @param  rhymeIter   an iterator to the rhyme
     *         
     * 
     * @return Return true if a player has been removed, otherwise return
     *         false if the player iterator ran out and we need a new one
     * 
     */
    public static boolean doRhymePart(Iterator<Integer> playerIter, 
                               Iterator<String> rhymeIter)
    {
        String rhymeWord = null;
        Integer player = null;
        boolean removedAPlayer = false;
        
        // COMPLETE THIS METHOD 
        
        return true;

    }
    
    
    
    
    
    /**
     * Get an integer value
     *
     * @return     an integer 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }
    
    /**
     * getRhyme - get the rhyme
     *
     * @return    a list of words that is the rhyme
     */
    private static ArrayListWithIterator<String> getRhyme()
    {
        Scanner input;
        String inString = "";
        ArrayListWithIterator<String> rhyme = new ArrayListWithIterator<String>();
        
        try
        {
            input = new Scanner(System.in);
            
            System.out.println("Please enter a rhyme");
            inString = input.nextLine().trim();
            
            Scanner rhymeWords = new Scanner(inString);
            while(rhymeWords.hasNext())
            {
                rhyme.add(rhymeWords.next());
            }
            
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use a rhyme of size one");
        }

        // Make sure there is at least one word in the rhyme
        if(rhyme.getLength() < 1)
            rhyme.add("Default");
            
        return rhyme;
                                    
    }
    
}
