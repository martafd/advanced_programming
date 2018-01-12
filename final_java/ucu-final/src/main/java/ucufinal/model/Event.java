package ucufinal.model;

public class Event {
    private String eventCode;
//    private String eventCodeDescription;
    private String from;
    private String to;
    private String eventTime;
    private String stadion;

    public Event(String rawData) {
        String[] splitted = rawData.split(";");
        this.eventCode = splitted[0].split("=")[1];
//        this.eventCodeDescription = null;
        this.from = splitted[1].split("=")[1];
        this.to = splitted[2].split("=")[1];
        this.eventTime = splitted[3].split("=")[1];
        this.stadion = splitted[4].split("=")[1];
    }

    public String getEventCode() {
        return eventCode;
    }

//    public String getEventCodeDescription() {
//        return eventCodeDescription;
//    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getStadion() {
        return stadion;
    }
}
