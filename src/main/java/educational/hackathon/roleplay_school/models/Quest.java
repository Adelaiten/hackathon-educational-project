package educational.hackathon.roleplay_school.models;

public class Quest {
    private int idQuest;
    private String name;
    private String description;
    private double amount;
    private int questType;

    public Quest(int idQuest, String name, String description, double amount, int questType) {
        this.idQuest = idQuest;
        this.name = name;
        this.description = description;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuestType() {
        return questType;
    }

    public void setQuestType(int questType) {
        this.questType = questType;
    }
}
