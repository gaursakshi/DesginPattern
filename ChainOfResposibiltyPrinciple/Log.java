package ChainOfResposibiltyPrinciple;
class Log {
    private String level;
    private String message;
    Log(String level, String message) {
        this.level = level;
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

}
