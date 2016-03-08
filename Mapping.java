
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.io.PrintWriter;


public class Mapping {



    public static void main(String[] file) throws FileNotFoundException, IOException {
    	long startTime = System.currentTimeMillis();

        if (file.length == 0) {

           // System.out.println("Usage: java WordCounter targetfile");

           // System.exit(0);

        }

         // PrintWriter pw;

        BufferedReader bufferedReader = null;

        bufferedReader = new BufferedReader(new FileReader("WarandPeace.txt"));

        String inputLine = null;

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        String outFile = "D:/hello/tf.csv";

       // boolean checkExist = new File(outFile).exists();
 

 

 

        try {

             

            while ((inputLine = bufferedReader.readLine()) != null) {

           // String[] words = inputLine.split("[ \n\t\r.,;:!?(){}]");

            	String[] words = inputLine.split(" ");

                for (int wordCounter = 0; wordCounter < words.length; wordCounter++) {

                    String key = words[wordCounter].toLowerCase();
                    int val = 0;
                    int newVal = 0;
                    if (key.length() > 1) {
                    	if(map.containsKey(key)){
                    		val = map.get(key);
                    		newVal = val + 1;
                    		map.put(key, newVal);
                    	}else
                    		map.put(key, 1);

                        

                     

                        }

                    }
                    PrintWriter pw = null;
                    
                    try{
                    	pw = new PrintWriter(outFile);
                    
                    }catch(FileNotFoundException e) {
                    	System.out.println("Cant open");
                    	
                    	
                    }
                     // FileWriter writer = new FileWriter(outFile);

                    Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

                    for (Map.Entry<String, Integer> entry : entrySet) {

                        pw.println(entry.getValue() + "," + entry.getKey());
                        
                        
                     
                    }
                    pw.flush();
                    pw.close();
                    //System.out.println("Done");
                        
            }
           
            
    		
      
        }
        

        catch (IOException error) {

            System.out.println("Invalid File"); 

        }
        
       
		
                   

       

            bufferedReader.close();
        long endTime = System.currentTimeMillis();
        long finalTime = endTime - startTime;
        System.out.println("the time is" +finalTime);
 

 

        }

    }


