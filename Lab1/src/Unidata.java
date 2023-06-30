public class Unidata {
    private String year;
    private String rank;
    private String university;
    private String score;
    private String link;
    private String country;
    private String city;
    private String region;
    private String logo;

    public Unidata(){


    }

    public Unidata(String year, String rank, String university, String score, String link, String country, String city, String region, String logo){
        this.year = year;
        this.rank = rank;
        this.university = university;
        this.score = score;
        this.link = link;
        this.country = country;
        this.city = city;
        this.region = region;
        this.logo = logo;

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Unidata [year=" + year + ", rank=" + rank + ", university=" + university + ", score=" + score
                + ", link=" + link + ", country=" + country + ", city=" + city + ", region=" + region + ", logo=" + logo
                + "]";
    }
    
}
