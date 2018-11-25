package educational.hackathon.roleplay_school.models;

public class Quest {
    private int idQuest;
    private String name;
    private String description;
    private int exp;
    private double amount;
    private String questType;

    public Quest(int idQuest, String name, String description, int exp, double amount, String questType) {
        this.idQuest = idQuest;
        this.name = name;
        this.description = description;
        this.exp = exp;
        this.amount = amount;
        this.questType = questType;
    }

    public int getIdQuest() {
        return idQuest;
    }

    public void setIdQuest(int idQuest) {
        this.idQuest = idQuest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getQuestType() {
        return questType;
    }

    public void setQuestType(String questType) {
        this.questType = questType;
    }
}
