import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("/home/jusuchon/Downloads/Lab1/src/QS World University Rankings 2017.csv"));
        ArrayList<Unidata> data = new ArrayList<Unidata>();
        

        file.nextLine();
        while (file.hasNext()) {
            String read = file.nextLine();
            // StringTokenizer st = new StringTokenizer(read, "," );

            String pattern = "(?:^|,)(\"(?:[^\"]+)*\"|[^,]*)";

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
    }

}
