import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class recordKeeper {
    public static String file = "records.txt";
    public static String indexFile = "indexes.txt";
    public static FileWriter writer = null;
    public static FileWriter indexWriter = null;
    public static int recordCount = 1;
    public static File indexesFile = new File(indexFile);
    public static File recordFile = new File(file);

        //add or append function to add record to file. Returns 0 if unsuccessful and 1 if successful
        public static int add(int id, String name, int age, int rating) throws Exception {
            FileReader reader = null;
            BufferedReader buffReader = null;
            // String line = "";
            int lineNum = 0;
            try{
                writer = new FileWriter(recordFile, true);
                indexWriter = new FileWriter(indexesFile, true);
                reader = new FileReader(recordFile);
                buffReader = new BufferedReader(reader);
            }
            catch(IOException e){
                System.out.println("Error: " + e);
            }


    
            String fullRecord = id + name + age + rating;
            writer.write(fullRecord+"\n");

            while(buffReader.readLine() != null){
                lineNum++;
            }

            recordCount = lineNum + 1;
            indexWriter.write(id + "|" + recordCount+"\n");
    
    
            writer.close();
            indexWriter.close();
            recordCount++;
            return 1;
        }

        public static int search(int id) throws IOException{
            FileReader reader = null;
            BufferedReader buffReader = null;
            FileReader indexReader = null;
            BufferedReader buffIndexReader = null;
            String line = "";
            String indexLine = "";
            boolean found = false;
            String RRN = "";

            if(id < 100000){
                System.out.println("Error: Please enter a valid ID to search by (format: 123456)");
                return 0;
            }

            try{
                reader = new FileReader(file);
                buffReader = new BufferedReader(reader);
                indexReader = new FileReader(indexFile);
                buffIndexReader = new BufferedReader(indexReader);
            }
            catch(IOException e){
                System.out.println("Error: " + e);
            }

            Integer EID = id;

            while((indexLine = buffIndexReader.readLine())!=null && found == false){
                if(indexLine.contains(EID.toString())){
                    System.out.println("EID Found!");
                    String[] record = indexLine.split("|");
                    RRN = record[1];
                    found = true;
                }
            }

            
            if(found == true){
                System.out.println("Record found at RRN: " + RRN);
                while((line = buffReader.readLine()) != null ){
                    System.out.println(line);
                }
            }
            else{
                System.out.println("Record not found!");
            }

            buffIndexReader.close();
            buffReader.close();
            reader.close();
            indexReader.close();
            return 1;
        }
}
