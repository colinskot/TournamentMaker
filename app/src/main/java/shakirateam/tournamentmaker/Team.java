package shakirateam.tournamentmaker;

/**
 * Created by Mark on 2015-12-03.
 */
public class Team {
    private String name;
    private String logo;
    Boolean Gender;

    public Team (String name, String logo, Boolean gender){
        this.name = name;
        this.logo = logo;
        this.Gender = gender;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getLogo(){
        return logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }

    public Boolean getGender(){
        return Gender;
    }
    public void setGender(Boolean gender){
        Gender = gender;
    }


    public String toString(){
        return name + ":" + logo +":" + Gender;
    }
}
