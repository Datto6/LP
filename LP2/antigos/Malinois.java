final class Malinois extends Dog{
    public String profession;
    private String special_quality;
    public void set_Qual(String quality){
        special_quality=quality;
    }
    public Malinois(){}
    public Malinois(String profession, String quality){
        special_quality=quality;
        profession=profession;
    }
}