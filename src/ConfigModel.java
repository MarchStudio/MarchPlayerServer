public class ConfigModel {

    public ConfigModel() {
    }

    public ConfigModel(String Name, String Val) {
        this.Name = Name;
        this.Val = Val;
    }

    public String Name, Val;

    public String toString(){
        return String.format("%s=%s", this.Name, this.Val);
    }
}
