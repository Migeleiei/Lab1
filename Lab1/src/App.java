import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 1.(1 point) What are the meta data for the given data? please list all
    Ans = 1.year 2.Rank_display 3.University 4.score 5.link 6.country 7.city 8.region 9.logo
    2.(1 point) List all the data type of each attribute
    Ans 1.year is String
        2.Rank_disply is String
        3.University is String
        4.score is String
        5.link is String
        6.Country is String
        7.City is String
        8.region is String
        9.logo is String

    3.[Extra credit ] What problem have you found when you are dealing with the tradition database files? Explain in detail?
(e.g., domain integrity, NULL values, etc.)
(2 points)
    Ans I've encountered an issue where quotation marks in datasets cause splitting to fail by overloading the array.

 */
public class App {

    //TODO: Change depend on Operation System
    static String pathString = "<YourPath>";
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File(pathString+"/QS World University Rankings 2017.csv"));
        
        ArrayList<Unidata> data = new ArrayList<Unidata>();
        

        file.nextLine();
        while (file.hasNext()) {
            String read = file.nextLine();         

            String pattern = "(?:^|,)(\"(?:[^\"]+|\"\")*\"|[^,]*)";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(read);


            ArrayList<String> udataList = new ArrayList<String>();

            while (matcher.find()) {
                String value = matcher.group(1).replaceAll("\"", "");
                udataList.add(value);                
            }

            Unidata unidata = new Unidata();
            unidata.setYear(udataList.get(0));
            unidata.setRank(udataList.get(1));
            unidata.setUniversity(udataList.get(2));
            unidata.setScore(udataList.get(3));
            unidata.setLink(udataList.get(4));
            unidata.setCountry(udataList.get(5));
            unidata.setCity(udataList.get(6));
            unidata.setRegion(udataList.get(7));
            unidata.setLogo(udataList.get(8));

            data.add(unidata);

        } 

      
     

        for(Unidata uni: data){
           System.out.println("                 University");
           System.out.println("             "+uni.getUniversity());
           System.out.println("Year");
           System.out.println("      "+uni.getYear());
           System.out.println("Rank");
           System.out.println("      "+uni.getRank());
           System.out.println("Score");
           System.out.println("      "+uni.getScore());
           System.out.println("Location");
           System.out.println("      "+"Country : "+uni.getCountry()+ " City : " +uni.getCity() + " Region : "+uni.getRegion());
           System.out.println("==============================================");
           System.out.println("");
              
        }

        String cmuUniversity = "2017,3,Chiangmai University,90,https://www.cmu.ac.th/,Thailand,Chiamgmai,Asia,https://www.cmu.ac.th/th/cmu/symbol";
        createNewFile(data,cmuUniversity);
    }


    private static void createNewFile(ArrayList<Unidata> uniList,String CMUDetail){
        String fileName = "QS_World University Rankings 2017_out.csv";

        try {
            
            FileWriter nFile = new FileWriter(fileName);
            StringBuilder sb = new StringBuilder();
            
            for(Unidata unidata: uniList){
                String uniString = unidata.getYear() +","+ unidata.getRank() + "," + unidata.getUniversity() + "," + unidata.getScore() + "," + unidata.getLink() + 
                "," + unidata.getCountry() + "," + unidata.getCity() + "," + unidata.getRegion() + "," + unidata.getLogo();
                  
                sb.append(uniString);
                sb.append(System.lineSeparator());
                
            }

            System.out.println(sb);
            sb.append(CMUDetail);
            sb.append(System.lineSeparator());
            nFile.write(sb.toString());
            nFile.close();       
          

        } catch (Exception e) {
            System.out.println("Create File Error : "+e.toString());
        }

    }

}

