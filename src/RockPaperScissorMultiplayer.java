import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class RockPaperScissorMultiplayer {

	
	
	public static List<Integer> RockPaperScissor ( List<String> persons )
	{
		List<Integer> res = new ArrayList<Integer>();
    if (persons == null)
    	 return res;
	int rounds = 0;
	int points = 0;
	int lastPerson = -1;
	int lastOne = -1;
	boolean gameStop = false;
	while ( !gameStop )
	{       
	       int[ ] result  = new int[3];
	       for ( int i =0; i < persons.size(); i++)
	       {  
	    	   
	    	   if ( rounds < persons.get(i).length() ) 
	    	   {
	            char c =  persons.get(i).charAt(rounds);
	            System.out.print(c);
	                     if ( c == 'R')
	                           result[0]++;
	                     else if ( c== 'P')
	                           result[1]++;
	                     else if ( c == 'S')
	                           result[2]++;
	                     lastOne = i;

	    	   }
	            // persons.set(i, new String ( persons.get(i).substring(1) )) ;
	             //if (persons.get(i).length() != 0)
	            //	 persons.set(i, new String ( persons.get(i).substring(1) )) ; 
	             //else
	           // 	 persons.remove(i);
	            // if (persons.get(i).length() == 0)
	            //	 persons.remove(i);
	            
	  	       // Last person
	   	      //if (persons.size() ==1)
	   	      //  lastPerson = i;
	      }
	       
	      if (  result[0]== 0 && result[1]== 0 && result[2]== 0)
	      {
	    	  gameStop = true;
	      }
	      if ( result[0] ==1 && result[1]== 0 && result[2]== 0)
	    	  lastPerson = lastOne;
	      else if ( result[0] == 0 && result[1]== 1 && result[2]== 0)
	    	  lastPerson = lastOne;
	      else if  ( result[0] ==0 && result[1]== 0 && result[2]== 1)
		    	lastPerson = lastOne;
          // Points
	      
          points += calculateResult(result);
          
	       
	      // Rounds
	      rounds++;
	   }
	   
	   rounds--;
	   res.add(lastPerson);
	   res.add(points);
	   res.add(rounds);
	   System.out.println("Final Result:"+"Last person:"+lastPerson+", points:"+points+", rounds:"+rounds);
	   return res;
	}


	private static int calculateResult(int[] result)
	{
	        int lose = -1;
	        int max = result[0];
	        int win = 0;
	        // Case 1: 0
	        // Case 2: the same
	        // i==1, 
	        //       > max=r[1], win=1   
	        //       < and r[1]!=0, lose=1
	        //       = win=1, lose=0
	        // i==2, 
	        //       > max=r[2], win=2
	        //       < and r[2]==0 and r[0]!=r[1] , lose=2
	        //       < and r[2]!=0, lose=2
	        //       = and r[0]=r[1], lose=-1 and win=-1
	        //       = and r[0]!=r[1], lose=2
	        if ( result[1] > max)
	        {
	        	max = result[1];
	            win =1;	
	        }
	        else if ( result[1] < max && result[1] != 0)
	        	lose =1;
	        else if (result[1] == max )
	        {
	        	win =1;
	        	lose =0;
	        }	
	        
	        if (result[2] > max)
	        {
	        	max = result[2];
	        	win =2;
	        }    
	        else if ( result[2] <max && result[2] ==0 && result[0] != result[1] ) 
	        	lose =2;
	        else if ( result[2] < max && result[2] != 0 && result[0] == result[1])
	        {
	        	win =-1;
	        	lose =2;
	        }	        
	        else if ( result[2] < max && result[2] != 0)
	        	lose =2;
	        else if ( result[2] == max && result[0] == result[1])
	        {
	            win =-1;
	            lose =-1;
	        }
	        else if ( result[2] == max && result[2] == result[1] )
	        {
	        	win =2;
	        	lose =0;
	        }
	        else if ( result[2] == max && result[2] == result[0]) 
	        {
	        	win =1;
	        	lose =2;
	        }
	        
	        
	        //for ( int i = 1; i < 3; i++)
	        //{
	        	
	        	  /*
	              if (result[i] > max  )
	              {
	                    max = result[i];
	                    win = i;
	              }
	              else if (result [i]== max && i ==2 && result[win] == result[lose]  )
	              {
	                    win = -1;
	                    lose = -1;
	              }
		            else if ( i==2 && result[win] == result[lose] && result[i] != 0)
		            {
		                    lose = i;
		                    win =-1;
		            }
	              else if ( result [i]== max  && i ==1 )
	             {
	                    lose = win;
	                    win =i;
	             }       
	              else if ( result[i] < max && i == 2 && result[i]!=0)
	             {
	                     lose = i;
	            }
	            else if ( result[i] < max )
	            {
	                    lose = i;
	            }
	            else if ( i!= 2&& result[i] != 0 && result[win] == result[lose])
	            {
	                    lose = i;
	                    win =-1;
	            }
	            */
	        //}
	        
	     printRoundResult(result, win ,lose);
	        
	     if ( win != -1)
	           return result[win];
	     
	     
	     return 0;
	}
   
	private static void printRoundResult(int[] results, int win, int lose)
	{
		System.out.println("");
		for (int i = 0 ; i < 3 ; i++)
		{	
			
			String str = (win == i )?"+":"";
		    String str2 = (lose == i )?"-":"";
			System.out.print(results[i]+str+str2);  
			if (i==2)
				System.out.println("");
			else
			    System.out.print(" | ");
		}
	}
	
	public static void main (String[] args)
	{
		List<String> persons = Arrays.asList("RRRRRRRR",
				                             "RRRPRRP",
				                             "RRRSRP",
				                             "RPP",
				                             "RPP",
				                             "PPP",
				                             "PS",
				                             "S",
				                             "S",
				                             "S"); 
		RockPaperScissor(persons);
	}
	
	
	
}
